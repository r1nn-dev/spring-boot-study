package com.example.bootstrapproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller      // Spring MVC가 해당 클래스를 컨트롤러로 인식하도록 등록한다.
public class MyController {

    @RequestMapping("/test")            // "/test"로 들어오는 GET 요청을 이 메서드가 처리한다.
    public String test(Model model) {
        // View 데이터를 Model에 저장한다.
        model.addAttribute("username", "이지은");    // "username"이라는 이름으로 데이터를 저장한다.
        // greetings.mustache 파일을 찾아 렌더링한다.
        return "greeting";
    }

    @RequestMapping("/hi")             // "/hi"로 들어오는 GET 요청을 이 메서드가 처리한다.
    public String hi(Model model) {
        // View 데이터를 Model에 저장한다.
        model.addAttribute("username", "이지은");    // "username"이라는 이름으로 데이터를 저장한다.
        // greetings.mustache 파일을 찾아 렌더링한다.
        return "greetings";
    }
    @RequestMapping("/bye")             // "/bye"로 들어오는 GET 요청을 이 메서드가 처리한다.
    public String bye(Model model) {
        // View 데이터를 Model에 저장한다.
        model.addAttribute("nickname", "아이유");    // "nickname"이라는 이름으로 데이터를 저장한다.
        // goodbye.mustache 파일을 찾아 렌더링한다.
        return "goodbye";
    }

}
