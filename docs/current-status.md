# GiftFlow Current Status

## 프로젝트
- 이름: **GiftFlow / giftflow-api**
- 목표: **서버 개발자로 전환하기 위한 학습형 Spring Boot 백엔드 포트폴리오**
- 모드: **3주 fast-track 기본 / 2주 모드 가능**

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

---

## 마지막으로 확인된 완료 사항
- [x] IntelliJ에서 Spring Boot 프로젝트 생성
- [x] Java 21 설정
- [x] application.yml 생성
- [x] `GET /health` API 구현
- [x] Git repository 생성
- [x] GitHub 원격 저장소 연결
- [x] 첫 커밋 완료

### 현재 확인된 구조
- 루트 패키지: `com.giftflow.api`
- 메인 클래스: `GiftflowApiApplication`
- `health` 패키지 존재
- `HealthController` 존재

---

## 현재 단계 해석
### 보수적 해석
- **Day 1 마무리 단계**
- Swagger/OpenAPI가 아직 코드/실행 기준으로 검증되지 않았을 수 있음

### 낙관적 해석
- Swagger까지 이미 끝났다면 **Day 2 진입 가능**

Codex는 실제 코드 상태를 먼저 보고,
- Swagger UI가 열리면 Day 2로,
- 아직 아니면 Day 1 마무리로 판단한다.

---

## 현재 초점
### 1순위
- Swagger/OpenAPI 설정 및 실행 확인

### 2순위
- ApiResponse / GlobalExceptionHandler / Validation 응답 구조

### 3순위
- PostgreSQL / JPA / Flyway 연결 준비

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
- [ ] Swagger 확정
- [ ] ApiResponse / ExceptionHandler
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
1. Swagger/OpenAPI가 실제로 열리는지 확인한다.
2. 열리면 Day 2로 넘어가 ApiResponse + GlobalExceptionHandler를 만든다.
3. 그 다음 PostgreSQL/JPA/Flyway로 간다.

### 다음에 손댈 가능성이 높은 파일
- `build.gradle`
- `src/main/resources/application.yml`
- `src/main/java/com/giftflow/api/health/HealthController.java`
- `src/main/java/com/giftflow/api/common/...` (다음 단계)

---

## Codex용 해석 규칙
- `현재 코드 상태 > 문서 추정 상태`를 우선한다.
- Swagger가 이미 끝난 상태면 이 문서를 Day 2 기준으로 보정한다.
- 사용자가 `다시시작`이라고 하면 session-handoff와 함께 이 문서를 먼저 참고한다.

---

## 현재 기준 성공 정의
- 앱이 바로 실행된다.
- `/health`가 동작한다.
- GitHub에 프로젝트가 올라가 있다.
- 다음으로 공통 응답/예외 구조 또는 DB 연결을 시작할 수 있다.
