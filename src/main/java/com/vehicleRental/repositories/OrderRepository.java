package com.vehicleRental.repositories;


import com.vehicleRental.domain.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Long> {
}
