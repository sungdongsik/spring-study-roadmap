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
   - 다대일(N:1) 단방향: 실무에서 가장 많이 사용
   - 다대일(N:1) 양방향: @OneToMany(mappedBy = "team") 설정으로 양방향 참조, 연관관계 주인은 여전히 Member 쪽임
   - 일대다(1:N) 단방향 : 권장되지 않음 (insert SQL 2번 나감 + 외래키가 주 테이블에 존재)
   - 일대다(1:N) 양방향: 실제 존재하지 않음. JPA에서는 양방향을 만들기 위해 N:1 양방향을 사용하는 것이 일반적
   - 일대일(1:1) 단방향: @OneToOne 사용, @JoinColumn으로 FK 설정.
   - 일대일(1:1) 양방향: mappedBy를 통해 양방향 설정, 연관관계의 주인은 @JoinColumn이 있는 쪽
   - 다대다(M:N) 단방향: 중간 테이블을 자동으로 생성하지만 실무에서는 잘 사용하지 않음
   - 다대다(M:N) 양방향: 위 단방향과 유사하며 mappedBy 설정
   - 상속 관계 매핑: 하나의 부모 엔티티를 상속받는 여러 자식 엔티티들을 어떻게 테이블로 분리할지 결정하는 방법
   - | 전략                                         | 설명                     | 장점           | 단점                  |
     | ------------------------------------------ | ---------------------- | ------------ | ------------------- |
     | `@Inheritance(strategy = SINGLE_TABLE)`    | 모든 자식을 하나의 테이블에 저장     | 성능 좋음, 조인 없음 | NULL 컬럼 많아짐, 테이블 커짐 |
     | `@Inheritance(strategy = JOINED)`          | 부모, 자식 각각 테이블 분리, 조인   | 정규화, 확장성 좋음  | 조인 성능 저하            |
     | `@Inheritance(strategy = TABLE_PER_CLASS)` | 자식마다 테이블 따로, 부모 테이블 없음 | 단순           | 비추천, 쿼리 비효율적        |

   - @DiscriminatorColumn: 구분 컬럼 (디폴트로 DTYPE 컬럼이 생성된다.)
   - @MappedSuperclass (공통 매핑 정보 상속): 공통 필드를 여러 엔티티에 상속해서 중복 제거




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
