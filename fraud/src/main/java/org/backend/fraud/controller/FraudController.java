package org.backend.fraud.controller;

import lombok.RequiredArgsConstructor;
import org.backend.fraud.service.FraudCheckServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/fraud")
@RequiredArgsConstructor
public class FraudController {

    private final FraudCheckServices fraudCheckServices;
    @GetMapping(path = "{customer_id}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customer_id") Integer id
    ){
        boolean isFraudster = fraudCheckServices.isFraudulentCustomer(id);
        return new FraudCheckResponse(isFraudster);
    }
}
