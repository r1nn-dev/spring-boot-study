# MVC 패턴(Model–View–Controller Pattern)

## 1. MVC 패턴 개요
뷰 템플릿(View Template)
- 사용자에게 보여지는 웹 페이지 화면(View)을 하나의 템플릿(Template)으로 만들고, 여기에 데이터를 주입하여 다양한 화면을 생성하는 방식 
- MVC 패턴(Model–View–Controller Pattern) : 웹 애플리케이션의 책임을 분리하여 유지보수성, 확장성, 테스트 용이성을 높이기 위한 아키텍처 패턴
- Model : 애플리케이션의 데이터와 상태를 관리한다.
- View : 사용자에게 보여지는 웹 페이지 화면을 담당한다.
- Controller : 클라이언트의 요청을 받아 처리 흐름을 제어하고, Model을 구성하여 View로 전달한다.

## 2. Spring MVC 요청 처리 흐름
1. 클라이언트가 URL로 HTTP 요청을 전송한다.
2. 컨트롤러가 요청을 매핑하여 처리 메서드를 실행한다.
3. 컨트롤러가 비즈니스 로직을 수행하고 Model에 데이터를 담는다.
4. 컨트롤러가 View 이름(view name)을 반환한다.
5. 스프링이 templates에서 템플릿을 찾아 렌더링한 뒤 응답한다.

## 3. View Template (Mustache)

## 4. 레이아웃(Layout)
레이아웃(layout): 화면에 구성 요소를 구조적으로 배치하는 방식
헤더-푸터 레이아웃(header-footer layout)
- 일반적으로 헤더(Header), 콘텐츠(Content), 푸터(Footer) 구조를 사용한다.
- 상단의 헤더(header) 영역: 사이트 안내를 위한 내비게이션(navigation)
- 하단의 푸터(footer) 영역: 사이트 정보
- 중앙의 콘텐트(content) 영역: 사용자가 볼 핵심 내용
- Mustache는 부분 템플릿(partial)을 통해 공통 영역을 재사용한다.

### 레이아웃 파일 분리
레이아웃 템플릿 생성과 적용
- 생성 위치:  `src/main/resources/templates/layouts`
- 파일의 확장자: `.mustache`
- 레이아웃 템플릿을 삽입할 때는 원하는 위치에서 `{{>파일경로/파일명}}` 형식으로 작성한다.
- 페이지를 템플릿화 하여 사용할 때는 콘텐츠 영역만 남기고 공통 영역(헤더/푸터)은 partial로 분리한다.
    - 헤더: `{{>header}}`
    - 푸터: `{{>footer}}`

### 레이아웃 적용
- 헤더: `{{>layouts/header}}`
- 푸터: `{{>layouts/footer}}`

