package com.vehicleRental.services;

import com.vehicleRental.domain.Order;

public interface OrderService {

    Order create(Order order);
    Order read(long id);
    Order update(Order order);
    void delete(long id);
    //Order findByCustomer(Long id);
}
