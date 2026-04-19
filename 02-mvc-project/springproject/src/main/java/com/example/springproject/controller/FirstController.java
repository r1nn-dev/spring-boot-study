package com.example.springproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller      // Spring MVC가 해당 클래스를 컨트롤러로 인식하도록 등록한다.
public class FirstController {

    @GetMapping("/hi")      // "/hi"로 들어오는 GET 요청을 이 메서드가 처리한다.
    public String niceToMeetYou(Model model) {      // Model 객체를 통해 View에 전달할 데이터를 담는다.
        model.addAttribute("username", "홍팍");      // "username"이라는 이름으로 데이터를 저장한다.
        return "greetings"; // View 이름을 반환한다.
        // templates/greetings.mustache 파일을 찾아 렌더링한다.
    }

    @GetMapping("/bye")     // "/bye"로 들어오는 GET 요청을 이 메서드가 처리한다.
    public String seeYouNext(Model model) {        // Model 객체를 통해 View에 전달할 데이터를 담는다.
        model.addAttribute("nickname", "조정석");   // goodbye.mustache 에서 사용할 데이터를 저장한다.
        return "goodbye";                          // templates/goodbye.mustache 파일을 찾아 렌더링한다.
    }
}