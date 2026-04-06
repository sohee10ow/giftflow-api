# GiftFlow Current Status

## 프로젝트
- 이름: **GiftFlow / giftflow-api**
- 목표: **서버 개발자로 전환하기 위한 학습형 Spring Boot 백엔드 포트폴리오**
- 모드: **3주 fast-track 기본 / 2주 모드 가능**
- 마지막 재확인: **2026-04-06 집에서 Day 3 시작**

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
- PostgreSQL / JPA / Flyway (**아직 미연결**)

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
- [x] Product create API 초안 작성
- [x] Product 요청 검증(`name`, `price`) 적용
- [x] Product 성공/실패 응답 공통 포맷 확인

### 현재 확인된 구조
- 루트 패키지: `com.giftflow.api`
- 메인 클래스: `GiftflowApiApplication`
- `health` 패키지 존재
- `HealthController` 존재
- `common` 패키지 존재
- `product` 패키지 존재
- `OpenApiConfig` 존재
- `GlobalExceptionHandler` 존재
- `ProductController`는 아직 DB 저장 없이 임시 응답 반환

---

## 현재 단계 해석
- **Day 2 완료**
- 현재는 Day 3인 PostgreSQL / JPA / Flyway 연결로 넘어갈 시점
- Product API는 아직 DB 연결 전 임시 응답 단계이며, 검증과 응답 포맷만 먼저 잡아둔 상태

---

## 현재 초점
### 1순위
- `build.gradle`에 JPA / PostgreSQL / Flyway 의존성 추가

### 2순위
- `application.yml`에 datasource / jpa / flyway 설정 추가

### 3순위
- 첫 migration 생성 후 앱 기동 확인

---

## 아직 시작하지 않은 핵심 항목
- PostgreSQL 연결
- JPA 엔티티
- Flyway migration
- Product / Partner / Inventory 도메인
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
- [ ] PostgreSQL / JPA / Flyway
- [ ] Product
- [ ] Partner
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
1. `build.gradle`에 PostgreSQL driver, JPA, Flyway 의존성을 추가한다.
2. `application.yml`에 datasource / jpa / flyway 설정을 넣는다.
3. 앱이 DB에 붙는지 확인한 뒤 첫 migration을 만든다.

### 다음에 손댈 가능성이 높은 파일
- `build.gradle`
- `src/main/resources/application.yml`
- `src/main/resources/db/migration/...`
- `src/main/java/com/giftflow/api/product/...`

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
- Product API가 validation과 공통 응답 포맷으로 동작한다.
- 다음으로 PostgreSQL / JPA / Flyway 연결을 시작할 수 있다.
