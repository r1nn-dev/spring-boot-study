package com.example.boardproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController        //JSON이나 Text같은 데이터 반환
public class FirstApiController {

    //hello world 출력
    @GetMapping("/api/hello")
    public String hello(){
        return "Hello World!!";
    }

}
