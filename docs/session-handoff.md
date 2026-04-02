# GiftFlow Session Handoff

## 목적
집/회사/다음 세션으로 이동할 때,
대화 기억이 아니라 **문서 기준으로 바로 재시작**할 수 있게 현재 상태를 남긴다.

> 최신 항목이 항상 위에 오도록 추가한다.

---

## Latest Handoff
- **위치:** 회사
- **작성 시점:** 2026-04-02
- **현재 단계:** Day 2 완료, Day 3 진입 직전
- **방금 끝낸 것:**
  - Swagger/OpenAPI 동작 확인
  - `ApiResponse` 공통 응답 구조 적용
  - `GlobalExceptionHandler` 추가
  - Product API 요청 검증(`@NotBlank`, `@Positive`) 확인
  - Product API 성공/실패 응답을 공통 포맷으로 통일
- **지금 진행 중인 것:**
  - Day 3 준비
  - PostgreSQL / JPA / Flyway 연결 전 상태 정리
- **다음에 바로 할 1개 액션:**
  - `build.gradle`과 `application.yml`에 PostgreSQL, JPA, Flyway 설정을 추가하고 앱이 DB에 붙는지 확인
- **막힌 점 / 주의할 점:**
  - 현재 Product API는 메모리성 임시 응답 수준이고 DB 저장은 아직 없다.
  - Swagger 화면에서 400 응답이 `Undocumented`로 보이는 것은 현재 단계에서는 정상이다.
  - 다음 단계부터는 로컬 PostgreSQL 실행 여부와 DB 접속 정보가 필요하다.
- **참고해야 할 파일:**
  - `build.gradle`
  - `src/main/resources/application.yml`
  - `src/main/java/com/giftflow/api/common/ApiResponse.java`
  - `src/main/java/com/giftflow/api/common/GlobalExceptionHandler.java`
  - `src/main/java/com/giftflow/api/product/ProductController.java`
  - `src/main/java/com/giftflow/api/product/CreateProductRequest.java`
  - `docs/current-status.md`
- **마지막 사용자 의도:**
  - Day 3는 회사에서 이어서 진행하기

- **위치:** 미기록
- **작성 시점:** 초기 생성
- **현재 단계:** Day 1 마무리 또는 Day 2 진입 전
- **방금 끝낸 것:**
  - Spring Boot 프로젝트 생성
  - Java 21 설정
  - `/health` 구현
  - Git/GitHub 연결
- **지금 진행 중인 것:**
  - Swagger/OpenAPI 설정 여부 확인
- **다음에 바로 할 1개 액션:**
  - Swagger UI 접속 확인 후, 되면 `ApiResponse`와 `GlobalExceptionHandler`를 만드는 Day 2로 진입
- **막힌 점 / 주의할 점:**
  - 현재 상태 문서는 Swagger가 아직 확정되지 않았다는 보수적 가정을 포함한다.
  - 실제 코드 상태가 더 앞서 있으면 Day 2 또는 Day 3로 바로 보정한다.
- **참고해야 할 파일:**
  - `build.gradle`
  - `src/main/resources/application.yml`
  - `src/main/java/com/giftflow/api/health/HealthController.java`
  - `docs/current-status.md`
  - `docs/fast-track-day-map.md`
- **마지막 사용자 의도:**
  - Codex가 fast-track study agent처럼 Day 단위로 주도적으로 안내하길 원함

---

## Handoff Template
아래 블록을 복사해서 최신 항목을 위에 추가한다.

```md
## Handoff - YYYY-MM-DD HH:mm
- 위치:
- 현재 단계:
- 방금 끝낸 것:
- 지금 진행 중인 것:
- 다음에 바로 할 1개 액션:
- 막힌 점 / 주의할 점:
- 참고해야 할 파일:
- 마지막 사용자 의도:
```

---

## 재시작 규칙
사용자가 `다시시작`이라고 하면 아래 순서로 읽는다.
1. `AGENTS.md`
2. `docs/fast-track-plan.md`
3. `docs/fast-track-day-map.md`
4. `docs/current-status.md`
5. `docs/session-handoff.md`
6. `docs/today.md` (있다면)

그 다음 가장 최근 handoff 기준으로
**지금 바로 할 1개 액션만** 제시한다.
