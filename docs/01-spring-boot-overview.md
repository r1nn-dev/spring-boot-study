# 1. 스프링 부트 (Spring Boot)

## 1. Spring Boot의 핵심 구성 요소
- **Auto-Configuration**
- **Starter Dependencies**
- **Embedded Web Server (Apache Tomcat – Servlet Container)**
- **Dependency Management (BOM)**

## 2. Spring Boot 프로젝트 생성
### 1. **Spring Initializr** 이용한 Spring Boot 프로젝트 생성
- http://start.spring.io

### 2. 기본 설정 항목
- Project: Gradle - Groovy
- Language: Java
- Spring Boot Version: GA (권장)
  - SNAPSHOT : 개발 중인 테스트 단계
  - Mx(Milestone) : 중간 검증 단계 (M1, M2, …)
  - RC(Release Candidate) : 최종 배포 직전 단계
  - GA(General Availability) : 안정화된 정식 릴리스
- Packaging: Jar
- Java: 17 (LTS, Long Term Support)

### 3. 프로젝트 메타데이터
- Artifact: 프로젝트명
- Package name : `com.example.프로젝트명`
  - `Group + Artifact` 조합으로 기본 패키지가 생성된다.
  - 예: `com.example.demo`

### 4. 의존성(Dependencies) 설정
- Web - Spring Web : HTTP 요청/응답 처리 및 Spring MVC 포함
- SQL - Spring Data JPA : ORM(Object-Relational Mapping) 기반 데이터 접근
- SQL - H2 Database : 학습 및 테스트용 경량 RDBMS
- TEMPLATE ENGINES - Mustache : 서버 사이드 렌더링(SSR)을 위한 템플릿 엔진

### 5. 기본 디렉터리 구조
```txt
src/main/java           // 자바 소스 코드
└─ <base-package>       // 기본 패키지 - `com.example.project`
└─ Application.java     // 애플리케이션 진입점

src/main/resources      // 외부 파일 - 설정 파일, 정적 리소스(static), 템플릿 파일 등
├─ templates            // View Template (Mustache)
├─ static               // 정적 리소스 (css/js/img)
└─ application.yml      // 설정 파일
```

### 6. Spring Boot & Java 버전 설정: `build.gradle` 파일
```groovy
plugins {
	id 'java'
	id 'org.springframework.boot' version '3.x.x'
	id 'io.spring.dependency-management' version '1.1.7'
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}
```
- 권장 조합: Spring Boot 3.x + Java 17
- IntelliJ에서 자바 버전 설정 방법
    - [File] > [Settings] > [Build, Execution, Deployment] > [Build Tools] > [Gradle] > [Gradle JVM]
    - [File] > [Project Structure] > [Project] > [SDK]
    - [File] > [Project Structure] > [Project] > [Language level - SDK default]
    - [File] > [Project Structure] > [Modules] > [Language level - Project default]

### 7. 애플리케이션 실행 흐름
- `Application.main()` 실행
- `SpringApplication.run()` 호출
- `ApplicationContext` 생성 및 초기화
- Auto-Configuration에 따라 Bean 구성
- Embedded Tomcat(Servlet Container) 기동
- DispatcherServlet 초기화 후 HTTP 요청 수신 대기 상태 진입
서버 실행 완료 판단 기준 로그
    - `Started <ApplicationClass>`
    - `Tomcat started on port(s): 8080` : 내장 톰캣이 8080 포트에서 리스닝(listening) 중임을 의미

### 8. 브라우저 접속
- `localhost:8080`
  - 루프(`/`)에 매핑된 컨트롤러(Controller)나 정적 리소스가 없으면 404 반환
- `http://localhost:8080/<file>` : 정적 리소스 접근 요청
- 정적 리소스 기본 탐색 기준
  - 개발 디렉터리: `src/main/resources/static`
  - 실행 시점(classpath 기준): `classpath:/static/`
