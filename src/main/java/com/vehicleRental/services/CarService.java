package com.vehicleRental.services;

import com.vehicleRental.domain.Car;
import com.vehicleRental.domain.Category;

/**
 * Created by thabomoopa on 2017/10/26.
 */
public interface CarService {
    Car create(Car car);
    Car read(long id);
    Car update(Car car);
    void delete(long id);

    //function to read all cars in the database and print to table
    Iterable<Car> readAll();

    //function to read all cars based on the category
    Iterable<Car> findAllById(Category category);
}
