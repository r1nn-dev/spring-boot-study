package com.example.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PathVarController {
    @GetMapping("/users/{username}")
    @ResponseBody // View 없이 바로 결과 출력
    public String getUserInfo(@PathVariable String username){
        return "hello, " + username + "!";
    }

    @GetMapping("/sum/{lastnum}")
    @ResponseBody // View 없이 바로 결과 출력
    public String getSum(@PathVariable String lastnum){
        int sum=0;
        for(int i=1; i<=Integer.parseInt(lastnum); i++) {
            sum += i;
        }
        String strSum = String.format("<h1>1에서 %s까지의 합은 %d입니다.</h1>", lastnum, sum);
        return strSum;
    }

    @GetMapping("/sum/{lastnum}")
    @ResponseBody // View 없이 바로 결과 출력
    public String getSum2(@PathVariable int lastnum){
        int sum=0;
        for(int i=1; i<=lastnum; i++) {
            sum += i;
        }
        String strSum = String.format("<h1>1에서 %d까지의 합은 %d입니다.</h1>", lastnum, sum);
        return strSum;
    }

    @GetMapping("/users/{username}/orders/{num}")
    @ResponseBody // View 없이 바로 결과 출력
    public String getOrder(@PathVariable String username, @PathVariable int num){
        return "User Name: " + username + ", Order No:" + num;
    }
    @GetMapping("/posts/{category}/{postnum}")
    @ResponseBody // View 없이 바로 결과 출력
    public String getPost(@PathVariable String category, @PathVariable int postnum){
        return "Category: " + category + ", Post Id:" + postnum;
    }

    @GetMapping("/users/{username}/orders/{order_num}")
    @ResponseBody // View 없이 바로 결과 출력
    public String getOrder2(@PathVariable String username, @PathVariable int order_num){
        return String.format("User Name: %s, Order No: %d", username, order_num);
    }
    @GetMapping("/posts/{category}/{postId}")
    @ResponseBody // View 없이 바로 결과 출력
    public String getPost2(@PathVariable String category, @PathVariable int postId){
        return String.format("Category: %s, Post Id: %d", category, postId);
    }
}
