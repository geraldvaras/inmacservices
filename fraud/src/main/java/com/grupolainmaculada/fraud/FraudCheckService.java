package com.grupolainmaculada.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository repository;

    public boolean isFraudulentPersona(Long personaId) {
        repository.save(
                FraudCheckHistory.builder()
                        .isFraudster(false)
                        .customerId(personaId)
                        .createdAt(Instant.now())
                        .build());
        return false;
    }
}
