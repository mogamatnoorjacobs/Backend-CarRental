package com.vehicleRental.factories;

import com.vehicleRental.domain.Car;
import com.vehicleRental.domain.Category;

import java.util.Map;

/**
 * Created by thabomoopa on 2017/10/26.
 */
public class CarFactory {
    public static Car getCar(Category category, Map<String, String> stringValues, Map<String, Integer> intValues)
    {
        Car car = new Car.Builder()
//                .make(make)
//                .model(model)
//                .quantity(quantity)
//                .year(year)
//                .category(category)
//                .build();
                .make(stringValues.get("make"))
                .model(stringValues.get("model"))
                .quantity(intValues.get("quantity"))
                .year(intValues.get("year"))
                .category(category)
                .build();
        return car;
    }
}
