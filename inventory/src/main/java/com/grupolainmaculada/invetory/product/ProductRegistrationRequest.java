package com.grupolainmaculada.invetory.product;

public record ProductRegistrationRequest(
        String description,
        String unitPrice
) {
}
