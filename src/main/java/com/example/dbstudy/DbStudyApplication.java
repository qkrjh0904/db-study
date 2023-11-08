package com.example.dbstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DbStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbStudyApplication.class, args);
    }

}
