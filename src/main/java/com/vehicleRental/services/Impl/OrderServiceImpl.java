package com.vehicleRental.services.Impl;

import com.vehicleRental.domain.Orders;
import com.vehicleRental.repositories.OrderRepository;
import com.vehicleRental.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Orders create(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public Orders read(long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Orders update(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public void delete(long id) {
        orderRepository.delete(id);
    }

//    @Override
//    public Orders findByCustomer(long id) {
//        return null;
//    }
}
