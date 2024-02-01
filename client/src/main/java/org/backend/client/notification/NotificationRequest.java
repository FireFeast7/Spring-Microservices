package org.backend.client.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public record NotificationRequest (
     Integer toCustomerId,
     String toCustomerMessage,
     String message
){

}
