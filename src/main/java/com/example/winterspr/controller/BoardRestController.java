package com.example.winterspr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/board") // 주소를 적어주는 것이다.
@RestController
public class BoardRestController {

    List<Map<String, Object>> boards = new ArrayList<Map<String, Object>>();

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params) {
        System.out.println("Create Board");
        System.out.println("Title: " + params.get("title"));
        System.out.println("Content: " + params.get("content"));

        Map<String, Object> board = new HashMap<String, Object>();
        board.put("id", boards.size() + 1);
        board.put("title", params.get("title"));
        board.put("content", params.get("content"));
        boards.add(board);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 200);
        result.put("id", board.get("id"));

        return result;
    }
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params) {
        System.out.println("Update Board");
        System.out.println("Id: " + params.get("id"));
        System.out.println("Title: " + params.get("title"));
        System.out.println("Content: " + params.get("content"));
        int id = Integer.parseInt(params.get("id").toString()); //1

        Map<String, Object> board = boards.get(id - 1);
        board.put("title", params.get("title"));
        board.put("content", params.get("content"));

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 200);
        result.put("id", board.get("id"));

        return result;
    }
    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params) {
        System.out.println("Delete Board");
        System.out.println("Id: " + params.get("id"));
        params.put("title", "(deleted)");
        params.put("content", "(deleted)");
        return update(params);
    }

    @GetMapping("/list")
    public List<Map<String, Object>> list() {
        System.out.println("List Board");
        return boards;
    }
    @GetMapping("/detail")
    public Map<String, Object> detail(@RequestParam Map<String, Object> params) {
        System.out.println("Detail Board");
        int id = Integer.parseInt(params.get("id").toString()); //1

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 200);
        result.put("data", boards.get(id - 1)); //0번째 데이터 꺼내서 돌려주기!

        return result;
    }


}