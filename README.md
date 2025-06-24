# spring-study-roadmap
1. 스프링 부트 이용한 프로젝트

# Branch 종류
1. spirng_basic
   - **spring_basic**: 스프링 입문 강의를 기반으로 작성된 코드가 포함된 브랜치입니다.

2. study_link
   - **study_link**: CRUD 기반으로 작성된 코드가 포함된 브랜치입니다. 

3. jpa_basic
   - **jpa_basic**: JPA 기반으로 작성된 코드가 포함된 브랜치입니다.

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
