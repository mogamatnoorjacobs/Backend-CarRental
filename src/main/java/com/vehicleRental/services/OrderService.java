package com.vehicleRental.services;

import com.vehicleRental.domain.Order;

public interface OrderService {

    Order create(Order Order);
    Order read(long id);
    Order update(Order Order, Long id, Long customerId);
    void delete(long id);
    Order findByCustomer(Long id);
}
