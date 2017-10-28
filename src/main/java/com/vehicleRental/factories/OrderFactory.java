package com.vehicleRental.factories;

import com.vehicleRental.domain.Customer;
import com.vehicleRental.domain.Orders;

public class OrderFactory {

    public static Orders getOrder(String orderDate, Customer customer ) {

        Orders orders = new Orders.Builder()
                .customer(customer)
                .orderDate(orderDate)
                .build();
        return orders;
    }
}
