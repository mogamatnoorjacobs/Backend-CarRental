package com.vehicleRental.factories;

import com.vehicleRental.domain.Car;
import com.vehicleRental.domain.Rent;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class RentFactory
{
    public static Rent getRent(Car car,String rentDate, String returnDate, BigDecimal totalPrice,
                               int quantity)
    {
        Rent rent = new Rent.Builder()
                .car(car)
                .rentDate(rentDate)
                .returntDate(returnDate)
                .totalPrice(totalPrice)
                .quantity(quantity)
                .build();
        return  rent;
    }
}
