package com.example.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class DateController {

    /*
     * 1. 오늘 날짜 출력
     */
    @GetMapping("/now")   // "/now"로 들어오는 GET 요청을 이 메서드가 처리한다.
    @ResponseBody            // 반환값을 View 이름으로 해석하지 않고 HTTP 응답 본문에 직접 담는다.
    public String now() {

        // 현재 날짜와 시간을 가져온다.
        LocalDateTime now = LocalDateTime.now();

        // 오늘은 3월 17일 입니다.
        // return "오늘은 " + month + "월 " + day + "일 입니다.";
        // month, day 값을 문자열에 포맷팅하여 반환한다.
        String nowText = String.format("오늘은 %d월 %d일 입니다.", now.getMonthValue(), now.getDayOfMonth());

        return nowText;   // 현재 날짜를 일반 문자열로 응답 본문에 반환한다.
    }

    /*
     * 2. H1 태그로 감싼 오늘 날짜 출력
     */
    @GetMapping("/now2")   // "/now2"로 들어오는 GET 요청을 이 메서드가 처리한다.
    @ResponseBody             // 반환값을 View 이름으로 해석하지 않고 HTTP 문자열을 응답 본문에 직접 담는다.
    public String now2() {

        // 현재 날짜와 시간을 가져온다.
        LocalDateTime now = LocalDateTime.now();

        // 오늘은 3월 17일 입니다.
        // return "오늘은 " + month + "월 " + day + "일 입니다.";
        // 날짜 문자열을 h1 태그로 감싸서 HTML 형태로 만든다.
        String nowH1 = String.format("<h1>오늘은 %d월 %d일 입니다.</h1>", now.getMonthValue(), now.getDayOfMonth());

        // 브라우저는 이 문자열을 HTML로 해석해 렌더링한다.
        return nowH1;    // 현재 날짜를 h1 태그가 포함된 HTML 문자열로 해석해 렌더링한다.
    }
}
