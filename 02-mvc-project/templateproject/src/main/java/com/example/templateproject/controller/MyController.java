package com.example.templateproject.controller;

import com.example.templateproject.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class MyController {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("name", "John");
        return "welcome"; // templates/welcome.mustache 파일을 렌더링
    }

    @GetMapping("/objectex")
    public String person(Model model) {
        Person person = new Person("아이유", 25, "서울특별시");
        model.addAttribute("person", person);
        return "objectex";
    }

    @GetMapping("/conditionex")
    public String login(Model model) {
        boolean logedIn = false;
        model.addAttribute("username", "아이유");
        model.addAttribute("logedIn", logedIn);
        return "conditionex";
    }

    @GetMapping("/loopex")
    public String getPersonList(Model model) {
        String[] fruits = {"apple", "banana", "orange"};

        List<Person> persons = Arrays.asList(
                // Person 객체
                new Person("아이유", 25, "서울"),
                new Person("유재석", 50, "부산"),
                new Person("안세영", 20, "광주")
        );

        model.addAttribute("fruits", fruits);
        model.addAttribute("persons", persons);
        return "loopex";
    }

    @GetMapping("/partialex")
    public String partialex(Model model) {
        String[] buttons = {"Cancel", "Save", "Insert"};
        model.addAttribute("buttons", buttons);
        return "partialex";
    }

    @GetMapping("/show-input")
    public String showInput(Model model) {
        String userInput = "<b>안녕하세요! 이 텍스트는 굵게 표시됩니다.</b>";
        model.addAttribute("userInput", userInput);
        return "no-escape";
    }
}
