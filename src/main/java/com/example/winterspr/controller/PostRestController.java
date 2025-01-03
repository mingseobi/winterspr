package com.example.winterspr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/Post") // 주소를 적어주는 것이다.
@RestController
public class PostRestController {

    List<Map<String, Object>> list_post = new ArrayList<Map<String, Object>>();

    //create
    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params) {

        params.put("id", list_post.size() + 1);
        list_post.add(params);

        Map<String, Object> returnValue = new HashMap<String, Object>();
        //저장을 해주기!!

        returnValue.put("code", 200);
        returnValue.put("message", "Post created successfully");
        returnValue.put("post", params);

        return returnValue;
    }

    //update
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params) {
        System.out.println("Update Post");
        System.out.println("Id: " + params.get("id"));
        System.out.println("Title: " + params.get("title"));
        System.out.println("Content: " + params.get("content"));
        int id = Integer.parseInt(params.get("id").toString()); //1

        Map<String, Object> post = list_post.get(id - 1);
        post.put("title", params.get("title"));
        post.put("content", params.get("content"));

        Map<String, Object> returnValue = new HashMap<String, Object>();
        returnValue.put("code", 200);
        returnValue.put("id", post.get("id"));

        return returnValue;
    }

    //delete
    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params) {
        System.out.println("Delete Post");
        System.out.println("Id: " + params.get("id"));
        params.put("title", "(deleted)");
        params.put("content", "(deleted)");
        return update(params);
    }

    //list
    @GetMapping("/list")
    public List<Map<String, Object>> list() {
        System.out.println("List Post");
        return list_post;
    }

    //detail
    @GetMapping("/detail")
    public Map<String, Object> detail(@RequestParam Map<String, Object> params) {
        System.out.println("Detail Post");
        int id = Integer.parseInt(params.get("id").toString()); //1

        Map<String, Object> returnValue = new HashMap<String, Object>();
        returnValue.put("code", 200);
        returnValue.put("data", list_post.get(id - 1)); //0번째 데이터 꺼내서 돌려주기!

        return returnValue;
    }


}