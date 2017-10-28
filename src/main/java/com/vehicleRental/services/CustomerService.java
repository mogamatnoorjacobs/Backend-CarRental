package com.vehicleRental.services;

import com.vehicleRental.domain.Customer;

/**
 * Created by Noor on 28/10/2017.
 */
public interface CustomerService {
    Customer create(Customer customer);
    Customer read(long id);
    Customer update(Customer customer);
    void delete(long id);
    Customer findByName(String name);
}
