package org.backend.notification.services;

import lombok.RequiredArgsConstructor;
import org.backend.client.notification.NotificationRequest;
import org.backend.notification.entity.Notification;
import org.backend.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationsService {

    private final NotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest notificationRequest){
        notificationRepository.save(Notification
                .builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerMessage())
                        .sender("demo")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                .build());
    }
}
