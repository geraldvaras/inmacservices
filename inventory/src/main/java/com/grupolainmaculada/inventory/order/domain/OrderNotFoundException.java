package com.grupolainmaculada.inventory.order.domain;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(String orderNumber) {
        super("The order number " + orderNumber + " was not found.");
    }
}
