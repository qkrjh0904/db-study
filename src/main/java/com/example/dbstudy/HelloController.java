package com.example.dbstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    //setFruit?name=banana
    @GetMapping("/setFruit")
    public String setFruit(@RequestParam String name) {
        stringRedisTemplate.opsForValue().set("fruit", name);
        return "saved";
    }

    //getFruit
    @GetMapping("/getFruit")
    public String getFruit() {
        return stringRedisTemplate.opsForValue().get("fruit");
    }

}
