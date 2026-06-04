package com.example.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecondController {

    @GetMapping("/main")    // "/main"으로 들어오는 GET 요청을 이 메서드가 처리한다.
    @ResponseBody              // 반환값을 View 이름으로 해석하지 않고 HTTP 응답 본문에 직접 담는다.
    public String main1() {
        return "<h1>hello ResponseBody!</h1>";   // HTML 문자열을 직접 응답한다.
    }
}