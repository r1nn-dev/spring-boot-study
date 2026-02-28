package com.example.firstproject.controller;

// URL 연결 요청(@GetMapping())과 동시에 자동으로 임포트
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // Model 클래스 패키지 자동 임포트
import org.springframework.web.bind.annotation.GetMapping;

@Controller   // 컨트롤러 선언 - 이 클래스는 뷰를 반환하는 MVC 컨트롤러이다.
public class FirstController {

    @GetMapping("/hi")   // URL 요청 접수 - 메서드가 요청을 처리하도록 매핑
    // niceToMeetYou() 메서드 작성
    public String niceToMeetYou(Model model) {  // 모델 받아오기 - 파라미터에 추가
        // 1) Model에 데이터 등록: addAttribute(key, value)
        // 컨트롤러가 Model에 데이터를 담는다:
        // 변숫값을 "변수명"이라는 이름(key)으로 추가
        // model 객체가 "사용자" 값을 "username"에 연결해 웹 브라우저로 보냄
        model.addAttribute("username", "사용자"); // 모델 변수 등록
        // 2) 뷰 이름 반환
        // template/greetings.mustache -> 브라우저로 전송 - 뷰 템플릿 페이지 반환
        // 서버가 templates 디렉터리에서 파일 찾아 웹 브라우저로 전송
        return "greetings";
    }

}
