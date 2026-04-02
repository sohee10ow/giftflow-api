# GiftFlow Fast-Track Plan

## 목적
이 문서는 **GiftFlow / giftflow-api**를 **2~3주 안에 포트폴리오 수준으로 완성**하기 위한 압축 실행 계획이다.
기준 원칙은 **완벽함보다 완주**, **설명보다 실행**, **과한 확장보다 핵심 흐름 완성**이다.

---

## 기본 모드
- **기본 모드:** 3주 fast-track
- **공격적 모드:** 2주 fast-track
- 기본적으로 3주 계획을 따르되, 사용자가 `2주 모드`를 선언하면 범위를 더 줄인다.

---

## 이 플랜에서 반드시 남기는 것
### Core Scope
- Product / Partner / PinInventory
- Issue / Lookup / Cancel API
- Order Status History
- `(partner_id, partner_order_id)` unique 기반 중복 방지
- 재고 예약과 상태 전이
- callback_delivery + retry scheduler
- settlement_daily 집계
- 핵심 테스트
- README / ERD / 상태 전이 / 아키텍처 / 운영 포인트 정리

### 후순위 또는 생략 가능
- Admin 인증/권한 분리
- Redis
- CSV export
- callback redrive API
- Testcontainers
- observability 확장
- reconciliation

---

## 성공 기준
### 기능 관점
- 파트너 지급/조회/취소 흐름이 동작한다.
- 재고 부족과 중복 요청이 제어된다.
- callback 실패 시 재시도된다.
- settlement_daily 집계가 생성되고 조회된다.

### 포트폴리오 관점
- README만 읽어도 프로젝트 흐름이 보인다.
- ERD / 상태 전이 / 아키텍처 / 테스트 시나리오가 정리돼 있다.
- 면접에서 아래 질문에 답할 수 있다.
  - 왜 이 도메인을 골랐는가
  - 중복 지급을 어떻게 막았는가
  - 오버셀링을 어떻게 막았는가
  - callback 실패를 어떻게 다뤘는가
  - 정산을 왜 summary table로 분리했는가

### 신뢰성 관점
- 정상 지급 테스트
- 재고 부족 테스트
- 중복 주문 테스트
- 상태 전이 차단 테스트
- callback retry 테스트
- settlement 집계 테스트

---

## 주차별 계획

## Week 1 — 서버 뼈대 + 핵심 도메인 + 주문 기본 흐름
### 목표
- 앱 기본 뼈대를 안정화한다.
- PostgreSQL/JPA/Flyway를 붙인다.
- Product / Partner / Inventory / Order 기본 흐름을 만든다.

### 반드시 끝내야 할 것
- Health + Swagger
- ApiResponse / GlobalExceptionHandler / Validation
- PostgreSQL 연결
- Flyway baseline migration
- Product API
- Partner API
- Pin Batch 업로드 / Inventory 조회
- Issue Order API
- Order 조회 API
- Order Status History 저장

### 공부 포인트
- Controller / Service / Repository 책임
- DTO / Validation
- Entity / JPA / FK
- Transaction 기초
- 상태 전이와 이력 테이블 의미

### 남겨야 할 산출물
- Swagger 캡처
- ERD 초안
- 상태 전이 초안
- README Progress 업데이트

---

## Week 2 — 정합성 + callback
### 목표
- 중복 방지와 재고 정합성을 보강한다.
- callback 전송과 retry를 붙인다.

### 반드시 끝내야 할 것
- `issue_order` unique constraint
- duplicate request 처리 정책 반영
- 재고 예약 로직 정리
- 오버셀링 방지 기본 구조
- callback_delivery 테이블
- callback row 생성
- WebClient 전송
- FAILED → retry → DEAD 흐름

### 공부 포인트
- DB unique vs 애플리케이션 체크
- 왜 DB가 최종 진실인지
- 주문 상태와 callback 상태를 왜 분리하는지
- scheduler / retry / backoff 기초

### 남겨야 할 산출물
- 중복 방지 설명 메모
- callback 흐름 다이어그램
- 실패/재시도 로그 캡처

---

## Week 3 — settlement + 테스트 + 포트폴리오 정리
### 목표
- 포트폴리오 강도가 높은 정산과 테스트를 마무리한다.
- README와 면접용 설명 포인트를 완성한다.

### 반드시 끝내야 할 것
- settlement_daily 테이블
- 일별 집계 job
- settlement 조회 API
- 핵심 테스트 6개 이상
- README 완성
- 이력서 bullet / 데모 시나리오 초안

### 공부 포인트
- 집계 SQL
- integration test 구조
- Given / When / Then
- traceId / 운영 로그 기본

### 남겨야 할 산출물
- 테스트 실행 결과
- README 완성본
- 이력서 bullet 3~5개
- 데모 시나리오

---

## 2주 모드 압축 규칙
### Week 1
- Health / Swagger
- ApiResponse / ExceptionHandler / Validation
- PostgreSQL / JPA / Flyway
- Product / Partner / Inventory
- Issue / Lookup / Cancel
- 상태 이력

### Week 2
- Unique constraint
- 재고 예약 기본 구조
- callback_delivery + retry scheduler
- settlement_daily
- 핵심 테스트 5~6개
- README / ERD / 상태 전이 / 아키텍처 요약

### 2주 모드에서 우선 포기할 것
1. CSV export
2. Admin auth
3. Redis
4. redrive API
5. Testcontainers
6. observability 확장

---

## 품질 컷라인
### 최소 컷
- Order issue / lookup / cancel 동작
- DB 저장과 상태 이력 확인 가능
- 중복 주문 방지 가능
- callback retry 확인 가능
- settlement 집계 확인 가능

### 좋으면 있는 것
- 재고 부족 / 중복 주문 / callback retry 자동화 테스트
- README에 테스트 실행법 정리
- 운영 포인트(runbook) 요약 포함

---

## 하루 운영 규칙
1. 오늘 목표 1개만 정한다.
2. 개념 공부는 30~45분 안에서 끝낸다.
3. 구현은 1~3개 파일 단위로 끊는다.
4. 테스트 또는 Swagger 확인을 꼭 한다.
5. 커밋 1개 이상 남긴다.
6. session-handoff에 다음 재시작 포인트를 남긴다.

---

## 판단 우선순위
1. 지금 이 기능이 포트폴리오 가치에 직접 기여하는가?
2. 지금 이 기능이 다음 기능의 기반이 되는가?
3. 지금 이 개념을 바로 코드에 적용할 수 있는가?
4. 지금 이 테스트가 신뢰성을 설명하는 데 도움이 되는가?
5. 지금 바로 손을 움직일 수 있는가?

---

## 이번 플랜의 핵심 철학
이 fast-track 플랜은 **모든 기능을 다 만드는 계획이 아니라**,
**GiftFlow의 강점이 보이는 기능만 빠르게 완성하는 계획**이다.

즉, 핵심은 다음이다.
- 단순 CRUD보다 **상태 전이**
- 기능 수보다 **정합성**
- 이벤트 흉내보다 **callback retry**
- 멋진 아키텍처보다 **설명 가능한 구조**
