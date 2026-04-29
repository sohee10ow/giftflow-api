# GiftFlow Session Handoff

## 목적
집/회사/다음 세션으로 이동할 때,
대화 기억이 아니라 **문서 기준으로 바로 재시작**할 수 있게 현재 상태를 남긴다.

> 최신 항목이 항상 위에 오도록 추가한다.

---

## Latest Handoff
- **위치:** 집
- **작성 시점:** 2026-04-27
- **현재 단계:** Day 6 Inventory 기초 진행 중
- **방금 끝낸 것:**
  - Partner 테이블 migration 커밋 완료
  - Partner create/get/list API 구현 및 커밋 완료
  - `V3__add_pin_inventory.sql` 작성 및 커밋 완료
  - `./gradlew test` 통과 확인
- **지금 진행 중인 것:**
  - Inventory 도메인 시작
  - `PinInventoryEntity`, `PinInventoryRepository` 초안 파일 생성됨
- **다음에 바로 할 1개 액션:**
  - `PinInventoryEntity`에 `id`, `productId`, `pinCode`, `status`, `createdAt`, `updatedAt` 필드와 JPA 매핑을 채운다.
- **막힌 점 / 주의할 점:**
  - 현재 `src/main/java/com/giftflow/api/inventory/` 파일 2개는 아직 untracked 상태다.
  - `PinInventoryRepository`는 아직 `JpaRepository`를 상속하지 않는다.
  - `product_id`는 우선 `Long productId`로 단순 매핑하고, JPA 연관관계는 나중에 필요할 때만 검토한다.
  - Product/Partner 목록 경로는 현재 `/all` 패턴을 쓰고 있어 나중에 한 번에 정리할 수 있다.
- **참고해야 할 파일:**
  - `src/main/resources/db/migration/V3__add_pin_inventory.sql`
  - `src/main/java/com/giftflow/api/inventory/PinInventoryEntity.java`
  - `src/main/java/com/giftflow/api/inventory/PinInventoryRepository.java`
  - `src/main/java/com/giftflow/api/product/ProductEntity.java`
  - `src/main/java/com/giftflow/api/product/ProductRepository.java`
  - `docs/current-status.md`
- **마지막 사용자 의도:**
  - 여기서부터는 집에서 Inventory Entity/Repository를 이어서 진행하기

- **위치:** 회사
- **작성 시점:** 2026-04-06
- **현재 단계:** Day 4 완료, Day 5 시작 전
- **방금 끝낸 것:**
  - PostgreSQL / JPA / Flyway 연결 완료
  - `V1__init.sql`로 `product` 테이블 생성
  - Product create API를 JPA 저장 기반으로 전환
  - Product 단건 조회 API 추가
  - 없는 Product 조회 시 `404` 공통 에러 응답 처리
  - Product 목록 조회 API 추가
- **지금 진행 중인 것:**
  - Product 도메인 최소 범위 마무리 상태
  - 다음 도메인인 Partner 진입 준비
- **다음에 바로 할 1개 액션:**
  - `Partner` 엔티티와 첫 migration 추가 범위를 정하고 create API부터 시작
- **막힌 점 / 주의할 점:**
  - 문서 상태가 실제 코드보다 뒤처져 있어서 재시작 시 코드 기준으로 판단해야 한다.
  - Product 목록 경로는 현재 `/admin-api/v1/products/all` 로 구현돼 있으니, 나중에 `/admin-api/v1/products` 로 정리할지 판단 필요
  - `createdAt`, `updatedAt` 세팅은 지금 컨트롤러에서 직접 하고 있다.
- **참고해야 할 파일:**
  - `src/main/java/com/giftflow/api/product/ProductController.java`
  - `src/main/java/com/giftflow/api/product/ProductEntity.java`
  - `src/main/java/com/giftflow/api/product/ProductRepository.java`
  - `src/main/resources/db/migration/V1__init.sql`
  - `docs/current-status.md`
- **마지막 사용자 의도:**
  - Product list API까지 끝내고, 다음에는 회사에서 이어서 진행하기

- **위치:** 집
- **작성 시점:** 2026-04-06
- **현재 단계:** Day 3 시작
- **방금 끝낸 것:**
  - Day 2까지의 코드 상태 재확인
  - `ApiResponse`, `GlobalExceptionHandler`, Product 요청 검증 코드 존재 확인
  - Product API가 아직 DB 연결 전 임시 응답 단계임을 재확인
- **지금 진행 중인 것:**
  - PostgreSQL / JPA / Flyway 연결 시작
  - Day 3 첫 액션 범위 확정
- **다음에 바로 할 1개 액션:**
  - `build.gradle`에 `spring-boot-starter-data-jpa`, PostgreSQL driver, Flyway 의존성을 추가한다
- **막힌 점 / 주의할 점:**
  - 아직 datasource 설정과 migration 파일이 없다.
  - 로컬 PostgreSQL 실행 여부와 접속 정보가 준비돼 있어야 한다.
  - Product API는 현재 UUID traceId와 임시 ID를 반환하는 학습용 초안이다.
- **참고해야 할 파일:**
  - `build.gradle`
  - `src/main/resources/application.yml`
  - `src/main/java/com/giftflow/api/product/ProductController.java`
  - `docs/current-status.md`
  - `docs/fast-track-day-map.md`
- **마지막 사용자 의도:**
  - Day 3를 집에서 바로 시작하고 싶음

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
