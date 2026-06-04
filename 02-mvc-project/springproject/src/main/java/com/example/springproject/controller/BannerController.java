package com.example.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BannerController {

    /*
     * 1.
     */
    @GetMapping("/banner")   // "/banner"로 들어오는 GET 요청을 이 메서드가 처리한다.
    @ResponseBody               // a 태그와 img 태그가 포함된 HTML 문자열을 HTTP 응답 본문에 담는다.
    public String banner() {
        String bannerHtml = "";

        // 배너 이미지 파일명 목록
        String[] bannerImg = {"daum", "google", "naver"};

        // 각 배너 클릭 시 이동할 링크 목록
        String[] bannerLink = {"www.daum.net", "www.google.com", "www.naver.com"};

        // 이미지 파일명과 링크를 같은 인덱스로 매칭한다.
        // 각 배너 이미지를 링크와 결합하여 HTML 문자열을 생성한다.
        for (int i = 0; i < bannerImg.length; i++) {
            bannerHtml += String.format(
                    "<a href='http://%s'><img src='banner/%s.jpg' width='200' height='100'></a><br>",
                    bannerLink[i], bannerImg[i]
            );
        }

        return bannerHtml;
    }

    /*
     * 2. 하드코딩 방식
     */
    @GetMapping("/banner2")   // "/banner2"로 들어오는 GET 요청을 이 메서드가 처리한다.
    @ResponseBody                // a 태그와 img 태그가 포함된 HTML 문자열을 HTTP 응답 본문에 담는다.
    public String banner2() {
        String result1 = "<a href='https://www.daum.net'><img src='banner/daum.jpg' width='200' height='100'></a>";
        String result2 = "<a href='https://www.google.com'><img src='banner/google.jpg' width='200' height='100'></a>";
        String result3 = "<a href='https://www.naver.com'><img src='banner/naver.jpg' width='200' height='100'></a>";

        // 생성된 HTML 문자열을 콘솔에서 확인한다.
        System.out.println(result1);   // 생성된 첫 번째 배너 HTML을 콘솔에 출력한다.
        System.out.println(result2);   // 생성된 두 번째 배너 HTML을 콘솔에 출력한다.
        System.out.println(result3);   // 생성된 세 번째 배너 HTML을 콘솔에 출력한다.

        return result1 + result2 + result3;   // 3개의 배너를 이어 붙여 반환한다.
    }
}
