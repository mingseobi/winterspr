package com.example.winterspr.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("")
@Controller
public class DefaultController {
    @GetMapping("/index")
    public String index(@RequestParam String name
            , @RequestParam int age
            , Model model){
        /*
        http://localhost:8080/index
        ?name=111
        &key=value
        &key=value
        */
        System.out.println("name : " + name);
        model.addAttribute("name", name);
        return "index";
    }

    //calculate 라는 페이지 만들어서, a와 b 정수값 입력받아서 더한 값을 페이지에 출력해보기!
    @GetMapping("/calculate")
    public String calculate(int a, int b, Model model){
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        int sum = a + b;
        model.addAttribute("sum", sum);
        return "test/calculate";
    }

    //idpw 라는 페이지 만들어서, id와 pw 문자열 값 입력받아서
    // id는 winterspr, pw는 abcd1234 인지 확인해서 일치하는지 여부 화면에 띄우기
    @GetMapping("idpw")
    public String idpw(String id, String pw ,Model model){
        String[][] idpw = {
                {"a1", "b1"}
                ,{"a2", "b2"}
                ,{"winterspr", "abcd1234"}
        };
        System.out.println("idpw");
        System.out.println("id : " + id);
        System.out.println("pw : " + pw);
        boolean result = false;
        for(int i=0;i<idpw.length;i++){
            if(id.equals(idpw[i][0])){
                if(pw.equals(idpw[i][1])){
                    result = true;
                }
            }
        }

        /*
        if("winterspr".equals(id)){
            if("abcd1234".equals(pw)){
                result = true;
            }
        }
        */
        model.addAttribute("result", result);

        return "idpw";
    }

}
