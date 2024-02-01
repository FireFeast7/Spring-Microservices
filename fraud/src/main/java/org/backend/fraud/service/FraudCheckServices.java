package org.backend.fraud.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.backend.fraud.entity.FraudCheckHistory;
import org.backend.fraud.repository.FraudCheckRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
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
        log.info("Fraud Check Request for customer "+customerId);
        return false;
    }
}
