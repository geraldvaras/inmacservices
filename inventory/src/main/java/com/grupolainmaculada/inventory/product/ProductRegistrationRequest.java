package com.grupolainmaculada.inventory.product;

public record ProductRegistrationRequest(
        String description,
        String unitPrice
) {
}
