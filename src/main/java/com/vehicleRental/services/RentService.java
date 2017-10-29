package com.vehicleRental.services;

import com.vehicleRental.domain.Rent;

import java.math.BigDecimal;

public interface RentService
{
    Rent create(Rent rent);
    Rent read(long id);
    Rent update(Rent rent);
    void delete(long id);
    Iterable<Rent> readAll();
    Iterable<Rent> findAllById(long id);
}
