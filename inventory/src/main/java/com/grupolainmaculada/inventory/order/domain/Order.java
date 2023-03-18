package com.grupolainmaculada.inventory.order.domain;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record Order(
        @NotBlank
        String orderNumber,
        LocalDateTime issueDate) {
}
