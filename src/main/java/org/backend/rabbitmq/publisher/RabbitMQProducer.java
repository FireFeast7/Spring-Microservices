//package org.backend.rabbitmq.publisher;
//
//import lombok.RequiredArgsConstructor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class RabbitMQProducer {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);
//
//    @Value("${rabbitMQ.exchange.name}")
//    private String exchange;
//
//    @Value("${rabbitMQ.binding.key}")
//    private String key;
//
//    private final RabbitTemplate rabbitTemplate;
//
//    public void sendMessage(String message){
//        LOGGER.info(String.format("Message sent -> %s" ,message));
//        rabbitTemplate.convertAndSend(exchange,key,message);
//
//    }
//}
