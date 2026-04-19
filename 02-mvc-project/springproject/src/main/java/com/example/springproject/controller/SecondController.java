package com.example.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class SecondController {

    @GetMapping("/main")    // "/main"으로 들어오는 GET 요청을 이 메서드가 처리한다.
    @ResponseBody           // 반환값을 View 이름으로 해석하지 않고 HTTP 응답 본문에 그대로 담는다.
    public String main1() {
        return "<h1>hello ResponseBody!</h1>"; // HTML 문자열을 직접 응답한다.
    }

    @GetMapping("/now")        // "/now"로 들어오는 GET 요청을 이 메서드가 처리한다.
    @ResponseBody              // 반환값을 View 이름으로 해석하지 않고 HTTP 응답 본문에 그대로 담는다.
    public String now() {

        LocalDateTime now = LocalDateTime.now(); // 현재 날짜와 시간을 가져온다.

        // 오늘은 3월 17일 입니다.
        // return "오늘은 " + month + "월 " + day + "일 입니다.";
        // month, day 값을 문자열에 포맷팅하여 반환한다.
        String nowText = String.format("오늘은 %d월 %d일 입니다.", now.getMonthValue(), now.getDayOfMonth());
        return nowText; // 현재 날짜를 일반 문자열로 반환한다.
    }

    @GetMapping("/now2")       // "/now2"로 들어오는 GET 요청을 이 메서드가 처리한다.
    @ResponseBody              // 반환값을 View 이름으로 해석하지 않고 HTTP 응답 본문에 그대로 담는다.
    public String now2() {

        LocalDateTime now = LocalDateTime.now(); // 현재 날짜와 시간을 가져온다.

        // 오늘은 3월 17일 입니다.
        // return "오늘은 " + month + "월 " + day + "일 입니다.";
        // 날짜 문자열을 h1 태그로 감싸서 HTML 형태로 반환한다.
        String nowH1 = String.format("<h1>오늘은 %d월 %d일 입니다.</h1>", now.getMonthValue(), now.getDayOfMonth());

        return nowH1; // 현재 날짜를 h1 태그가 포함된 HTML 문자열로 반환한다.
    }

    int cnt = 0; // 클래스 밖에 선언해야 한다.
// 클래스 필드로 선언하여 요청이 들어올 때마다 값을 누적한다.

    @GetMapping("/counter")    // "/counter"로 들어오는 GET 요청을 이 메서드가 처리한다.
    @ResponseBody              // 반환값을 View 이름으로 해석하지 않고 HTTP 응답 본문에 그대로 담는다.
    public String counter() {
        cnt += 1;                              // 요청이 들어올 때마다 카운터를 1 증가시킨다.
        String nCnt = Integer.toString(cnt);   // int 값을 문자열로 변환한다.
        return nCnt;
    }

    @GetMapping("/counter2")   // "/counter2"로 들어오는 GET 요청을 이 메서드가 처리한다.
    @ResponseBody              // 반환값을 View 이름으로 해석하지 않고 img 태그 문자열 그대로 HTTP 응답 본문에 담는다.
    public String counter2() {
        cnt += 1; // 요청이 들어올 때마다 카운터를 1 증가시킨다.

        // Integer -> String -> String split -> int tag로 convert
        // 현재 숫자를 문자열로 변환하여 각 자릿수를 순회할 준비를 한다.
        String imgCnt = Integer.toString(cnt);
        System.out.println("Image Cnt: " + imgCnt);
        System.out.println("Image Length: " + imgCnt.length());

        String result = "";

        //result = "<img src='number/1.png' width ='100' height ='100'>";
        // 숫자의 각 자릿수를 number 폴더의 이미지 파일명과 매핑한다.
        for (int i = 0; i < imgCnt.length(); i++) {
            result += String.format(
                    "<img src='number/%c.png' width='100' height='100'>",
                    imgCnt.charAt(i)
            ); // 각 자리 숫자를 문자로 꺼내 이미지 경로에 연결한다.
        }

        return result; // 최종적으로 여러 개의 img 태그를 이어 붙인 HTML 문자열을 반환한다.
    }

    @GetMapping("/banner")     // "/banner"로 들어오는 GET 요청을 이 메서드가 처리한다.
    @ResponseBody              // 반환값을 View 이름으로 해석하지 않고 a 태그와 img 태그가 포함된 HTML 문자열을 HTTP 응답 본문에 담는다.
    public String banner() {
        String bannerHtml = "";

        // 배너 이미지 파일명 목록
        String[] bannerImg = {"daum", "google", "naver"};

        // 각 배너 클릭 시 이동할 링크 목록
        String[] bannerLink = {"www.daum.net", "www.google.com", "www.naver.com"};

        // 각 배너 이미지를 링크와 결합하여 HTML 문자열을 생성한다.
        for (int i = 0; i < bannerImg.length; i++) {
            bannerHtml += String.format(
                    "<a href='http://%s'><img src='banner/%s.jpg' width='200' height='100'></a><br>",
                    bannerLink[i], bannerImg[i]
            );
        }

        return bannerHtml;
    }

    // 하드코딩 방식
    @GetMapping("/banner2")    // "/banner2"로 들어오는 GET 요청을 이 메서드가 처리한다.
    @ResponseBody              // 반환값을 View 이름으로 해석하지 않고 a 태그와 img 태그가 포함된 HTML 문자열을 HTTP 응답 본문에 담는다.
    public String banner2() {
        String result1 = "<a href='https://www.daum.net'><img src='banner/daum.jpg' width='200' height='100'></a>";
        String result2 = "<a href='https://www.google.com'><img src='banner/google.jpg' width='200' height='100'></a>";
        String result3 = "<a href='https://www.naver.com'><img src='banner/naver.jpg' width='200' height='100'></a>";

        // 생성된 HTML 문자열을 콘솔에서 확인한다.
        System.out.println(result1); // 생성된 첫 번째 배너 HTML을 콘솔에 출력한다.
        System.out.println(result2); // 생성된 두 번째 배너 HTML을 콘솔에 출력한다.
        System.out.println(result3); // 생성된 세 번째 배너 HTML을 콘솔에 출력한다.

        return result1 + result2 + result3; // 3개의 배너를 이어 붙여 반환한다.
    }
}