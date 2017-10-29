package com.vehicleRental.services.Impl;

import com.vehicleRental.domain.Car;
import com.vehicleRental.domain.Rent;
import com.vehicleRental.factories.RentFactory;
import com.vehicleRental.repositories.CarRepository;
import com.vehicleRental.repositories.RentRepository;
import com.vehicleRental.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class RentServiceImpl implements RentService
{
    @Autowired
    private RentRepository rentRepository;


    @Override
    public Rent create(Rent rent) {

        return rentRepository.save(rent);
    }

    @Override
    public Rent read(long id) {
        return rentRepository.findOne(id);
    }

    @Override
    public Rent update(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public void delete(long id) {
        rentRepository.delete(id);
    }

    @Override
    public Iterable<Rent> readAll() {
        return rentRepository.findAll();
    }

    @Override
    public Iterable<Rent> findAllById(long id) {
        return rentRepository.findAllById(id);
    }
}
