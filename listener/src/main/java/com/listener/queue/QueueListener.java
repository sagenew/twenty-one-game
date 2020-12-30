package com.listener.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.listener.entity.CustomMessage;
import com.listener.repository.CustomMessageRepo;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class QueueListener implements MessageListener {
    ObjectMapper objectMapper = new ObjectMapper();
    CustomMessageRepo repo;
    public QueueListener(CustomMessageRepo repo) {
        this.repo = repo;
    }

    @Override
    public void onMessage(Message message) {
        try {
            CustomMessage customMessage = objectMapper.readValue(message.getBody(), CustomMessage.class);
            System.out.println("Received : < " +customMessage.toString() + " >");
            repo.save(customMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
