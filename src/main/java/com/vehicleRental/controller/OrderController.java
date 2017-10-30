package com.vehicleRental.controller;

import com.vehicleRental.domain.Customer;
import com.vehicleRental.domain.Orders;
import com.vehicleRental.factories.OrderFactory;
import com.vehicleRental.services.Impl.CustomerServiceImpl;
import com.vehicleRental.services.Impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping(path = "/order")
public class OrderController {


    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    OrderServiceImpl orderService;

    private Orders orders;

    private Customer customer;

    @CrossOrigin
    @GetMapping(path="/{customerId}/addOrder")
    public @ResponseBody
    Orders create(@PathVariable long customerId, @RequestParam String orderDate)
    {
        customer = customerService.read(customerId);
        orders = OrderFactory.getOrder(orderDate,customer);
        return  orderService.create(orders);
    }
    @CrossOrigin
    @GetMapping (path="/{customerId}/findOrder")
    public @ResponseBody Orders findByCustomer (@PathVariable long customerId, @RequestParam long id)
    {
        return orderService.read(id);
    }

    @CrossOrigin
    @GetMapping (path="/{customerId}/updateOrder")
    public @ResponseBody Orders updateOrder (@PathVariable long customerId,@RequestParam long id, @RequestParam String orderDate) {


        orderService.read(id);
        Orders orderUpdate = new Orders.Builder()
                .id(id)
                .orderDate(orderDate)
                .build();

        return orderService.update(orderUpdate);
    }
    @CrossOrigin
    @GetMapping (path="/{customerId}/deleteOrder")
    public @ResponseBody void updateOrder (@RequestParam Long id) {
        orderService.delete(id);

    }
}
