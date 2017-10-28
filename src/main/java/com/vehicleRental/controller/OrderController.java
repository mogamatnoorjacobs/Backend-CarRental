package com.vehicleRental.controller;

import com.vehicleRental.domain.Order;
import com.vehicleRental.factories.OrderFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class OrderController {

//    @GetMapping(path="/addOrder")
//    public @ResponseBody
//    Order create(@RequestParam int houseNumber,
//                 @RequestParam String city, @RequestParam String province,
//                 @RequestParam int postalCode, @RequestParam String complex,
//                 @RequestParam String street) //, @RequestParam Customer customer)
//    {
//
//        Order = OrderFactory.getOrder();//,  customer);
//        return  OrderService.create(Order);
//    }
//
//    @GetMapping (path="/findOrder")
//    public @ResponseBody Order findByCustomer (@RequestParam Long id)
//    {
//        return OrderService.findByCustomer(id);
//    }
//
//
//    @GetMapping (path="/updateOrder")
//    public @ResponseBody Order updateOrder (@RequestParam Long id,
//                                                @RequestParam int houseNumber,
//                                                @RequestParam String city, @RequestParam String province,
//                                                @RequestParam int postalCode, @RequestParam String complex,
//                                                @RequestParam String street, @RequestParam Long customerId) {
//
//        // Customer customer = new Customer();
//        Order = OrderFactory.getOrder(houseNumber, city, province, postalCode,  complex, street);//,  customer);
//
//
//        return OrderService.update(Order, id, customerId);
//    }
//
//    @GetMapping (path="/deleteOrder")
//    public @ResponseBody void updateOrder (@RequestParam Long id) {
//        OrderService.delete(id);
//
//    }
}
