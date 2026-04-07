package com.example.bootstrapproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class myController {

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("username", "이지은");
        return "greeting";
    }

    @RequestMapping("/hi")
    public String hi(Model model) {
        model.addAttribute("username", "이지은");
        return "greetings";
    }
    @RequestMapping("/bye")
    public String bye(Model model) {
        model.addAttribute("nickname", "아이유");
        return "goodbye";
    }
}
