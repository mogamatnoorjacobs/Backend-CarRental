package com.vehicleRental.services.Impl;

import com.vehicleRental.domain.Car;
import com.vehicleRental.repositories.CarRepository;
import com.vehicleRental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by thabomoopa on 2017/10/26.
 */
@Component
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car read(long id) {
        return carRepository.findOne(id);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void delete(long id) {
        carRepository.delete(id);
    }

    @Override
    public Iterable<Car> readAll() {
        return carRepository.findAll();
    }

    @Override
    public Iterable<Car> findAllById(long id) {
        return carRepository.findAllById(id);
    }


}