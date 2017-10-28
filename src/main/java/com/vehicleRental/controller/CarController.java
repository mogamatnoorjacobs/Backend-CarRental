package com.vehicleRental.controller;

import com.vehicleRental.domain.Car;
import com.vehicleRental.domain.Category;
import com.vehicleRental.factories.CarFactory;
import com.vehicleRental.services.Impl.CarServiceImpl;
import com.vehicleRental.services.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by thabomoopa on 2017/10/26.
 */

@Controller
@RequestMapping(path = "/car")
public class CarController {

    private Car car;
    private Category category;

    @Autowired
    private CarServiceImpl carService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @CrossOrigin
    @GetMapping(path = "/{categoryId}/addCar")
    public @ResponseBody Car create(@PathVariable long categoryId, @RequestParam String make, @RequestParam String model, @RequestParam int year, @RequestParam int quantity)
    {
        Map<String, String> stringValues = new HashMap<String, String>();
        Map<String, Integer> intValues = new HashMap<String, Integer>();
        stringValues.put("make", make);
        stringValues.put("model", model);
        intValues.put("year", year);
        intValues.put("quantity", quantity);

        category = categoryService.read(categoryId);

        car = CarFactory.getCar(category, stringValues, intValues);

        return carService.create(car);
    }
    @CrossOrigin
    @GetMapping(path = "/readCar")
    public @ResponseBody Car read(@RequestParam long id)
    {
        return carService.read(id);
    }

    @CrossOrigin
    //function to edit the car according to the transaction
    @GetMapping(path = "/updateCar")
    public @ResponseBody Car update(@RequestParam long id, @RequestParam String make, @RequestParam String model, @RequestParam int year, @RequestParam int quantity)
    {

        //category = categoryService.read(categoryId);
        carService.read(id);
        Car carUpdate = new Car.Builder()
                .id(id)
               .make(make)
               .model(model)
               .year(year)
               .quantity(quantity)
               .build();

        return carService.update(carUpdate);
    }

    @CrossOrigin
    @GetMapping (path = "/deleteCar")
    public @ResponseBody void delete(@RequestParam long id)
    {
        carService.delete(id);
    }

    @CrossOrigin
    //function to read all cars in the database and print to table
    @GetMapping(path = "/readAllCars")
    public @ResponseBody Iterable<Car> getAllCar()
    {
        return carService.readAll();
    }

}
