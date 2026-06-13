# spring-boot-study

## 폴더 구조
```text
spring-boot-study/
├─ .gitignore
├─ README.md                       # 레포 개요: 폴더 구조 및 목차 
├─ docs/                           # 이론 정리 (md 파일)
│  ├─ 01-spring-boot-overview.md 
│  ├─ 02-mvc-view-template.md
│  ├─ 03-crud-create.md
│  ├─ 04-lombok-refactoring.md
│  ├─ 05-crud-read.md
│  ├─ 06-page-navigation.md
│  ├─ 07-crud-update.md
│  ├─ 08-crud-delete.md
│  ├─ 09-database-form-dto.md
│  ├─ 10-rest-api.md
│  ├─ 11-java-stream.md
│  ├─ 12-service-transaction.md    
│  ├─ 13-spring-data-jpa.md           
│  ├─ 14-test-code.md              
│  └─ 15-comment-crud.md           
│
├─ firstproject/                # 기존 통합 실습 (임시 유지)
├─ 01-first-project/springproject/
├─ 02-mvc-project/
│  ├─ springproject                       # mvc-project
│  ├─ templateproject                     # template-project
│  └─ bootstrapproject                    # bootstrap-project
├─ 03-crud-create/springproject/
├─ 04-lombok-refactoring/springproject/
├─ 05-crud-read/springproject/
├─ 06-page-navigation/springproject/
├─ 07-crud-update/springproject/
├─ 08-crud-delete/
│  ├─ springproject                       # delete-project
│  └─ memberproject                       # memeber-project
├─ 09-database-form-dto/springproject/
├─ 10-rest-api/
│  ├─ boardproject                        # restapi-project
│  └─ coffeeproject                       # coffee-project
├─ 11-java-stream/springproject/
├─ 12-service-transaction/boardproject/       
├─ 13-jpa-project/boardproject/
├─ 14-test-code-project/springproject/
├─ 15-comment-project/springproject/
└─ 16-board-project/boardproject/          # 최종 프로젝트
```

## 개발 환경 및 프로젝트 생성 기준

### 기본 개발 환경
| 항목 | 내용 |
|---|---|
| JDK | 21 |
| Project | Gradle - Groovy |
| Language | Java |
| Java Version | 21 |
| Packaging | Jar |
| Configuration | Properties |
| Spring Boot | 4.0.3 |
| JDK Vendor | Microsoft OpenJDK |

### 기본 Dependencies

| Dependency | 역할 |
|---|---|
| Spring Web | Spring Boot 기반 웹 애플리케이션 및 Controller 실습에 사용 |
| Mustache | 서버 사이드 View Template 렌더링에 사용 |
| H2 Database | 실습용 인메모리 데이터베이스로 사용 |
| Spring Data JPA | Entity, Repository 기반 DB 접근 실습에 사용 |

### 추가 사용 도구 및 라이브러리

| 도구 / 라이브러리 | 사용 목적 |
|---|---|
| Lombok | Getter, Setter, 생성자, toString, Logger 등 반복 코드 자동 생성 |
| Bootstrap | Mustache View Template의 화면 구성 및 레이아웃 적용 |
| H2 Console | 실습 중 DB 테이블과 저장 데이터를 브라우저에서 확인 |
| JPA Entity | Java 객체와 DB 테이블을 매핑 |
| Repository | DB 저장, 조회, 수정, 삭제 기능을 추상화 |
| DTO | Form 데이터와 Controller 사이의 데이터 전달 객체로 사용 |
| data.sql | 서버 실행 시 초기 테스트 데이터를 자동 삽입 |
| application.properties | 프로젝트 이름, DB 설정, 인코딩, Mustache 설정 등을 관리 |

### 프로젝트별 사용 기준

| 프로젝트 | 사용 목적 |
|---|---|
| springproject | 기본 Spring Boot 실습 프로젝트|
| templateproject | View Template 문법 실습 |
| bootstrapproject | Bootstrap 기반 Header/Footer Layout 실습 |
| boardproject | 게시판 CRUD 실습 |
| jpaproject | JPA, Entity, Repository, DB 연동 심화 실습 |