package com.grupolainmaculada.inventory.order.domain;

import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findByOrderNumber(String orderNumber);
    Boolean existsByOrderNumber(String orderNumber);
}
