package com.vehicleRental.repositories;

import com.vehicleRental.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Noor on 27/10/2017.
 */
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Customer findByName(String name);
}
