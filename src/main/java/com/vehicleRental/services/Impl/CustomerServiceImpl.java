package com.vehicleRental.services.Impl;

import com.vehicleRental.domain.Customer;
import com.vehicleRental.repositories.CustomerRepository;
import com.vehicleRental.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Noor on 28/10/2017.
 */
@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer read(long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(long id) {
        customerRepository.delete(id);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer availableEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
