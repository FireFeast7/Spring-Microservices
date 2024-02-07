package org.backend.customer.service;

import lombok.RequiredArgsConstructor;
import org.backend.amqp.producer.MessageProducer;
import org.backend.client.fraud.FraudCheckResponse;
import org.backend.client.fraud.FraudClient;
import org.backend.client.notification.NotificationClient;
import org.backend.client.notification.NotificationRequest;
import org.backend.customer.dto.CustomerRegistrationRequest;
import org.backend.customer.entity.Customer;
import org.backend.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    private final MessageProducer producer;
    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                         .lastName(request.lastName())
                                .email(request.email())
                                        .build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());
        if(response.isFraudster()){
            throw new IllegalStateException("fraudster");
        }


//                new NotificationRequest(
//                        customer.getId(),
//                        customer.getEmail(),
//                        String.format("Hi %s, welcome to Microservices",customer.getFirstName())
//                )
//        );
        producer.publish(new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        String.format("Hi %s, welcome to Microservices",customer.getFirstName())
                ),"internal.exchanges","internal.notification.routing-key");
    }

}
