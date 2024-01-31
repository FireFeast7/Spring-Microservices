package org.backend.rabbitmq.services;

import lombok.RequiredArgsConstructor;
import org.backend.rabbitmq.dto.CustomerRegistrationRequest;
import org.backend.rabbitmq.dto.FraudCheckResponse;
import org.backend.rabbitmq.entity.Customer;
import org.backend.rabbitmq.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                        .lastName(request.lastName())
                                .email(request.email())
                                        .build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse response = restTemplate.getForObject("http://localhost:8081/api/v1/fraud/{customer_id}", FraudCheckResponse.class,customer.getId());
        if(response.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

    }
}
