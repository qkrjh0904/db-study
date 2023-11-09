package com.example.dbstudy;

import com.example.dbstudy.chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

@EnableCaching
@SpringBootApplication
public class DbStudyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DbStudyApplication.class, args);
    }

    @Autowired
    private ChatService chatService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("App started..");
        chatService.enterChatRoom("chat1");
    }
}
