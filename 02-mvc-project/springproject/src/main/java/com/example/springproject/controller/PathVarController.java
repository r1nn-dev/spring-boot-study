package com.example.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PathVarController {

    @GetMapping("/users/{username}") // URL 경로의 {username} 값을 파라미터로 전달받는다.
    @ResponseBody                    // 반환값을 View 이름으로 해석하지 않고 HTTP 응답 본문에 그대로 담는다.
    public String getUserInfo(@PathVariable String username) {
        return "hello, " + username + "!";
    }

    @GetMapping("/sum/{lastnum}") // URL 경로에서 lastnum 값을 문자열로 전달받는다.
    @ResponseBody                 // 반환값을 View 이름으로 해석하지 않고 문자열 그대로 HTTP 응답 본문에 담는다.
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
    @GetMapping("/sum2/{lastnum2}") // URL 경로에서 lastnum2 값을 int로 바로 전달받는다.
    @ResponseBody                   // 반환값을 View 이름으로 해석하지 않고 문자열 그대로 HTTP 응답 본문에 담는다.
    public String getSum2(@PathVariable int lastnum2) {
        int sum = 0;

        // 1부터 lastnum2까지의 값을 누적하여 합을 계산한다.
        for (int i = 1; i <= lastnum2; i++) {
            sum += i;
        }

        String strSum2 = String.format("<h1>1에서 %d까지의 합은 %d입니다.</h1>", lastnum2, sum);
        return strSum2;
    }

    @GetMapping("/users/{username}/orders/{orderNum}") // URL 경로에서 username과 orderNum 값을 전달받는다.
    @ResponseBody                                      // 반환값을 View 이름으로 해석하지 않고 문자열 그대로 HTTP 응답 본문에 담는다.
    public String getOrder(@PathVariable String username, @PathVariable int orderNum) {
        String orderUser = String.format("User Name: %s, Order No: %d", username, orderNum);
        return orderUser;
    }

    // URL 경로로 들어오는 GET 요청을 처리하는 메서드
    @GetMapping("/posts/{category}/{postId}") // URL 경로에서 category와 postId 값을 전달받는다.
    @ResponseBody                             // 반환값을 View 이름으로 해석하지 않고 문자열 그대로 HTTP 응답 본문에 담는다.
    public String getPost(@PathVariable String category, @PathVariable int postId) {
        return String.format("Category: %s, Post Id: %d", category, postId);
    }
}