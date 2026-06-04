package com.example.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PathVarController {

    /*
     * 1. 사용자 이름 출력
     */
    @GetMapping("/users/{username}")   // URL 경로의 {username} 값을 파라미터로 전달받는다.
    @ResponseBody                         // 문자열을 HTTP 응답 본문에 직접 반환한다.
    public String getUserInfo(@PathVariable String username) {
        return "hello, " + username + "!";
    }

    /*
     * 2. 합계 계산
     */
    @GetMapping("/sum/{lastnum}")      // URL 경로에서 lastnum 값을 문자열로 전달받는다.
    @ResponseBody                         // 계산 결과 문자열을 HTML 응답 본문에 직접 반환한다.
    public String getSum(@PathVariable String lastnum) {
        int sum = 0;

        // 문자열을 정수로 변환한 뒤 1부터 lastnum까지의 값을 누적하여 합을 계산한다.
        for (int i = 1; i <= Integer.parseInt(lastnum); i++) {
            sum += i;
        }

        String strSum = String.format("<h1>1에서 %s까지의 합은 %d입니다.</h1>", lastnum, sum);

        return strSum;
    }

    // URL 경로 값을 바로 int로 매핑하는 방식
    @GetMapping("/sum2/{lastnum2}")   // URL 경로에서 lastnum2 값을 int로 바로 전달받는다.
    @ResponseBody                        // 계산 결과 문자열을 HTML 응답 본문에 직접 반환한다.
    public String getSum2(@PathVariable int lastnum2) {
        int sum = 0;

        // 1부터 lastnum2까지의 값을 누적하여 합을 계산한다.
        for (int i = 1; i <= lastnum2; i++) {
            sum += i;
        }

        String strSum2 = String.format("<h1>1에서 %d까지의 합은 %d입니다.</h1>", lastnum2, sum);

        return strSum2;
    }

    /*
     * 3. 주문 정보 출력
     */
    @GetMapping("/users/{username}/orders/{orderNum}")   // URL 경로에서 username과 orderNum 값을 전달받는다.
    @ResponseBody                                           // 문자열을 HTTP 응답 본문에 직접 반환한다.
    public String getOrder(@PathVariable String username, @PathVariable int orderNum) {

        String orderUser = String.format("User Name: %s, Order No: %d", username, orderNum);

        return orderUser;
    }

    /*
     * 4. 게시글 정보 출력
     */
    // URL 경로로 들어오는 GET 요청을 처리하는 메서드
    @GetMapping("/posts/{category}/{postId}")   // URL 경로에서 category와 postId 값을 전달받는다.
    @ResponseBody                                  // 문자열을 HTTP 응답 본문에 직접 반환한다.
    public String getPost(@PathVariable String category, @PathVariable int postId) {
        return String.format("Category: %s, Post Id: %d", category, postId);
    }

}