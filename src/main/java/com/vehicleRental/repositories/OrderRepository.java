package com.vehicleRental.repositories;

import com.vehicleRental.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
