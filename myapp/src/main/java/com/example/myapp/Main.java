package com.example.myapp;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {

    @GetMapping("/fruits")
    public HashMap<String, Object> m() {

        HashMap<String, Object> res = new HashMap<>();
        res.put("msg", "welcome to fruits api");
        res.put("mango", "🥭");
        res.put("apple", "🍎🍏");
        res.put("status", "200 ok");
        res.put("success", true);

        return res;
    }
}
