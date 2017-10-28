package com.vehicleRental.controller;

import com.vehicleRental.domain.Car;
import com.vehicleRental.domain.Rent;
import com.vehicleRental.factories.RentFactory;
import com.vehicleRental.services.Impl.CarServiceImpl;
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

    @Autowired
    private RentServiceImpl rentService;

    @Autowired
    private CarServiceImpl carService;

    @GetMapping(path="/{carId}/rentCar")
    public @ResponseBody
    Rent create( @PathVariable Long carId, @RequestParam String rentDate, @RequestParam String returnDate,
                 @RequestParam BigDecimal totalPrice, @RequestParam int quantity)
    {

         return rentService.create( carId, rentDate,  returnDate,  totalPrice,
                quantity);

    }

    @GetMapping (path="/findRentedItem")
    public @ResponseBody Rent findByCustomer (@RequestParam Long id)
    {
        return rentService.read(id);
    }


    @GetMapping (path="/updateRent")
    public @ResponseBody Rent updateRent (@RequestParam Long rentId, @RequestParam Long carId, @RequestParam String rentDate, @RequestParam String returnDate,
                                          @RequestParam BigDecimal totalPrice, @RequestParam int quantity) {

        return rentService.update( rentId, carId, rentDate,  returnDate,  totalPrice,
                quantity);
    }

    @GetMapping (path="/deleteRent")
    public @ResponseBody void updateRent (@RequestParam Long id) {
        rentService.delete(id);

    }



}
