package com.twentyone.rabbitmq;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twentyone.rabbitmq.entity.CustomMessage;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class RabbitBroker {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMessage(CustomMessage customMessage) {
        try {
            String messageJson = objectMapper.writeValueAsString(customMessage);
            Message message = MessageBuilder
                    .withBody(messageJson.getBytes())
                    .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                    .build();
            rabbitTemplate.convertAndSend("twenty-one-exchange",
                    "game.server",
                    message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
