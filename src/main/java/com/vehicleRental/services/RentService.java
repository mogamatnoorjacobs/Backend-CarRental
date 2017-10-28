package com.vehicleRental.services;

import com.vehicleRental.domain.Rent;

import java.math.BigDecimal;

public interface RentService
{
    Rent create(Long carId, String rentDate, String returnDate, BigDecimal totalPrice, int quantity);
    Rent read(long id);
    Rent update(Long rentId, Long carId, String rentDate, String returnDate, BigDecimal totalPrice, int quantity);
    void delete(long id);
    Iterable<Rent> readAll();
    Iterable<Rent> findAllById(long id);
}
