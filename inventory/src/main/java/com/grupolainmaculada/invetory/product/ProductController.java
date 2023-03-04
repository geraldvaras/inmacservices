package com.grupolainmaculada.invetory.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void getProductoByCode(@RequestBody ProductRegistrationRequest productRegistrationRequest) {
        log.info("new product query", productRegistrationRequest);
        productService.registerProduct(productRegistrationRequest);
    }
}
