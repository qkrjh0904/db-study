package com.example.dbstudy.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ChatService implements MessageListener {

    @Autowired
    private RedisMessageListenerContainer redisMessageListenerContainer;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void enterChatRoom(String chatRoom) {
        redisMessageListenerContainer.addMessageListener(this, new ChannelTopic(chatRoom));

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String message = scanner.nextLine();
            if (message.equals("q")) {
                System.out.println("Quitting chat room");
                break;
            }

            redisTemplate.convertAndSend(chatRoom, message);
        }

        redisMessageListenerContainer.removeMessageListener(this);
        scanner.close();
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("Received message: " + message.toString());
    }
}
