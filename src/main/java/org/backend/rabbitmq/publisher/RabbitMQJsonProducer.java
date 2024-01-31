package org.backend.rabbitmq.publisher;

import lombok.RequiredArgsConstructor;
import org.backend.rabbitmq.consumer.RabbitMQConsumer;
import org.backend.rabbitmq.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQJsonProducer {

    @Value("${rabbitMQ.exchange.name}")
    private String exchange;

    @Value("${rabbitMQ.binding.routing.key}")
    private String jsonKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(UserDto user){
        LOGGER.info(String.format("Message send -> %s",user.toString()));
        rabbitTemplate.convertAndSend(exchange,jsonKey,user);
    }
}
