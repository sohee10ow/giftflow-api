# current-status.md

## 프로젝트
- 이름: **giftflow-api**
- 도메인: **B2B 기프티콘 지급/취소/정산 API 플랫폼 (GiftFlow)**
- 목적: **서버 개발자로 전환하기 위한 학습형 Spring Boot 포트폴리오 프로젝트**

---

## 현재 기술 스택
- Java 21
- Spring Boot 3.5.13
- Gradle - Groovy
- Spring Web
- Validation
- Lombok
- DevTools
- Swagger/OpenAPI (설정 진행 중 또는 막 마무리 단계)

---

## 현재까지 완료한 것
### Day 1 기준 완료
- [x] IntelliJ에서 Spring Boot 프로젝트 생성
- [x] Java 21 설정
- [x] Spring Boot 3.5.13 선택
- [x] `application.yml` 생성
- [x] `GET /health` API 구현
- [x] Git repository 생성
- [x] 첫 커밋 완료
- [x] GitHub 원격 저장소 연결

### 현재 확인된 구조
- 루트 패키지: `com.giftflow.api`
- 메인 클래스: `GiftflowApiApplication`
- `health` 패키지 존재
- `HealthController` 존재

---

## 현재 단계
**Day 1 마무리 단계**

지금의 핵심은 아래 둘 중 하나다.
1. Swagger/OpenAPI 설정을 완료하고 `/health`를 Swagger에서 확인한다.
2. Swagger가 이미 끝났다면 Day 2로 넘어가서 기본 구조를 세운다.

---

## Day 1 완료 조건
- [x] Spring Boot 앱이 로컬에서 뜬다.
- [x] `/health` API가 동작한다.
- [x] Git/GitHub 연결이 되어 있다.
- [ ] Swagger/OpenAPI UI 접속 가능
- [ ] `/health` API가 Swagger에서 보임
- [ ] 초기 README 작성 또는 최소 초안 생성

> 참고: Swagger가 이미 끝났다면 위 체크만 갱신하면 된다.

---

## 다음 후보 작업
### 1순위
- Swagger/OpenAPI 설정 마무리
- `/health`를 Swagger UI에서 직접 실행해보기
- README에 현재 구현 범위 짧게 작성

### 2순위 (Day 2 진입)
- `controller/service/repository` 패키지 구조 잡기
- 공통 응답 포맷 생성
- 글로벌 예외 처리기 생성
- validation 에러 응답 구조 잡기

### 3순위 (Day 3 준비)
- PostgreSQL docker compose 작성
- Product entity / 저장 / 조회 구조 준비

---

## 지금 하지 않는 것
아직 아래는 시작하지 않는다.

- Redis
- Security
- Scheduler
- callback
- 정산
- 테스트 프레임워크를 깊게 파기
- MSA / Kafka / Kubernetes

현재 목표는 **서버가 돌아가고, 기본 웹 계층 구조를 이해하는 것**이다.

---

## 현재 학습 우선순위
1. Spring Boot 기본 동작 흐름
2. `@RestController`, `@GetMapping`, `@RequestBody`, `@Valid`
3. Controller / Service / Repository 역할 분리
4. DTO와 응답 구조
5. 예외 처리와 validation
6. 그 다음에 DB 연결

---

## 현재 기준 성공 정의
현재 시점에서 성공은 아래다.

- 로컬에서 프로젝트를 다시 켜도 바로 실행 가능하다.
- `/health` API를 브라우저와 Swagger 둘 다에서 확인할 수 있다.
- 다음 단계에서 Product 도메인을 시작할 준비가 되어 있다.
- Codex가 `AGENTS.md + current-status.md + today.md`만 읽고도 다음 한 단계를 제안할 수 있다.

---

## 다음 단계로 넘어갈 때 업데이트할 것
Swagger가 끝나면 아래처럼 상태를 바꾼다.

- `Swagger/OpenAPI UI 접속 가능` 체크
- `current-status.md`의 현재 단계를 `Day 2 진입`으로 변경
- `docs/today.md`를 Day 2용 목표로 갱신

