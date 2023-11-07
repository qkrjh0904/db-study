package com.example.dbstudy.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public UserProfileDto getUserProfile(@PathVariable String userId) {
        return userService.getUserProfile(userId);
    }
}
