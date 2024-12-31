package com.example.winterspr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class DefaultRestController {
    @GetMapping("/index")
    public String index(){
        return "Hello World";
    }
}
