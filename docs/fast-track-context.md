# GiftFlow Fast-Track Context

## 프로젝트 한 줄 요약
GiftFlow는 **외부 파트너가 API로 기프티콘을 지급/조회/취소**할 수 있고, 시스템이 **중복 방지, PIN 재고 관리, callback 재시도, 일별 정산 집계**까지 처리하는 B2B 백엔드 플랫폼이다.

## 왜 이 도메인이 좋은가
이 프로젝트는 단순 CRUD가 아니라 아래 백엔드 핵심 포인트를 모두 보여준다.
- DB 모델링
- 중복 요청 방지
- 재고 동시성 제어
- 상태 전이
- 외부 callback 실패 복구
- 정산 집계
- 테스트와 운영성

## Fast-Track 목표
2~3주 안에 아래를 포트폴리오 수준으로 만드는 것.

### 반드시 살아야 하는 기능
1. Product / Partner / PIN Inventory
2. Issue Order / Lookup / Cancel
3. Order Status History
4. DB Unique 기반 중복 방지
5. 재고 예약과 오버셀링 방지의 기본 구조
6. callback_delivery + retry scheduler
7. settlement_daily 집계
8. 핵심 통합 테스트
9. README / ERD / 상태 전이 / 아키텍처 요약

### 시간이 부족하면 미루는 기능
- CSV export
- Reconciliation
- 관리자 인증 고도화
- Redis
- redrive API
- Testcontainers
- Metrics / Grafana

## 핵심 도메인 엔티티
- Partner
- Product
- PinBatch
- PinInventory
- IssueOrder
- OrderStatusHistory
- CallbackDelivery
- SettlementDaily

## 핵심 상태
### 주문 상태
- CREATED
- RESERVED
- ISSUED
- FAILED
- CANCEL_REQUESTED
- CANCELLED
- CANCEL_FAILED

### PIN 상태
- AVAILABLE
- RESERVED
- ISSUED
- CANCELLED
- EXPIRED

### callback 상태
- PENDING
- SUCCESS
- FAILED
- DEAD

## 지금 설계의 핵심 원칙
1. 배포는 하나, 내부는 모듈러 모놀리식
2. DB가 최종 진실
3. 주문 상태와 callback 상태를 분리
4. 처음부터 복잡한 인프라를 넣지 않음
5. 학습은 `공부 -> 바로 적용 -> 테스트 -> 커밋` 순서로 감

## 구현 우선순위
### Tier 1 (무조건)
- Product / Partner / Inventory CRUD
- Issue / Lookup / Cancel
- 상태 이력
- Unique constraint
- 기본 callback 전송/재시도
- settlement 집계
- 통합 테스트

### Tier 2 (되면 좋음)
- Redis idempotency 보조
- Admin redrive
- Admin auth
- CSV export

### Tier 3 (이번 압축 플랜에선 제외 가능)
- Reconciliation
- Circuit Breaker
- Role 세분화
- Metrics dashboard

## 테스트 우선순위
### 반드시 자동화
- 정상 지급
- 재고 부족
- 중복 partnerOrderId
- 상태 전이 차단
- callback retry
- settlement 집계

## 면접에서 말해야 하는 포인트
- 왜 이 도메인을 골랐는가
- 중복 주문을 어떻게 막았는가
- 오버셀링을 어떻게 방지했는가
- callback 실패와 주문 실패를 왜 분리했는가
- 정산 집계를 왜 summary table로 뒀는가
- 어떤 테스트로 신뢰성을 검증했는가
