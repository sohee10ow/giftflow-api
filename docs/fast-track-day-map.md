# GiftFlow Fast-Track Day Map

## 사용법
- 사용자가 `Day 1 시작`, `Day 7 시작`, `Week 2 Day 3 시작`, `오늘 뭐하지`라고 하면 이 문서를 기준으로 현재 단계의 목표를 제시한다.
- 기본은 18일(3주) 기준이다.
- 사용자가 2주 모드라고 말하면 Day 15~18의 일부를 축약하거나 생략한다.

---

## Day 1
### 목표
프로젝트 초기 세팅 안정화
### 구현
- health
- application.yml
- swagger
- git
### 공부
- Spring Boot 구조
- RestController
- YAML 설정
### 테스트/확인
- /health 호출
- swagger-ui 접속

## Day 2
### 목표
공통 웹 구조 만들기
### 구현
- ApiResponse
- GlobalExceptionHandler
- traceId 기본 응답 포함
### 공부
- DTO
- Validation
- ExceptionHandler
### 확인
- validation 실패 응답 확인

## Day 3
### 목표
PostgreSQL + JPA 연결
### 구현
- DB 연결
- Flyway 첫 migration
- Product 엔티티/리포지토리
### 공부
- Entity
- JPA save/find
- migration
### 확인
- Product DB 저장 성공

## Day 4
### 목표
Product API 완성
### 구현
- Product create/get/list
- DTO 분리
- validation 적용
### 공부
- request/response DTO
- service 책임
### 확인
- swagger에서 Product API 호출

## Day 5
### 목표
Partner 도메인 추가
### 구현
- Partner 엔티티
- Partner create/get/list
### 공부
- FK 관점 미리 보기
- active/inactive 상태
### 확인
- Partner 저장/조회

## Day 6
### 목표
Inventory 기초
### 구현
- PinBatch / PinInventory 엔티티
- PIN batch 업로드
- 상품별 재고 조회
### 공부
- one-to-many 관계
- inventory 상태값
### 확인
- AVAILABLE count 조회

## Day 7
### 목표
주문 발급 흐름 시작
### 구현
- IssueOrder 엔티티
- order create API
- order 조회 API
### 공부
- Transaction 기초
- partnerOrderId 의미
### 확인
- 주문 생성 후 DB row 확인

## Day 8
### 목표
상태 전이 / 이력
### 구현
- OrderStatus enum
- OrderStatusHistory 엔티티
- 발급 시 이력 저장
### 공부
- 상태 전이
- history table 이유
### 확인
- CREATED/RESERVED/ISSUED 이력 확인

## Day 9
### 목표
취소 흐름 완성
### 구현
- cancel API
- 상태 전이 validator
- invalid transition 예외
### 공부
- 비즈니스 규칙과 예외
### 확인
- 취소 가능 / 불가 케이스

## Day 10
### 목표
중복 방지 1차
### 구현
- issue_order unique constraint
- duplicate partnerOrderId 처리
### 공부
- unique constraint
- application check vs DB check
### 확인
- 동일 partnerOrderId 재요청

## Day 11
### 목표
재고 예약 안정화
### 구현
- AVAILABLE PIN 선택 후 RESERVED 변경
- 예약 실패 시 예외 처리
### 공부
- 오버셀링
- lock 필요성
### 확인
- 재고 부족 시 실패

## Day 12
### 목표
callback 기본 구조
### 구현
- callback_delivery 엔티티
- 주문 성공/취소 시 callback row 생성
- WebClient 전송
### 공부
- 외부 HTTP 호출
- callback 상태 분리
### 확인
- SUCCESS / FAILED 기록

## Day 13
### 목표
retry scheduler
### 구현
- FAILED/PENDING 재시도
- next_retry_at / attempt_count
- DEAD 전환
### 공부
- scheduler
- retry/backoff 기초
### 확인
- mock server 500으로 retry 확인

## Day 14
### 목표
settlement 기초
### 구현
- settlement_daily 엔티티
- 일별 집계 job
- settlement 조회 API
### 공부
- summary table
- 집계 SQL
### 확인
- 하루치 집계 결과 생성

## Day 15
### 목표
핵심 테스트 1
### 구현
- 정상 지급 테스트
- 재고 부족 테스트
- 상태 전이 차단 테스트
### 공부
- integration test
- Given/When/Then
### 확인
- 테스트 3개 통과

## Day 16
### 목표
핵심 테스트 2
### 구현
- 중복 주문 테스트
- callback retry 테스트
- settlement 테스트
### 공부
- 테스트 시나리오 문서화
### 확인
- 테스트 6개 이상 통과

## Day 17
### 목표
문서/포트폴리오 정리
### 구현
- README
- ERD
- 상태 전이 표
- 아키텍처 요약
### 공부
- 왜 이렇게 설계했는지 설명하는 법
### 확인
- README만 보고 흐름 이해 가능

## Day 18
### 목표
시연/면접 대비
### 구현
- 데모 시나리오
- 이력서 bullet
- 코드 정리
### 공부
- 면접에서 자주 받는 질문 정리
### 확인
- 10분 설명 스크립트 완성

---

## 2주 모드 축약 규칙
- Day 15~18을 2일로 압축한다.
- Day 17/18 산출물은 최소 README + ERD + 핵심 테스트 캡처만 남긴다.
- 2주 모드에서는 아래를 생략할 수 있다.
  - traceId 확장
  - redrive
  - CSV export
  - Redis
  - Admin auth

## Day N을 자동으로 해석할 때 원칙
- 현재 코드 상태가 이미 Day N을 넘어가면 다음 미완료 단계로 보정한다.
- 사용자가 너무 막혀 있으면 해당 Day를 더 잘게 쪼개서 1파일/1API/1테스트 단위로 나눈다.
- 사용자가 `너무 많아`라고 하면 그날 목표를 절반으로 줄인다.
