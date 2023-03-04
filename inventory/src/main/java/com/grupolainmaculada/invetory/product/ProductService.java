package com.grupolainmaculada.invetory.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public void registerProduct(ProductRegistrationRequest productRegistrationRequest) {
        Product product = Product.builder()
                .description(productRegistrationRequest.description())
                .unitPrice(new BigDecimal(productRegistrationRequest.unitPrice()))
                .build();
        productRepository.save(product);
    }
}
