package com.vehicleRental.services;

import com.vehicleRental.domain.Car;

/**
 * Created by thabomoopa on 2017/10/26.
 */
public interface CarService {
    Car create(Car car);
    Car read(long id);
    Car update(Car car);
    void delete(long id);
    Iterable<Car> readAll();
    Iterable<Car> findAllById(long id);
}
