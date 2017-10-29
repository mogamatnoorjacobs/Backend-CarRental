package com.vehicleRental.factories;

import com.vehicleRental.domain.Car;
import com.vehicleRental.domain.Category;

import java.util.Map;

/**
 * Created by thabomoopa on 2017/10/26.
 */
public class CarFactory {
    public static Car getCar(Category category, Map<String, String> stringValues, int year, boolean status)
    {
        Car car = new Car.Builder()
                .make(stringValues.get("make"))
                .model(stringValues.get("model"))
                .numberPlate(stringValues.get("numberPlate"))
                .status(status)
                .year(year)
                .category(category)
                .build();
        return car;
    }
}
