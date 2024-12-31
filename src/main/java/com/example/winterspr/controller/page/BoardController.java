package com.example.winterspr.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/board")
@Controller
public class BoardController {
    /*
    @GetMapping("/create")
    public String create(){
        return "board/create";
    }
    @GetMapping("/update")
    public String update(){
        return "board/update";
    }
    */

    //PathVariable => url에 있는 값을 변수로 받아올수 있는 기능!!
    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return "board/" + page;
    }

    //PathVariable 여러개도 사용 가능함!! /로 구분하기만 하면!
    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id){
        return "board/" + page;
    }

}
