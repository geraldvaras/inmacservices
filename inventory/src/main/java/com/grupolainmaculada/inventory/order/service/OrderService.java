package com.grupolainmaculada.inventory.order.service;

import com.grupolainmaculada.inventory.order.domain.Order;
import com.grupolainmaculada.inventory.order.domain.OrderNotFoundException;
import com.grupolainmaculada.inventory.order.domain.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order viewOrderDetails(String orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new OrderNotFoundException(orderNumber));
    }

}
