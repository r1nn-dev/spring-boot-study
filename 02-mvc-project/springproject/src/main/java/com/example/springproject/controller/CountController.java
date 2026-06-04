package com.example.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CountController {

    // 요청이 들어올 때마다 증가시킬 카운터 값이다.
    private int cnt = 0;   //  클래스 필드로 선언하여 요청이 들어올 때마다 값을 누적한다.

    /*
     * 1. Counter 숫자 출력
     */
    @GetMapping("/counter")   // "/counter"로 들어오는 GET 요청을 이 메서드가 처리한다.
    @ResponseBody                // 숫자 문자열을 HTTP 응답 본문에 직접 반환한다.
    public String counter() {

        cnt += 1;                              // 요청이 들어올 때마다 카운터를 1 증가시킨다.
        String nCnt = Integer.toString(cnt);   // int 값을 문자열로 변환한다.

        return nCnt;                           // 증가한 카운터 값을 반환한다.
    }

    /*
     * 2. Counter 이미지 출력
     */
    @GetMapping("/counter2")   // "/counter2"로 들어오는 GET 요청을 이 메서드가 처리한다.
    @ResponseBody                 // img 태그 문자열을 HTTP 응답 본문에 직접 반환한다.
    public String counter2() {

        cnt += 1;   // 요청이 들어올 때마다 카운터를 1 증가시킨다.

        // Integer -> String -> String split -> int tag로 convert
        // 현재 숫자를 문자열로 변환하여 각 자릿수를 순회할 준비를 한다.
        String imgCnt = Integer.toString(cnt);

        // 현재 카운터 값과 자릿수를 콘솔에 출력해 확인한다.
        System.out.println("Image Cnt: " + imgCnt);
        System.out.println("Image Length: " + imgCnt.length());

        String result = "";

        //result = "<img src='number/1.png' width ='100' height ='100'>";
        // 숫자의 각 자릿수를 number 폴더의 이미지 파일명과 매핑한다.
        for (int i = 0; i < imgCnt.length(); i++) {
            result += String.format(
                    "<img src='number/%c.png' width='100' height='100'>",
                    imgCnt.charAt(i)
            );   // 각 자리 숫자를 문자로 꺼내 이미지 경로에 연결한다.
        }

        return result;   // 최종적으로 여러 개의 img 태그를 이어 붙인 HTML 문자열을 반환한다.
    }
}
