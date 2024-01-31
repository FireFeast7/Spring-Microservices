package org.backend.rabbitmq.dto;

public record CustomerRegistrationRequest (
        String firstName,
        String lastName,
        String email
){
}
