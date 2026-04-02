# GiftFlow 2~3주 Fast-Track Plan

## 먼저 결론
- **권장안: 3주(18일 내외)**
- **초압축안: 2주(14일 내외)**

3주면 포트폴리오 완성도까지 노릴 수 있고,
2주는 "핵심 흐름 + 핵심 테스트 + README"까지 끊는 최소 컷이다.

## 운영 원칙
- 하루 총 2.5~4시간 기준
- 매일 30~45분은 개념 공부, 나머지는 구현과 테스트
- 매일 끝날 때 커밋 1개 이상
- 매 3일마다 README/문서 10분 업데이트
- 완벽주의 금지, 동작과 설명 가능성을 우선

## 스코프 동결
### 이번 압축 플랜에서 포함
- Product / Partner / PinInventory
- Order Issue / Get / Cancel
- 상태 전이 / 상태 이력
- DB Unique 기반 중복 방지
- callback 전송 + retry scheduler
- settlement_daily 집계
- 핵심 통합 테스트
- README / ERD / 상태 전이도 / 아키텍처 요약

### 이번 압축 플랜에서 제외 또는 후순위
- Admin 인증/권한 분리
- Redis
- CSV export
- redrive API
- Docker Compose 고도화
- Testcontainers
- 메트릭/대시보드
- Reconciliation

---

## 3주 권장안

### Week 1 — 뼈대 + 도메인 + 주문 흐름
#### 목표
- 서버 뼈대 안정화
- DB/JPA 연결
- Product / Partner / Inventory / Order / Cancel까지 연결

#### 반드시 끝내야 할 것
- Health + Swagger
- 공통 응답 / 글로벌 예외 처리
- PostgreSQL + JPA + Flyway
- Product CRUD
- Partner CRUD
- Pin Batch 업로드 / Inventory 조회
- Issue Order API
- Lookup API
- Cancel API
- Order Status History

#### 공부 포인트
- Controller / Service / Repository
- DTO / Validation
- Entity / JPA / FK
- Transaction 기초
- 상태 전이 설계

#### 주간 산출물
- Swagger 캡처
- ERD 초안
- 상태 전이 표 초안
- README Progress 섹션

### Week 2 — 정합성 + callback
#### 목표
- 중복 방지와 재고 안정성
- callback 전송/재시도까지 연결

#### 반드시 끝내야 할 것
- `(partner_id, partner_order_id)` unique constraint
- duplicate request 처리
- 재고 예약 로직 정리
- 오버셀링 방지 기본 구조
- callback_delivery 테이블
- callback 생성
- WebClient 전송
- 실패 시 retry scheduler
- DEAD 상태 전환

#### 공부 포인트
- DB unique vs application check
- lock이 왜 필요한가
- callback 상태 분리 이유
- scheduler / retry / backoff 기초

#### 주간 산출물
- 동시성/중복 방지 설명 메모
- callback 흐름 다이어그램
- 실패/재시도 로그 캡처

### Week 3 — 정산 + 테스트 + 포트폴리오
#### 목표
- 포트폴리오 가치가 보이는 마지막 핵심
- 신뢰성을 테스트와 문서로 남기기

#### 반드시 끝내야 할 것
- settlement_daily 테이블
- 일별 집계 job
- settlement 조회 API
- 핵심 테스트 6개 이상
- README 정리
- 면접용 설명 포인트 정리

#### 핵심 테스트
- 정상 지급
- 재고 부족
- 중복 partnerOrderId
- 상태 전이 차단
- callback retry / dead
- settlement 집계

#### 공부 포인트
- 집계 SQL
- integration test 구조
- Given / When / Then
- traceId와 운영 로그 기본

#### 주간 산출물
- 테스트 결과 캡처
- README 완성본
- 이력서 bullet 3~5개
- 데모 시나리오

---

## 2주 초압축안

### Week 1
- Health / Swagger
- PostgreSQL / JPA / Flyway
- Product / Partner / Inventory
- Issue / Lookup / Cancel
- 상태 이력
- 공통 응답 / 예외 처리

### Week 2
- Unique constraint
- 기본 재고 예약 구조
- callback_delivery + retry scheduler
- settlement_daily
- 핵심 테스트 5개
- README / ERD / 상태 전이 / 아키텍처 요약

### 2주 모드에서 과감히 뺄 것
- Redis
- Admin auth
- redrive
- CSV export
- Testcontainers
- observability 확장

---

## Day 단위 공통 루틴
1. 오늘 목표 확인 (5분)
2. 필요한 개념 1~3개 공부 (30~45분)
3. 구현 (90~150분)
4. 테스트 / Swagger 확인 (20~40분)
5. 커밋 / 문서 메모 (10~20분)

## 각 주차의 컷라인
### 1주차 끝
- Order issue / cancel / lookup가 동작해야 함
- DB 저장과 상태 이력이 보여야 함

### 2주차 끝
- 중복 방지 + callback retry가 보여야 함

### 3주차 끝
- settlement + 핵심 테스트 + README까지 있어야 함

## 이 플랜의 철학
이번 압축 플랜은 **모든 기능을 다 만드는 계획이 아니라, 포트폴리오에서 강하게 보이는 기능만 빠르게 완성하는 계획**이다.
