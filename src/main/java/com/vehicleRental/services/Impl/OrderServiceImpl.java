package com.vehicleRental.services.Impl;

import com.vehicleRental.domain.Order;
import com.vehicleRental.repositories.OrderRepository;
import com.vehicleRental.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order create(Order Order) {
        return null;
    }

    @Override
    public Order read(long id) {
        return null;
    }

    @Override
    public Order update(Order Order, Long id, Long customerId) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Order findByCustomer(Long id) {
        return null;
    }
}
