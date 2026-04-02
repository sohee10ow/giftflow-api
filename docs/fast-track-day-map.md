# GiftFlow Fast-Track Day Map

## 사용 규칙
- 사용자가 `Day N 시작` 또는 `Week 2 Day 3 시작`이라고 하면 이 문서를 기준으로 해당 단계 목표를 제시한다.
- 기본은 **18일 / 3주** 기준이다.
- 사용자가 `2주 모드`를 선언하면 Day 15~18을 강하게 압축한다.
- Codex는 항상 **현재 코드 상태가 이 문서보다 앞서 있는지 먼저 확인**하고, 이미 끝난 단계면 다음 미완료 단계로 보정한다.

---

## Day 1 — 프로젝트 부팅
### 목표
프로젝트 기본 세팅을 완료한다.
### 구현
- application.yml
- health API
- Git / GitHub
- Swagger
### 공부
- Spring Boot 구조
- RestController
- YAML 설정
### 테스트/확인
- /health 호출
- swagger-ui 접속
### 산출물
- 첫 커밋

## Day 2 — 웹 계층 공통 뼈대
### 목표
API 공통 응답과 예외 구조를 만든다.
### 구현
- ApiResponse
- ErrorResponse 또는 공통 에러 포맷
- GlobalExceptionHandler
- validation 실패 응답
### 공부
- DTO
- Validation
- ExceptionHandler
### 테스트/확인
- validation 실패 응답 확인
### 산출물
- 공통 응답 예시

## Day 3 — DB 연결 시작
### 목표
PostgreSQL / JPA / Flyway를 연결한다.
### 구현
- PostgreSQL datasource
- JPA 설정
- Flyway baseline migration
- Product 엔티티/리포지토리 시작
### 공부
- Entity
- JPA save/find
- migration
### 테스트/확인
- Product DB 저장 성공
### 산출물
- 첫 migration

## Day 4 — Product API
### 목표
Product 도메인을 완성한다.
### 구현
- Product create/get/list
- request/response DTO
- validation
### 공부
- service 책임
- DTO 분리 이유
### 테스트/확인
- Swagger에서 Product API 호출
### 산출물
- Product API 캡처

## Day 5 — Partner API
### 목표
Partner 도메인을 추가한다.
### 구현
- Partner 엔티티
- Partner create/get/list
- active/inactive 상태
### 공부
- 상태값 모델링
- FK 관점 미리 보기
### 테스트/확인
- Partner 저장/조회
### 산출물
- Partner 상태 정의

## Day 6 — Inventory 기초
### 목표
PIN 재고 구조를 세운다.
### 구현
- PinBatch
- PinInventory
- batch 업로드
- 상품별 재고 조회
### 공부
- one-to-many
- inventory 상태값
### 테스트/확인
- AVAILABLE count 조회
### 산출물
- inventory 조회 결과

## Day 7 — Order Issue 시작
### 목표
주문 발급 흐름을 시작한다.
### 구현
- IssueOrder 엔티티
- issue API
- order 조회 API
### 공부
- Transaction 기초
- partnerOrderId 의미
### 테스트/확인
- 주문 생성 후 DB row 확인
### 산출물
- issue API 초안

## Day 8 — 상태 전이와 이력
### 목표
주문 상태와 이력을 저장한다.
### 구현
- OrderStatus enum
- OrderStatusHistory
- CREATED → RESERVED → ISSUED 이력 저장
### 공부
- 상태 전이
- history table 이유
### 테스트/확인
- 상태 이력 조회
### 산출물
- 상태 전이 표 초안

## Day 9 — Cancel 흐름
### 목표
취소 API를 완성한다.
### 구현
- cancel API
- 상태 전이 validator
- invalid transition 예외
### 공부
- 비즈니스 규칙과 예외
### 테스트/확인
- 취소 가능 / 불가 케이스
### 산출물
- cancel 흐름 메모

## Day 10 — 중복 방지 1차
### 목표
DB 기준 중복 방지를 넣는다.
### 구현
- `(partner_id, partner_order_id)` unique
- duplicate partnerOrderId 처리
### 공부
- unique constraint
- app check vs DB check
### 테스트/확인
- 동일 partnerOrderId 재요청
### 산출물
- 중복 방지 설명 메모

## Day 11 — 재고 예약 안정화
### 목표
재고 예약과 부족 케이스를 안정화한다.
### 구현
- AVAILABLE PIN 선택
- RESERVED 상태 변경
- 재고 부족 예외
- 실패 시 복구 규칙 점검
### 공부
- 오버셀링
- lock 필요성
### 테스트/확인
- 재고 부족 시 실패
### 산출물
- 재고 상태 전이 표

## Day 12 — callback 기본 구조
### 목표
callback_delivery와 외부 전송을 붙인다.
### 구현
- callback_delivery 엔티티
- 주문 성공/취소 시 callback row 생성
- WebClient 전송
### 공부
- 외부 HTTP 호출
- callback 상태 분리 이유
### 테스트/확인
- SUCCESS / FAILED 기록
### 산출물
- callback payload 예시

## Day 13 — retry scheduler
### 목표
실패 callback 재시도를 구현한다.
### 구현
- scheduler
- next_retry_at / attempt_count
- FAILED → retry → DEAD
### 공부
- scheduler
- retry / backoff
### 테스트/확인
- mock server 500으로 retry 확인
### 산출물
- retry 흐름 그림

## Day 14 — settlement 기초
### 목표
일별 정산 집계를 만든다.
### 구현
- settlement_daily 엔티티
- 집계 job
- settlement 조회 API
### 공부
- summary table
- 집계 SQL
### 테스트/확인
- 하루치 집계 결과 생성
### 산출물
- settlement 쿼리 메모

## Day 15 — 핵심 테스트 1
### 목표
도메인 핵심 흐름 테스트를 시작한다.
### 구현
- 정상 지급 테스트
- 재고 부족 테스트
- 상태 전이 차단 테스트
### 공부
- integration test
- Given / When / Then
### 테스트/확인
- 테스트 3개 통과
### 산출물
- 테스트 실행 캡처

## Day 16 — 핵심 테스트 2
### 목표
중복/재시도/정산 테스트를 넣는다.
### 구현
- 중복 주문 테스트
- callback retry 테스트
- settlement 테스트
### 공부
- 테스트 시나리오 문서화
### 테스트/확인
- 테스트 6개 이상 통과
### 산출물
- 테스트 시나리오 정리

## Day 17 — 문서 정리
### 목표
문서와 포트폴리오 산출물을 정리한다.
### 구현
- README
- ERD
- 상태 전이 표
- 아키텍처 요약
- 운영 포인트
### 공부
- 설계 설명 구조화
### 테스트/확인
- README만 보고 흐름 이해 가능
### 산출물
- README 초안 또는 완성본

## Day 18 — 시연/면접 대비
### 목표
시연과 면접 설명 포인트를 만든다.
### 구현
- 데모 시나리오
- 이력서 bullet
- 주요 트레이드오프 메모
### 공부
- 왜 이렇게 설계했는지 말하는 연습
### 테스트/확인
- 10분 설명 가능 여부 점검
### 산출물
- 데모 스크립트

---

## 2주 모드 압축
### 압축 원칙
- Day 1~14 중심으로 완료한다.
- Day 15~18은 2일 안에 최소 산출물만 남긴다.

### 최소 남길 것
- README
- ERD
- 상태 전이 표
- 핵심 테스트 결과 캡처

### 2주 모드에서 생략 가능
- CSV export
- Admin auth
- Redis
- redrive
- traceId 확장
- Testcontainers

---

## 보정 규칙
- 현재 코드 상태가 Day N을 이미 넘으면 다음 미완료 단계로 이동한다.
- 사용자가 `너무 많아`라고 하면 해당 Day를 **1파일 / 1API / 1테스트** 단위로 더 쪼갠다.
- 사용자가 `코드리뷰 해줘`라고 하면 해당 Day의 목표 달성 여부 중심으로 본다.
- 사용자가 `CS 설명해줘`라고 하면 그 Day에 필요한 개념만 짧게 설명한다.
