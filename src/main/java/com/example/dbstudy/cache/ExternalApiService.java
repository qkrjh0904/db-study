package com.example.dbstudy.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ExternalApiService {
    public String getUserName(String userId) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (userId.equals("A")) {
            return "Alice";
        }
        if (userId.equals("B")) {
            return "Bob";
        }
        return "";
    }

    @Cacheable(cacheNames = "userAgeCache", key = "#userId")
    public int getAge(String userId) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        if (userId.equals("A")) {
            return 20;
        }
        if (userId.equals("B")) {
            return 30;
        }
        return 0;
    }
}
