# GiftFlow Current Status

## 프로젝트
- 이름: **GiftFlow / giftflow-api**
- 목표: **서버 개발자로 전환하기 위한 학습형 Spring Boot 백엔드 포트폴리오**
- 모드: **3주 fast-track 기본 / 2주 모드 가능**
- 마지막 재확인: **2026-04-27 회사에서 Day 6 진입**

---

## 현재 기준 기술 스택
- Java 21
- Spring Boot 3.5.13
- Spring MVC
- Gradle - Groovy
- Validation
- Lombok
- DevTools
- Swagger/OpenAPI (설정 완료 여부 확인 필요)
- PostgreSQL / JPA / Flyway

---

## 마지막으로 확인된 완료 사항
- [x] IntelliJ에서 Spring Boot 프로젝트 생성
- [x] Java 21 설정
- [x] application.yml 생성
- [x] `GET /health` API 구현
- [x] Git repository 생성
- [x] GitHub 원격 저장소 연결
- [x] 첫 커밋 완료
- [x] Swagger/OpenAPI 설정 및 실행 확인
- [x] `ApiResponse` 공통 응답 구조 추가
- [x] `GlobalExceptionHandler` 추가
- [x] PostgreSQL 연결
- [x] JPA / Flyway 연결
- [x] 첫 migration(`V1__init.sql`) 추가
- [x] Product 엔티티 / 리포지토리 추가
- [x] Product create API DB 저장 전환
- [x] Product 단건 조회 API 추가
- [x] Product 목록 조회 API 추가
- [x] Product 조회 실패 `404` 공통 응답 처리
- [x] Product 요청 검증(`name`, `price`) 적용
- [x] Product 성공/실패 응답 공통 포맷 확인
- [x] Partner 테이블 migration 추가
- [x] Partner 엔티티 / 리포지토리 추가
- [x] Partner create API 추가
- [x] Partner 단건 조회 API 추가
- [x] Partner 목록 조회 API 추가
- [x] PinInventory 테이블 migration 추가

### 현재 확인된 구조
- 루트 패키지: `com.giftflow.api`
- 메인 클래스: `GiftflowApiApplication`
- `health` 패키지 존재
- `HealthController` 존재
- `common` 패키지 존재
- `product` 패키지 존재
- `partner` 패키지 존재
- `inventory` 패키지 시작됨
- `OpenApiConfig` 존재
- `GlobalExceptionHandler` 존재
- `ProductController`는 create/get/list를 JPA 기반으로 처리
- `PartnerController`는 create/get/list를 JPA 기반으로 처리

---

## 현재 단계 해석
- **Day 5 완료**
- 현재는 **Day 6 Inventory 기초** 진행 중
- `V3__add_pin_inventory.sql`은 완료했고, `PinInventoryEntity` / `PinInventoryRepository` 초안 작성 중

---

## 현재 초점
### 1순위
- `PinInventoryEntity` 필드와 JPA 매핑 완성

### 2순위
- `PinInventoryRepository`를 `JpaRepository`로 전환

### 3순위
- batch 업로드 API로 넘어가기 전 inventory 상태값 정의

---

## 아직 시작하지 않은 핵심 항목
- Inventory API
- Issue / Lookup / Cancel API
- 상태 이력
- callback_delivery
- settlement_daily
- 테스트 코드

---

## fast-track 기준 현재 진행률
### Week 1
- [x] 프로젝트 세팅
- [x] health API
- [x] Git/GitHub
- [x] Swagger 확정
- [x] ApiResponse / ExceptionHandler
- [x] PostgreSQL / JPA / Flyway
- [x] Product
- [x] Partner
- [ ] Inventory
- [ ] Order Issue / Lookup
- [ ] Status History

### Week 2
- [ ] Unique constraint
- [ ] 재고 예약 / 중복 방지
- [ ] callback_delivery
- [ ] retry scheduler

### Week 3
- [ ] settlement_daily
- [ ] 핵심 테스트
- [ ] README / ERD / 상태 전이 / 면접 포인트

---

## 바로 다음 액션
### 기본값
1. `PinInventoryEntity`에 `id`, `productId`, `pinCode`, `status`, `createdAt`, `updatedAt` 필드를 추가한다.
2. `@Id`, `@GeneratedValue`, `@Column` 매핑을 붙인다.
3. `PinInventoryRepository`를 `JpaRepository<PinInventoryEntity, Long>`로 만든다.

### 다음에 손댈 가능성이 높은 파일
- `src/main/java/com/giftflow/api/inventory/PinInventoryEntity.java`
- `src/main/java/com/giftflow/api/inventory/PinInventoryRepository.java`
- `src/main/resources/db/migration/V3__add_pin_inventory.sql`
- `docs/session-handoff.md`

---

## Codex용 해석 규칙
- `현재 코드 상태 > 문서 추정 상태`를 우선한다.
- Day 2 검증/응답 구조가 끝났으면 Day 3 기준으로 보정한다.
- 사용자가 `다시시작`이라고 하면 session-handoff와 함께 이 문서를 먼저 참고한다.

---

## 현재 기준 성공 정의
- 앱이 바로 실행된다.
- `/health`가 동작한다.
- Swagger가 동작한다.
- Product create/get/list API가 DB 기반으로 동작한다.
- 없는 Product 조회 시 `404` 공통 응답이 반환된다.
- Partner create/get/list API가 DB 기반으로 동작한다.
- PinInventory 테이블 migration이 존재한다.
- 다음으로 PinInventory Entity/Repository를 완성할 수 있다.
