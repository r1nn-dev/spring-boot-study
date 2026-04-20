package com.example.templateproject.controller;

import com.example.templateproject.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class MyController {

    @GetMapping("/welcome")             // "/welcome"로 들어오는 GET 요청을 이 메서드가 처리한다.
    public String welcome(Model model) {   // Model 객체를 통해 View에 전달할 데이터를 담는다.
        // View에 전달할 데이터 설정
        model.addAttribute("name", "John");    // "name"이라는 이름으로 데이터를 저장한다.
        return "welcome";                  // templates/welcome.mustache 파일을 찾아 렌더링한다.
    }

    @GetMapping("/objectex")           // "/objectex"로 들어오는 GET 요청을 이 메서드가 처리한다.
    public String person(Model model) {   // Model 객체를 통해 View에 전달할 데이터를 담는다.
        // 객체 생성
        Person person = new Person("아이유", 25, "서울특별시");
        // Model에 객체 저장
        model.addAttribute("person", person);    // "person"이라는 이름으로 데이터를 저장한다.
        return "objectex";                // objectex.mustache 파일을 찾아 렌더링한다.
    }

    @GetMapping("/conditionex")       // "/conditionex"로 들어오는 GET 요청을 이 메서드가 처리한다.
    public String login(Model model) {   // Model 객체를 통해 View에 전달할 데이터를 담는다.
        boolean logedIn = false;
        model.addAttribute("username", "아이유");    // "username"이라는 이름으로 데이터를 저장한다.
        model.addAttribute("logedIn", logedIn);                 // "logedIn"이라는 이름으로 데이터를 저장한다.
        return "conditionex";                // conditionex.mustache 파일을 찾아 렌더링한다.
    }

    @GetMapping("/loopex")                    // "/loopex"로 들어오는 GET 요청을 이 메서드가 처리한다.
    public String getPersonList(Model model) {   // Model 객체를 통해 View에 전달할 데이터를 담는다.
        String[] fruits = {"apple", "banana", "orange"};

        List<Person> persons = Arrays.asList(
                // Person 객체
                new Person("아이유", 25, "서울"),
                new Person("유재석", 50, "부산"),
                new Person("안세영", 20, "광주")
        );

        model.addAttribute("fruits", fruits);      // "fruits"이라는 이름으로 데이터를 저장한다.
        model.addAttribute("persons", persons);    // "persons"이라는 이름으로 데이터를 저장한다.
        return "loopex";                // loopex.mustache 파일을 찾아 렌더링한다.
    }

    @GetMapping("/partialex")                    // "/partialex"로 들어오는 GET 요청을 이 메서드가 처리한다.
    public String partialex(Model model) {         // Model 객체를 통해 View에 전달할 데이터를 담는다.
        String[] buttons = {"Cancel", "Save", "Insert"};
        model.addAttribute("buttons", buttons);      // "buttons"이라는 이름으로 데이터를 저장한다.
        return "partialex";                // partialex.mustache 파일을 찾아 렌더링한다.
    }

    @GetMapping("/show-input")                  // "/show-input"로 들어오는 GET 요청을 이 메서드가 처리한다.
    public String showInput(Model model) {         // Model 객체를 통해 View에 전달할 데이터를 담는다.
        String userInput = "<b>안녕하세요! 이 텍스트는 굵게 표시됩니다.</b>";
        model.addAttribute("userInput", userInput);      // "userInput"이라는 이름으로 데이터를 저장한다.
        return "no-escape";                // no-escape.mustache 파일을 찾아 렌더링한다.
    }

}
