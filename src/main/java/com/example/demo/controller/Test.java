package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
    @RequestMapping("test")
    public String Login(){
        System.out.println("test-------------");
        return "WebSocket";
    }
}
