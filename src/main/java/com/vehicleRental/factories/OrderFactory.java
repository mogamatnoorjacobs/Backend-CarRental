package com.vehicleRental.factories;

import com.vehicleRental.domain.Customer;
import com.vehicleRental.domain.Order;

public class OrderFactory {

    public static Order getOrder( String orderDate, Customer customer ) {

        Order order = new Order.Builder()
                .customer(customer)
                .orderDate(orderDate)
                .build();
        return order;
    }
}
