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
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order read(long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(long id) {
        orderRepository.delete(id);
    }

//    @Override
//    public Order findByCustomer(long id) {
//        return null;
//    }
}
