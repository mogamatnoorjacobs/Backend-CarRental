package com.vehicleRental.controller;

import com.vehicleRental.domain.Car;
import com.vehicleRental.domain.Orders;
import com.vehicleRental.domain.Rent;
import com.vehicleRental.factories.RentFactory;
import com.vehicleRental.services.Impl.CarServiceImpl;
import com.vehicleRental.services.Impl.OrderServiceImpl;
import com.vehicleRental.services.Impl.RentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/rent")
public class RentController
{
    private Rent rent;
    private Car car;
    private Orders order;

    @Autowired
    private RentServiceImpl rentService;

    @Autowired
    private CarServiceImpl carService;

    @Autowired
    private OrderServiceImpl orderService;

    @CrossOrigin
    @PostMapping(path="/{orderId}/{carId}/rentCar")
    public @ResponseBody
    Rent create( @PathVariable long orderId, @PathVariable long carId,
                 @RequestParam String rentDate, @RequestParam String returnDate,
                 @RequestParam BigDecimal totalPrice, @RequestParam int rentalDays)
    {
        car = carService.read(carId);
        order = orderService.read(orderId);

        rent = RentFactory.getRent(car, rentDate,returnDate,totalPrice,order, rentalDays );
         return rentService.create(rent);

    }

    @CrossOrigin
    @GetMapping (path="/findRentedItem")
    public @ResponseBody Rent findByCustomer (@RequestParam Long id)
    {
        return rentService.read(id);
    }

    @CrossOrigin
    @GetMapping (path="/{orderId}/{carId}/updateRent")
    public @ResponseBody Rent updateRent (@PathVariable long orderId, @PathVariable long carId,
                                          @RequestParam Long rentId,
                                          @RequestParam String rentDate, @RequestParam String returnDate,
                                          @RequestParam BigDecimal totalPrice, @RequestParam int rentalDays) {

        car = carService.read(carId);
        order = orderService.read(orderId);

        Rent rentUpdate = new Rent.Builder()
                .id(rentId)
                .rentDate(rentDate)
                .returntDate(returnDate)
                .rentalDays(rentalDays)
                .totalPrice(totalPrice)
                .build();

        return rentService.update(rentUpdate);
    }
    @CrossOrigin
    @DeleteMapping (path="/deleteRent")
    public @ResponseBody void updateRent (@RequestParam Long id) {
        rentService.delete(id);

    }

    @CrossOrigin
    @GetMapping(path ="/findAllRentedCars")
    public @ResponseBody Iterable<Rent> getAllRentedCars()
    {
        return rentService.readAll();
    }



}
