package com.example.dbstudy.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    private ExternalApiService externalApiService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public UserProfileDto getUserProfile(String userId) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String name = stringRedisTemplate.opsForValue().get("nameKey" + userId);
        if (name == null) {
            name = externalApiService.getUserName(userId);
            stringRedisTemplate.opsForValue().set("nameKey" + userId, name, 20, TimeUnit.SECONDS);
        }
        int age = externalApiService.getAge(userId);
        stopWatch.stop();
        System.out.println("Elapsed Time: " + stopWatch.getTotalTimeSeconds());
        return UserProfileDto.of(name, age);
    }
}
