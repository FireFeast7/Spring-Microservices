package org.backend.customer.dto;

public record CustomerRegistrationRequest (
        String firstName,
        String lastName,
        String email
){
}
