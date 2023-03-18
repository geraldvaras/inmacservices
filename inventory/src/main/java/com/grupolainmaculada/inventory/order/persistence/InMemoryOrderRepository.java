package com.grupolainmaculada.inventory.order.persistence;

import com.grupolainmaculada.inventory.order.domain.Order;
import com.grupolainmaculada.inventory.order.domain.OrderRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

    public static final Map<String, Order> orders = new ConcurrentHashMap<>();

    public InMemoryOrderRepository() {
        Order o = new Order("001234", LocalDateTime.now());
        orders.put(o.orderNumber(), o);
    }

    @Override
    public Optional<Order> findByOrderNumber(String orderNumber) {
        return existsByOrderNumber(orderNumber)
                ? Optional.of(orders.get(orderNumber))
                : Optional.empty();
    }

    @Override
    public Boolean existsByOrderNumber(String orderNumber) {
        return orders.get(orderNumber) != null;
    }
}
