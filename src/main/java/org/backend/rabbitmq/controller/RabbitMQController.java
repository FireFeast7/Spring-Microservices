//package org.backend.rabbitmq.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.backend.rabbitmq.dto.UserDto;
//import org.backend.rabbitmq.publisher.RabbitMQJsonProducer;
//import org.backend.rabbitmq.publisher.RabbitMQProducer;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(path = "/api/v1")
//@RequiredArgsConstructor
//public class RabbitMQController {
//
//    private final RabbitMQProducer rabbitMQProducer;
//    private final RabbitMQJsonProducer rabbitMQJsonProducer;
//
//    @GetMapping(path = "/publish")
//    public ResponseEntity<String> sendMessage(
//            @RequestParam("message") String message
//    ){
//        rabbitMQProducer.sendMessage(message);
//        return ResponseEntity.ok("Message Sent");
//    }
//
//    @PostMapping(path = "/publishJson")
//    public ResponseEntity<String> sendJsonMessage(
//            @RequestBody UserDto userDto
//            ){
//        rabbitMQJsonProducer.sendJsonMessage(userDto);
//        return ResponseEntity.ok("Json Message Sent");
//    }
//
//}
