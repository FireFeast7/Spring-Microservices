package org.backend.rabbitmq.services;

import org.backend.rabbitmq.dto.CustomerRegistrationRequest;
import org.backend.rabbitmq.entity.Customer;
import org.backend.rabbitmq.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                        .lastName(request.lastName())
                                .email(request.email())
                                        .build();
        customerRepository.save(customer);
    }
}
