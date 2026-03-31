# Study Agent Context

이 문서는 GiftFlow 프로젝트의 **학습용 condensed context**다.
Codex는 이 문서를 바탕으로 사용자의 현재 구현 단계와 다음 학습/구현 단계를 안내한다.

---

## 1. 프로젝트 한 줄 요약
GiftFlow는 **B2B 기프티콘 지급 / 취소 / 정산 API 플랫폼**이다.
파트너사가 API로 지급 요청을 보내면, 시스템은 상품/PIN 재고를 확인하고 주문을 생성하며, 상태 이력을 남기고, callback을 전송하고, 이후 일별 정산까지 수행한다.

---

## 2. 이 프로젝트가 해결하는 문제
### 비즈니스 문제
- 같은 요청이 여러 번 들어와 **중복 지급**이 발생할 수 있다.
- 재고가 적을 때 동시에 요청이 몰리면 **오버셀링**이 발생할 수 있다.
- 지급은 성공했는데 callback이 실패해 **파트너와 상태가 어긋날 수 있다.**
- 월말 집계 시 지급/취소/환불 숫자가 맞지 않아 **정산과 대사**가 필요하다.
- 운영자가 수동 처리한 이력이 없으면 **사후 추적이 어렵다.**

### 기술 문제
- 단순 CRUD만으로는 백엔드 역량이 드러나지 않는다.
- 트랜잭션, 락, 정합성, retry, 배치, 운영성 같은 포인트가 드러나야 한다.
- 면접에서 "왜 이렇게 설계했는지" 설명 가능한 구조가 필요하다.

---

## 3. 핵심 사용자
### Partner Developer
- API Key를 받아 우리 시스템과 연동한다.
- 지급 요청을 보낸다.
- 주문 상태를 조회한다.
- callback을 수신한다.

### Admin Operator
- 파트너를 등록한다.
- 상품과 PIN 재고를 등록한다.
- 실패 callback을 재처리한다.
- 주문 이력과 상태 변경 이력을 조회한다.

### Settlement Manager
- 일별 지급/취소 건을 집계한다.
- 파트너별 정산 데이터를 조회한다.
- CSV를 내려받아 외부 집계와 비교한다.

---

## 4. 전체 흐름
1. 운영자가 상품과 PIN 재고를 등록한다.
2. 운영자가 파트너를 등록하고 API Key를 발급한다.
3. 파트너가 `partnerOrderId`와 함께 지급 요청을 보낸다.
4. 시스템이 중복 여부를 확인하고 재고를 예약한다.
5. 주문을 생성하고 상태 이력을 남긴다.
6. 지급 결과를 파트너 callback URL로 전송한다.
7. 실패 callback은 재시도되고 필요 시 redrive된다.
8. 일별 배치가 지급/취소 데이터를 집계해 정산 테이블을 만든다.
9. 운영자가 정산 결과를 조회하거나 CSV로 내려받는다.

---

## 5. 핵심 기술 선택
- Java 21
- Spring Boot 3.x
- Spring MVC
- PostgreSQL
- Redis
- Spring Data JPA
- 필요 시 JdbcTemplate / Native Query
- Spring Scheduler
- Flyway
- springdoc OpenAPI
- Spring Security
- WebClient
- JUnit 5 / Spring Boot Test / Testcontainers

### 기술 선택 원칙
1. **모듈러 모놀리식**으로 시작한다.
2. **DB가 최종 진실**이며 Redis는 보조 수단이다.
3. 주문 상태와 callback 상태를 분리한다.
4. 먼저 단순하게 만들고, 그다음 안정화한다.

---

## 6. 패키지 구조 원칙
```text
com.giftflow
 ┣ common
 ┃ ┣ config
 ┃ ┣ exception
 ┃ ┣ response
 ┃ ┣ security
 ┃ ┗ util
 ┣ partner
 ┣ product
 ┣ inventory
 ┣ order
 ┣ callback
 ┣ settlement
 ┗ admin
```

---

## 7. 핵심 엔티티
- `partner`
- `partner_api_key`
- `product`
- `pin_batch`
- `pin_inventory`
- `issue_order`
- `order_status_history`
- `callback_delivery`
- `settlement_daily`
- `admin_user`

### 관계 핵심만 기억할 것
- Partner 1:N Order
- Product 1:N PinInventory
- IssueOrder 1:N OrderStatusHistory
- IssueOrder 1:N CallbackDelivery
- Partner 1:N SettlementDaily

---

## 8. 상태 전이
### 주문 상태
- `CREATED`
- `RESERVED`
- `ISSUED`
- `FAILED`
- `CANCEL_REQUESTED`
- `CANCELLED`
- `CANCEL_FAILED`

### 기본 전이
- `CREATED -> RESERVED -> ISSUED`
- `CREATED -> FAILED`
- `RESERVED -> FAILED`
- `RESERVED -> CANCELLED`
- `ISSUED -> CANCEL_REQUESTED -> CANCELLED`
- `ISSUED -> CANCEL_REQUESTED -> CANCEL_FAILED`

### PIN 상태
- `AVAILABLE -> RESERVED -> ISSUED`
- `RESERVED -> AVAILABLE`
- `ISSUED -> CANCELLED`
- `AVAILABLE -> EXPIRED`

### callback 상태
- `PENDING`
- `SUCCESS`
- `FAILED`
- `DEAD`

---

## 9. 핵심 비즈니스 규칙
1. `(partner_id, partner_order_id)`는 유일해야 한다.
2. `AVAILABLE` PIN만 주문에 배정할 수 있다.
3. `AVAILABLE`이 아닌 PIN은 다른 주문에 할당될 수 없다.
4. 모든 주문 상태 변경은 이력 테이블에 남아야 한다.
5. callback 실패는 주문 실패와 동일하지 않다.
6. 정산 집계는 날짜/파트너 기준으로 재실행 가능해야 한다.
7. Redis는 빠른 감지용이고 최종 보장은 DB가 담당한다.

---

## 10. API 규칙
### Base Path
- Partner API: `/partner-api/v1`
- Admin API: `/admin-api/v1`

### 공통 헤더
- `X-API-Key`
- `Idempotency-Key`
- `X-Trace-Id`

### 공통 응답 포맷
```json
{
  "code": "OK",
  "message": "success",
  "traceId": "string",
  "data": {}
}
```

### 주요 Partner API
- `POST /partner-api/v1/orders/issue`
- `GET /partner-api/v1/orders/{partnerOrderId}`
- `POST /partner-api/v1/orders/{partnerOrderId}/cancel`

### 주요 Admin API
- 파트너 등록 / API Key 재발급
- 상품 등록
- PIN 배치 업로드
- 재고 조회
- 주문 상세 조회
- 실패 callback 조회 / redrive
- 일별 정산 조회 / CSV 다운로드

---

## 11. 비기능 요구사항
- 주문 생성과 재고 예약은 한 트랜잭션 경계에서 처리되어야 한다.
- 같은 요청이 재시도돼도 중복 지급되지 않아야 한다.
- 로그에 traceId, partnerId, partnerOrderId, orderId가 남아야 한다.
- 핵심 시나리오는 자동화 테스트로 검증되어야 한다.
- callback retry와 정산 집계는 재실행해도 안전해야 한다.
- 로컬 환경은 Docker Compose로 재현 가능해야 한다.

---

## 12. 테스트 전략
### 테스트 레벨
- Unit Test: 상태 전이 validator, 금액 계산
- Integration Test: 지급/조회/취소, 중복 방지
- Concurrency Test: 동시 지급, 오버셀링 방지
- Scheduler Test: callback retry, settlement job
- Smoke Test: 전체 흐름 점검

### 반드시 자동화할 것
- 정상 지급
- 재고 부족
- 중복 partnerOrderId
- 동일 Idempotency-Key 재요청
- 상태 전이 차단
- callback retry / dead / redrive
- 일별 정산 집계

### 테스트 작성 원칙
- 테스트 이름은 시나리오 중심
- Given / When / Then 적극 사용
- 테스트가 도메인 규칙 문서 역할도 하게 만들 것

---

## 13. 운영 관점에서 중요 포인트
### 로그 필드
- traceId
- partnerId
- partnerOrderId
- orderId
- productCode
- callbackDeliveryId
- attemptCount
- orderStatus
- callbackStatus

### 운영자가 자주 보는 문제
- 중복 주문 의심
- 오버셀링 의심
- callback 실패 증가
- 정산 수치 불일치
- 특정 파트너 실패율 급증

### 수동 처리 원칙
- 직접 DB UPDATE 하지 않는다.
- 가능한 admin API를 통해 처리한다.
- 수동 처리 사유를 이력으로 남긴다.

---

## 14. 학습 원칙
### 추천 루프
**학습 -> 적용 -> 확인 -> 기록**

### 우선순위
#### A. 지금 당장 필요한 것
- HTTP / REST
- Spring Boot 기본 구조
- Validation
- JPA 기본
- SQL / 인덱스 / unique
- Transaction
- 예외 처리
- Integration Test

#### B. 구현하다가 필요한 것
- Redis
- Lock 전략
- WebClient
- Scheduler
- Spring Security
- Flyway

#### C. 후반에 배우면 되는 것
- Batch
- Metrics / Observability
- Query tuning
- Circuit Breaker

#### D. 지금은 안 해도 되는 것
- Kafka
- Kubernetes
- MSA
- CQRS
- Event Sourcing
- 복잡한 DDD 전술 패턴

---

## 15. 주차별 큰 흐름
### 1주차
- Spring Boot 기본, HTTP, Validation
- health, product CRUD
- Swagger, 프로젝트 구조

### 2주차
- JPA, ERD, 인덱스, Flyway
- partner / product / pin inventory 모델링

### 3~4주차
- 주문 생성/조회
- 상태 전이
- 이력 테이블
- 취소 흐름

### 5주차
- unique constraint
- idempotency
- 락 / 동시성 제어
- Redis 보조 제어

### 6~7주차
- WebClient
- callback 전송
- retry / dead / redrive
- scheduler

### 8주차 이후
- 정산 집계
- 인증/인가
- Testcontainers
- 운영 로그 / traceId

---

## 16. 면접/포트폴리오 관점에서 꼭 말할 수 있어야 할 것
- 왜 이 도메인을 골랐는가
- 중복 주문을 어떻게 막았는가
- 오버셀링을 어떻게 방지했는가
- 주문 상태와 callback 상태를 왜 분리했는가
- callback 장애 시 어떻게 복구되는가
- 정산 집계를 왜 summary 테이블로 설계했는가
- 어떤 테스트로 신뢰성을 검증했는가

---

## 17. Study Agent가 항상 챙겨야 할 것
1. 지금 단계에서 필요한 개념 2~3개
2. 구현할 파일은 최소 범위
3. 테스트 포인트 최소 1개
4. 실무 포인트 최소 1개
5. 이해 확인 질문 1~2개
6. 다음 단계는 한 번에 많이 주지 않기

