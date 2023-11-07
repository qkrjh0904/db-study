package com.example.dbstudy.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ExternalApiService externalApiService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public UserProfileDto getUserProfile(String userId) {
        String name = stringRedisTemplate.opsForValue().get("nameKey" + userId);


        String name = externalApiService.getUserName(userId);
        int age = externalApiService.getAge(userId);
        return UserProfileDto.of(name, age);
    }
}
