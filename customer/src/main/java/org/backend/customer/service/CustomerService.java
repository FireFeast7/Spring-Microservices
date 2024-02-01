package org.backend.customer.service;

import lombok.RequiredArgsConstructor;
import org.backend.customer.dto.CustomerRegistrationRequest;
import org.backend.customer.dto.FraudCheckResponse;
import org.backend.customer.entity.Customer;
import org.backend.customer.repository.CustomerRepository;
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
        FraudCheckResponse response = restTemplate.getForObject("http://FRAUD/api/v1/fraud/{customer_id}", FraudCheckResponse.class,customer.getId());
        if(response.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

    }
}
