package com.grupolainmaculada.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService service;

    @GetMapping(path = "{personaId}")
    public FraudCheckResponse isFraudster(@PathVariable Long personaId) {
        boolean fraudulentPersona = service.isFraudulentPersona(personaId);
        return new FraudCheckResponse(fraudulentPersona);
    }
}
