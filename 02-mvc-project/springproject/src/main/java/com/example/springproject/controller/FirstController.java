package com.example.springproject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // 컨트롤러 선언 - 객체 생성 및 관리 자동화 IoC
// 어노테이션
// 객체 생성 - new
// 제어의 주체가 개발자가 아닌 Spring - IoC
// 컴포넌트??
public class FirstController {
    // 클라이언트의 요청을 받을 함수 - URL
    // HTTP 통신 -
    // 요청 방식 2가지 - get, post
    // GET- 가볍고 중요하지 않은 정보
    // POST - 폼 데이터
    @GetMapping("/hi")  // GET 요청
    // 함수 정의
    public String NiceToMeetYou(Model model) {
        model.addAttribute("username", "홍팍");
        return "greetings";     // 컨트롤러에서 뷰 페이지 반환하기
        // 뷰의 이름 "greeting"으로 매칭이 된다.
    }

    @GetMapping("/bye")  // GET 요청
    // 함수 정의
    public String SeeYouNext(Model model) {
        model.addAttribute("nickname", "조정석");
        return "goodbye";
        // 뷰의 이름 "goodbye"으로 매칭이 된다.
    }
}
