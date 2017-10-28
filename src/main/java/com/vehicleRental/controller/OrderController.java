package com.vehicleRental.controller;

import com.vehicleRental.domain.Customer;
import com.vehicleRental.domain.Order;
import com.vehicleRental.factories.OrderFactory;
import com.vehicleRental.services.Impl.CustomerServiceImpl;
import com.vehicleRental.services.Impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class OrderController {



    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    OrderServiceImpl orderService;

    private Order order;

    private Customer customer;

    @GetMapping(path="/{customerId}/addOrder")
    public @ResponseBody
    Order create(@PathVariable long customerId, @RequestParam String orderDate)
    {
        customer = customerService.read(customerId);
        order = OrderFactory.getOrder(orderDate,customer);//,  customer);
        return  orderService.create(order);
    }

    @GetMapping (path="/{customerId}/findOrder")
    public @ResponseBody Order findByCustomer (@PathVariable long customerId, @RequestParam Long id)
    {
        return orderService.read(id);
    }


    @GetMapping (path="/{customerId}/updateOrder")
    public @ResponseBody Order updateOrder (@PathVariable long customerId,@RequestParam long id, @RequestParam String orderDate) {


        orderService.read(id);
        Order orderUpdate = new Order.Builder()
                .id(id)
                .orderDate(orderDate)
                .build();

        return orderService.update(orderUpdate);
    }

    @GetMapping (path="/{customerId}/deleteOrder")
    public @ResponseBody void updateOrder (@RequestParam Long id) {
        orderService.delete(id);

    }
}
