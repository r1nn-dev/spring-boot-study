package com.example.springproject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class SecondController {
    @GetMapping("/main")
    @ResponseBody
    public String main1() {
        return "<h1>hello ResponseBody!</h1>";
    }

    @GetMapping("/now")
    @ResponseBody
    public String now() {
        LocalDateTime now = LocalDateTime.now();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        // 오늘은 3월 17일 입니다.
        // return "오늘은 " + month + "월 " + day + "일 입니다.";
        String nowtext = String.format("오늘은 %d월 %d일 입니다.", month, day);
        return nowtext;
    }

    @GetMapping("/now2")
    @ResponseBody
    public String now2() {
        LocalDateTime now = LocalDateTime.now();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        // 오늘은 3월 17일 입니다.
        // return "오늘은 " + month + "월 " + day + "일 입니다.";
        String nowh1 = String.format("<h1>오늘은 %d월 %d일 입니다.</h1>", month, day);
        return nowh1;
    }

    int cnt = 0; // 클래스 밖에 선언해야 한다.
    @GetMapping("/counter")
    @ResponseBody
    public String counter() {
        cnt += 1;

        return Integer.toString(cnt);
    }

    @GetMapping("/banner")
    @ResponseBody
    public String banner() {
        String result1 = "<a href='https://www.daum.net'><img src='banner/daum.jpg' width='200' height='100'></a>";
        String result2 = "<a href='https://www.google.com'><img src='banner/google.jpg' width='200' height='100'></a>";
        String result3 = "<a href='https://www.naver.com'><img src='banner/naver.jpg' width='200' height='100'></a>";
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        return result1 + result2 + result3;
    }

    @GetMapping("/banner")
    @ResponseBody
    public String banner2() {
        String bannerhtml = "";
        String[] bannerImg = {"daum", "google", "naver"};
        String[] bannerLink = {"www.daum.net", "www.google.com", "www.naver.com"};
        for (int i = 0; i < bannerImg.length; i++) {
            bannerhtml += String.format("<a href='https://%s'><img src='banner/%s.jpg' width='200' height='100'></a><br>", bannerLink[i], bannerImg[i]);
        }
        return bannerhtml;
    }
}

