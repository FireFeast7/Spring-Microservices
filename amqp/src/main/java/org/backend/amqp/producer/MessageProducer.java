package org.backend.amqp.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String topicExchange){
        log.info("Publishing ");
    }
}
