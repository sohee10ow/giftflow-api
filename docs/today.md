# GiftFlow Today

> 이 파일은 **현재 세션의 실제 초점**을 적는 선택 문서다.
> stale할 수 있으므로, Codex는 항상 **현재 코드 상태와 current-status.md를 먼저 보고** 판단한다.

---

## 오늘 기본 초점
### Option A — Swagger 아직 미완료일 때
- `build.gradle`에 springdoc dependency 확인
- Swagger UI 접속 확인
- `/health`를 Swagger에서 실행

### Option B — Swagger가 이미 끝났을 때
- Day 2 시작
- `ApiResponse` 생성
- `GlobalExceptionHandler` 생성
- validation 실패 응답 구조 확인

---

## 오늘 목표
코드 상태를 기준으로 아래 둘 중 하나를 확정한다.
1. **Day 1 완전 종료:** Swagger/OpenAPI까지 확인
2. **Day 2 진입:** 공통 응답/예외 구조 시작

---

## 오늘 꼭 알아야 할 개념
- Swagger / OpenAPI가 왜 필요한가
- 공통 응답 포맷을 왜 초반에 잡는가
- 예외 처리를 Controller마다 하지 않고 분리하는 이유

---

## 오늘 액션 우선순위
1. Swagger UI가 실제로 열리는지 확인
2. 되면 `common.response` 또는 `common.exception` 패키지 시작
3. validation 실패 응답까지 확인
4. 커밋 남기기

---

## 오늘 완료 기준
- Swagger가 열리거나, 이미 열리는 것이 확인됨
- 또는 ApiResponse / GlobalExceptionHandler의 초안이 코드에 들어감
- 다음으로 PostgreSQL/JPA/Flyway에 들어갈 준비가 됨

---

## 추천 커밋 메시지
### Swagger 단계
```bash
git commit -m "chore: add swagger openapi config"
```

### Day 2 단계
```bash
git commit -m "feat: add common api response and global exception handler"
```

---

## 끝나고 남길 것
작업이 끝나면 반드시 아래를 업데이트한다.
- `docs/current-status.md`
- `docs/session-handoff.md`
