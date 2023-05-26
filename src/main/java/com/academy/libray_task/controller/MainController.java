package com.academy.libray_task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    private String getMainPage(){
        return "main";
    }

}
