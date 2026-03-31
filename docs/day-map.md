# Day Map

이 문서는 GiftFlow 프로젝트를 **세션 기반 Day 단위**로 쪼갠 로드맵이다.
사용자가 `Day 3 시작`, `Day 12 시작`이라고 말하면 Codex는 이 문서를 기준으로 해당 단계의 목표와 공부 포인트를 잡는다.

> 기본 원칙
> - 1 Day = 평일 1.5~2시간 또는 집중 세션 1회 기준
> - 한 Day에 목표는 크게 1개, 많아도 2개
> - 매 Day 끝에 실행 확인 / 테스트 포인트 / 커밋을 남긴다.

---

## Day 1. 프로젝트 부팅
- 목표: Spring Boot 프로젝트 생성, `/health` API, Git 연결
- 공부: Spring Boot starter, `@RestController`, `@GetMapping`
- 산출물: 실행되는 서버, 첫 커밋

## Day 2. Swagger/OpenAPI + 설정 파일
- 목표: Swagger 붙이기, `application.yml` 이해
- 공부: 의존성 관리, Gradle reload, 환경설정 파일
- 산출물: Swagger UI에서 `/health` 호출 가능

## Day 3. Product API의 첫 뼈대
- 목표: Product 도메인 첫 진입
- 공부: Controller / Service / DTO 역할
- 구현: `CreateProductRequest`, `ProductResponse`, `ProductController` 또는 첫 파일 1개
- 산출물: Product API 뼈대

## Day 4. Product 등록 / 조회 + Validation
- 목표: Product create / getById 동작
- 공부: `@Valid`, `@NotBlank`, `@Min`, 요청/응답 DTO
- 테스트: validation 실패 케이스 확인
- 산출물: Product API 동작 캡처

## Day 5. 공통 응답 포맷 + 예외 처리
- 목표: API 응답을 일관되게 정리
- 공부: GlobalExceptionHandler, Response Envelope
- 구현: 공통 응답 구조, validation error 변환
- 테스트: 잘못된 입력 400 응답

## Day 6. PostgreSQL 연결
- 목표: 로컬 DB 붙이기
- 공부: datasource, Docker Compose, application.yml 확장
- 구현: PostgreSQL 컨테이너 실행, 애플리케이션 연결
- 산출물: DB 연결 성공 로그

## Day 7. JPA 입문 + Product Entity
- 목표: 메모리 저장소에서 JPA로 전환 시작
- 공부: Entity, Repository, PK
- 구현: `product` Entity / JPA Repository
- 테스트: save / findById

## Day 8. Flyway로 스키마 관리
- 목표: DDL을 코드로 관리
- 공부: migration, schema versioning
- 구현: `product` 테이블 migration
- 산출물: V1 migration

## Day 9. Partner 도메인 시작
- 목표: Partner create / get API 뼈대
- 공부: PK/FK, 상태 필드, callback URL 개념
- 구현: Partner Entity/DTO/Service
- 산출물: Partner API 초안

## Day 10. Partner API Key 개념 잡기
- 목표: 파트너 인증을 위한 모델 이해
- 공부: API Key, hash 저장, 상태 관리
- 구현: partner_api_key 모델 또는 설계 메모
- 산출물: 인증 흐름 메모

## Day 11. Inventory 도메인 시작
- 목표: Product와 PIN 재고 연결
- 공부: `pin_batch`, `pin_inventory`, 재고 상태
- 구현: PIN batch 업로드 기본 모델
- 산출물: inventory 엔티티 초안

## Day 12. Inventory 조회
- 목표: 상품별 가용 재고 수 조회
- 공부: 상태 기반 조회, index가 필요한 이유
- 구현: available count API 또는 service
- 테스트: AVAILABLE / RESERVED 구분
- 산출물: 재고 조회 API

## Day 13. Order 도메인 시작
- 목표: 지급 주문의 뼈대 만들기
- 공부: Order, `partnerOrderId`, idempotency 개념 맛보기
- 구현: issue_order Entity/DTO 초안
- 산출물: Order 모델

## Day 14. Issue API 초안
- 목표: 지급 요청 API의 엔드포인트부터 세우기
- 공부: request validation, partnerOrderId 의미
- 구현: issue request DTO + controller 초안
- 산출물: `POST /partner-api/v1/orders/issue` 골격

## Day 15. Transaction 입문
- 목표: 주문 생성과 재고 예약을 왜 묶어야 하는지 이해
- 공부: `@Transactional`, 원자성, rollback
- 구현: order service에 transaction boundary 설계
- 산출물: transaction 메모

## Day 16. Order 생성 + 재고 예약 1차 구현
- 목표: 정상 지급 흐름의 첫 버전
- 공부: Service orchestration
- 구현: order create + inventory reserve
- 테스트: 정상 지급 1건
- 산출물: order 생성 성공

## Day 17. Order Status History
- 목표: 상태 이력을 남기기 시작
- 공부: history table이 왜 필요한지
- 구현: `order_status_history` 저장
- 테스트: 상태 변경 후 이력 row 확인
- 산출물: history 조회 결과

## Day 18. 상태 전이 규칙 분리
- 목표: 허용/비허용 전이 규칙 명시
- 공부: state machine, validator
- 구현: 상태 전이 validator 또는 domain rule 분리
- 테스트: invalid transition 차단
- 산출물: 상태 전이 표

## Day 19. 주문 조회 API
- 목표: partnerOrderId 기준 조회
- 공부: 조회 모델, 응답 DTO
- 구현: `GET /partner-api/v1/orders/{partnerOrderId}`
- 산출물: 주문 조회 API

## Day 20. 취소 API 시작
- 목표: Cancel 흐름 진입
- 공부: `CANCEL_REQUESTED`, `CANCELLED`, `CANCEL_FAILED`
- 구현: cancel endpoint 초안
- 산출물: 취소 플로우 초안

## Day 21. 취소 처리 + 상태 이력
- 목표: 취소 성공/실패 구조 잡기
- 공부: 상태 전이 + 보상 처리 개념
- 구현: cancel service + history 저장
- 테스트: 취소 가능한 상태 / 불가능한 상태
- 산출물: 취소 시나리오 정리

## Day 22. Unique Constraint로 중복 방지
- 목표: DB 레벨 중복 주문 방지
- 공부: unique constraint, 왜 DB가 최종 진실인지
- 구현: `(partner_id, partner_order_id)` unique
- 테스트: 중복 요청 시 실패 또는 기존 결과
- 산출물: 중복 방지 확인

## Day 23. Idempotency-Key 지원 1차
- 목표: 네트워크 재시도 대응 시작
- 공부: idempotency, key 설계
- 구현: idempotency record 또는 간단한 key 처리
- 테스트: 같은 key 재요청
- 산출물: idem 동작 예시

## Day 24. 동시성 문제 이해 + 오버셀링 방지 설계
- 목표: 왜 락이 필요한지 이해
- 공부: optimistic/pessimistic lock, `FOR UPDATE`
- 구현: inventory reserve 쿼리/락 전략 정리
- 산출물: 동시성 전략 문서

## Day 25. Redis 기본 붙이기
- 목표: Redis를 보조 수단으로 사용 시작
- 공부: key/value, TTL, 왜 DB 대체가 아닌지
- 구현: Redis 연결 / 간단한 key 저장
- 산출물: Redis 연결 확인

## Day 26. Callback 도메인 시작
- 목표: callback_delivery 모델 도입
- 공부: 주문 상태와 callback 상태 분리
- 구현: callback entity/table/DTO 초안
- 산출물: callback 모델

## Day 27. WebClient로 callback 전송
- 목표: 외부 HTTP 호출 첫 구현
- 공부: WebClient, timeout, payload
- 구현: callback send service
- 테스트: mock endpoint 200 / 500
- 산출물: callback 전송 로그

## Day 28. Retry / Scheduler
- 목표: 실패 callback 재시도
- 공부: scheduler, backoff, next_retry_at
- 구현: retry scheduler
- 테스트: FAILED -> SUCCESS 또는 DEAD
- 산출물: retry 동작 확인

## Day 29. Settlement 시작
- 목표: 일별 집계의 개념과 테이블 만들기
- 공부: summary table, 집계 SQL
- 구현: `settlement_daily` 모델
- 산출물: settlement entity + migration

## Day 30. 일별 집계 job + 조회 API
- 목표: settlement job 첫 버전
- 공부: scheduler vs batch, 재실행 안전성
- 구현: 집계 실행 + 조회 API
- 테스트: 날짜 기준 집계 확인
- 산출물: settlement API

## Day 31. CSV export
- 목표: 정산 결과 다운로드
- 공부: 파일 응답, CSV 생성 방식
- 구현: export API
- 산출물: CSV 샘플

## Day 32. Partner API Key 인증
- 목표: 파트너 API 보호 시작
- 공부: filter, authentication, header parsing
- 구현: `X-API-Key` 검증 1차
- 테스트: 인증 성공 / 실패
- 산출물: auth 흐름

## Day 33. Admin 인증
- 목표: 운영 API 보호
- 공부: Spring Security 기본, role
- 구현: admin auth 초안
- 산출물: admin 접근 제어

## Day 34. 통합 테스트 본격화
- 목표: 핵심 흐름 테스트 자동화 시작
- 공부: Spring Boot Test, MockMvc/RestAssured
- 구현: 정상 지급 / 중복 주문 테스트
- 산출물: 테스트 코드 2~3개

## Day 35. callback / settlement 테스트
- 목표: 비동기/집계 테스트 감각 만들기
- 공부: scheduler test, fixture 전략
- 구현: callback retry / settlement test
- 산출물: 테스트 시나리오 문서화

## Day 36. 운영성 + README 강화
- 목표: 로그, traceId, README 정리
- 공부: traceId, 운영 포인트, 면접 설명
- 구현: traceId logging, README progress 업데이트
- 산출물: 포트폴리오용 설명 문구

---

## Day 사용 규칙
Codex는 사용자가 `Day N 시작`이라고 말하면 아래 순서로 움직인다.

1. 해당 Day 목표를 찾는다.
2. 현재 코드베이스가 그 Day보다 앞서면 **현재 코드 기준으로 조정**한다.
3. 현재 코드가 그 Day보다 뒤쳐져 있으면 **선행 단계 1개만 경고**하고 바로 이어서 갈 수 있게 돕는다.
4. 반드시 아래 요소를 포함한다.
   - 공부 포인트
   - 구현 단계
   - 테스트 포인트
   - 실무 포인트
   - 코드 리뷰 체크포인트
   - 이해 확인 질문

---

## Day 진행 시 기본 마무리 규칙
각 Day가 끝나면 가능한 한 아래 중 2개 이상 남긴다.
- 실행 캡처
- 테스트 코드 1개
- README 한 줄
- 커밋 1개
- 오늘 배운 개념 3줄 요약

