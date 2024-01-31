package org.backend.fraud.service;

import lombok.RequiredArgsConstructor;
import org.backend.fraud.entity.FraudCheckHistory;
import org.backend.fraud.repository.FraudCheckRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckServices {

    private final FraudCheckRepository fraudCheckRepository;

    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckRepository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                        .isFraud(false)
                                .isCreated(LocalDateTime.now())
                .build());

        return false;
    }
}
