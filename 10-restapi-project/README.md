# REST API
- board project
- coffee project

## board project
rest api 구현하기 
### 더미 데이터 `data.sql`
```sql
INSERT INTO Article(title, content) VALUES
('Spring Boot 소개', 'Spring Boot는 자바 기반 웹 프레임워크입니다.'),
('JPA란?', 'JPA는 Java Persistence API의 약자로 ORM 기술입니다.'),
('REST API란?', 'REST API는웹에서 자원을 CRUD하는 방식이다.'),
('MySQL 사용법', 'MySQL은 대표적인 오픈소스 관계형 데이터베이스입니다.'),
('Gradle이란?', 'Gradle은 빌드 자동화 도구로, Spring Boot에서 많이 사용됩니다.');
```
### 구현하기
1. REST 컨트롤러: `api/ArticleApiController.java`
2. DTO: `dto/ArticleApiDTO.java`, `dto/ArticleUpdateDTO.java`
3. Entity: `entity/Article.java`
4. Repository: `repository/ArticleApiRepository.java`


## coffee project
coffee 데이터를 생성, 조회, 수정, 삭제하기 위한 REST Controller, DTO, Entity, Repository 구현하기 
### 더미 데이터 `data.sql`
```sql
INSERT INTO coffee(name, price) VALUES('아메리카노', '4500');
INSERT INTO coffee(name, price) VALUES('라떼', '5000');
INSERT INTO coffee(name, price) VALUES('카페 모카', '5500');
```
### 구현하기
1. REST 컨트롤러: `api/CoffeeApiController.java`
2. DTO: `dto/CoffeeDTO.java`, `dto/CoffeeUpdateDTO.java`
3. Entity: `entity/Coffee.java`
4. Repository: `repository/CoffeeRepository.java`