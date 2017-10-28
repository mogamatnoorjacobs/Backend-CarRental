package com.vehicleRental.factories;

import com.vehicleRental.domain.Order;

public class OrderFactory {

    public static Order getOrder( String orderDate ) {

        Order order = new Order.Builder()
                .orderDate(orderDate)
                .build();

        return order;
    }
}
