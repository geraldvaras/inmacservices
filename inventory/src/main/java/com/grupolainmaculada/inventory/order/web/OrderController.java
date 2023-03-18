package com.grupolainmaculada.inventory.order.web;

import com.grupolainmaculada.inventory.order.domain.Order;
import com.grupolainmaculada.inventory.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Order getByOrderNumber(@PathVariable String orderNumber) {
        return this.orderService.viewOrderDetails(orderNumber);
    }
}
