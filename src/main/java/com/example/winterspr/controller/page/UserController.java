package com.example.winterspr.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

//    @GetMapping("/create")
//    public String page(){
//        return "user/" + "create"; // resources/templates/user/create.html 을 실행
//    }

    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return "user/" + page; // resources/templates/user/create.html 을 실행
    }

    @GetMapping("/{page}/{id}")
    public String page(@PathVariable String page, @PathVariable String id){
        return "user/" + page; // resources/templates/user/create.html 을 실행
    }

}
