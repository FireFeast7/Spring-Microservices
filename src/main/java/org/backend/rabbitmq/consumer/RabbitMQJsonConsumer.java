//package org.backend.rabbitmq.consumer;
//
//import lombok.RequiredArgsConstructor;
//import org.backend.rabbitmq.dto.UserDto;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class RabbitMQJsonConsumer {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);
//
//    @RabbitListener(queues = {"${rabbitMQ.queue.json.name}"})
//    public void consumeJsonMessage(UserDto userDto){
//        LOGGER.info(String.format("Received Json Message %s",userDto.toString()));
//    }
//
//}
