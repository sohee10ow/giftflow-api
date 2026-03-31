# today.md

## 오늘 모드
**Day 1 마무리 - Swagger/OpenAPI 설정 완료하기**

---

## 오늘 목표
Spring Boot 프로젝트에 Swagger/OpenAPI를 붙이고,
`/health` API를 Swagger UI에서 직접 호출할 수 있게 만든다.

---

## 왜 이걸 하는가
지금 단계에서 Swagger를 붙여두면,
앞으로 만드는 모든 API를 브라우저에서 바로 확인할 수 있다.

즉, 오늘 작업은 단순한 문서 설정이 아니라,
**앞으로의 학습 속도를 높이는 개발 작업대 만들기**다.

---

## 오늘 할 일
- [ ] `build.gradle`에 springdoc dependency 추가
- [ ] Gradle reload
- [ ] 서버 재실행
- [ ] `/swagger-ui/index.html` 접속 확인
- [ ] Swagger에서 `GET /health` 실행 확인
- [ ] 가능하면 현재 상태를 README에 한 줄 기록

---

## 오늘 공부할 것
### 1. Swagger / OpenAPI
- API 문서를 자동으로 보여주는 도구다.
- 브라우저에서 직접 요청을 보내고 응답을 확인할 수 있다.

### 2. Gradle dependency 추가
- Spring Boot 프로젝트는 필요한 라이브러리를 `build.gradle`에서 관리한다.
- Swagger도 결국 라이브러리 하나를 추가해서 붙이는 구조다.

### 3. 왜 초반에 Swagger를 붙이는가
- API 확인 속도가 빨라진다.
- 요청/응답 구조를 눈으로 보기 좋다.
- 이후 Product, Partner, Order API 작업이 훨씬 편해진다.

---

## 수정할 파일
### 필수
- `build.gradle`

### 선택
- `src/main/resources/application.yml`
- `README.md`

---

## 구현 가이드
### 1단계
`build.gradle`의 `dependencies` 블록에 아래 의존성을 추가한다.

```gradle
implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.6'
```

### 2단계
Gradle 변경 사항을 반영한다.
- IntelliJ의 `Load Gradle Changes` 또는
- Gradle 패널의 `Reload All Gradle Projects`

### 3단계
서버를 다시 실행한다.

### 4단계
브라우저에서 아래 주소를 확인한다.

```text
http://localhost:8080/swagger-ui/index.html
```

### 5단계
Swagger UI에서 `GET /health`를 눌러 응답을 확인한다.

---

## 확인 방법
아래 세 가지가 되면 오늘 목표 완료다.

1. Swagger UI 페이지가 열린다.
2. `GET /health` API가 목록에 보인다.
3. 실행 결과로 아래 JSON과 유사한 응답이 나온다.

```json
{
  "status": "ok",
  "service": "giftflow-api"
}
```

---

## 완료 기준
- [ ] Swagger UI 접속 성공
- [ ] `/health` API 실행 성공
- [ ] Day 1 체크리스트 완료
- [ ] 커밋 완료

---

## 커밋 메시지
```bash
git add .
git commit -m "chore: add swagger openapi config"
```

---

## 오늘 작업이 끝나면
작업이 끝나면 다음으로 할 일은 **Day 2 진입**이다.

다음 단계 후보:
1. `controller/service/repository` 패키지 구조 만들기
2. 공통 응답 포맷 만들기
3. 글로벌 예외 처리기 만들기

> 단, 오늘은 여기까지 하고 끝낸다. 다음 단계는 내일 진행한다.
