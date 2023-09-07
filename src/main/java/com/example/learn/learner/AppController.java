package com.example.learn.learner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
public class AppController {
    
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
