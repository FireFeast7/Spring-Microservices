package org.backend.notification.consumer;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.backend.client.notification.NotificationRequest;
import org.backend.notification.services.NotificationsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageConsumer {

    private final NotificationsService notificationsService;
    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consumer(NotificationRequest notificationRequest){
        log.info("Consumed {} from queue",notificationRequest);
        notificationsService.sendNotification(notificationRequest);
    }
}
