# spring-study-roadmap
1. 스프링 부트 이용한 프로젝트

# Branch 종류
1. spirng_basic - 스프링 입문 강의를 기반으로 작성된 코드가 포함된 브랜치입니다.

2. study_link - CRUD 기반으로 작성된 코드가 포함된 브랜치입니다.

3. jpa_basic - JPA 기반으로 작성된 코드가 포함된 브랜치입니다.
   - JPA란: 자바 객체와 데이터베이스를 매핑해주는 ORM(Object-Relational Mapping) 기술
   - 비영속 (Transient) – 그냥 new로 만든 객체, 아직 JPA가 모름
   - 영속 (Persistent) – em.persist()로 등록한 객체, 영속성 컨텍스트에 저장됨
   - 준영속 (Detached) – em.detach() 또는 em.close() 후 JPA가 관리하지 않음
   - 삭제 (Removed) – em.remove() 호출됨
   - 영속성 컨텍스트란?: JPA가 엔티티 객체를 저장하고 관리하는 공간 (일종의 1차 캐시), 동일한 트랜잭션 내에서 같은 ID를 가진 객체는 동일 객체(==)
   - 1차 캐시: 같은 ID로 여러 번 조회해도 DB를 다시 조회하지 않음
   - 변경 감지(Dirty Checking): 트랜잭션 커밋 시 변경된 필드를 자동 감지 → UPDATE 자동 실행
   - 쓰기 지연 (Write Behind): persist()는 즉시 INSERT 하지 않음, 커밋 시점에 몰아서 실행
   - 플러시 (Flush): SQL을 DB에 반영 (자동/수동 호출 가능)
   - 단방향 연관관계: Member → Team만 참조하고, Team → Member는 모름, @JoinColumn: 어떤 컬럼이 외래 키인지 지정 (TEAM_ID), @ManyToOne: 다대일 관계 설정
   - 양방향 연관관계: Member → Team, Team → Member 양쪽 모두 참조, 주인이 되는 쪽과 아닌 쪽을 명확히 해야 함, 주인(Owner): 실제 DB의 외래 키를 관리하는 쪽 (@JoinColumn이 있는 쪽), 비주인(Inverse): 단순히 읽기만 가능, 외래 키를 직접 변경 불가, mappedBy: 비주인 쪽에서 주인을 지정하는 속성
# ✅ 패키지 구조
````
com.project.studyboard
├── global # 전역 설정 및 공통 모듈
│ ├── config # Spring Config (Security, JPA, CORS 등)
│ ├── error # 전역 예외 처리 (Exception, Advice)
│ ├── security # 인증/인가 관련 클래스
│ └── util # 유틸, 공통 상수
├── domain
│ ├── user # 사용자 도메인
│ │ ├── controller
│ │ ├── service
│ │ ├── repository
│ │ ├── dto
│ │ └── entity
│ ├── study # 스터디 모집 게시판 도메인
│ │ ├── controller
│ │ ├── service
│ │ ├── repository
│ │ ├── dto
│ │ └── entity
│ └── group # 스터디 참여자/신청 도메인
│ ├── controller
│ ├── service
│ ├── repository
│ ├── dto
│ └── entity
└── SpringStudyRoadmapApplication.java # 메인 클래스
````

# 💡 설명
| 패키지             | 역할 설명                                                      |
| --------------- | ---------------------------------------------------------- |
| `global.config` | `SecurityConfig`, `QuerydslConfig`등 설정 모음 |
| `global.error`  | `GlobalExceptionHandler`, `CustomException`, `ErrorCode`   |
| `domain.user`   | 회원가입, 로그인, 유저 정보                                           |
| `domain.study`  | 스터디 등록, 수정, 조회, 삭제                                         |
| `domain.group`  | 참여 신청, 승인/거절, 참여자 리스트 등                                    |
