package com.grupolainmaculada.inventory.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;
    public void registerProduct(ProductRegistrationRequest productRegistrationRequest) {
        Product product = Product.builder()
                .description(productRegistrationRequest.description())
                .unitPrice(new BigDecimal(productRegistrationRequest.unitPrice()))
                .build();
        // todo: check is fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{personaId}",
                FraudCheckResponse.class, 1L);
        if(fraudCheckResponse.isFraudster()) {
            throw  new IllegalStateException("fraudster");
        }
        productRepository.save(product);
        // todo: send notification
    }
}
