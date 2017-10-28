package com.vehicleRental.controller;

import com.vehicleRental.domain.Customer;
import com.vehicleRental.factories.CustomerFactory;
import com.vehicleRental.services.Impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Noor on 28/10/2017.
 */
@Controller
@RequestMapping(path = "/customer")
public class CustomerController {@Autowired
private CustomerServiceImpl customerService;
    private Customer customer;

    //  http://localhost:8080/customer/addCustomer?name=noor&surname=mo&email=thab.moopa&addressID=1
    @GetMapping(path = "/addCustomer")
    public
    @ResponseBody
    String addCustomer(@RequestParam String name, @RequestParam String surname, @RequestParam String email, @RequestParam long addressID) {
        customer = CustomerFactory.getCustomer(name, surname, email, addressID);
        customerService.create(customer);
        return "Saved";
    }

    @GetMapping(path = "/findCustomerByName/{name}")
    public
    @ResponseBody
    Customer findCustomerByName(@PathVariable String name) {

        customer = customerService.findByName(name);

        return customer;
    }
    //http://localhost:8080/customer/findCustomerByID?customerID=1
    @GetMapping(path = "/findCustomerByID")
    public
    @ResponseBody
    Customer findCustomerByID(long customerID) {
        //   long custId=Long.pargseLong(customerID);
        customer = customerService.read(customerID);

        return customer;
    }

    @GetMapping(path = "/updateCustomer")
    public
    @ResponseBody
    String updateCustomer(String name, String surname, String email, long addressID) {
        Customer customer = CustomerFactory.getCustomer(name, surname, email, addressID);
        customerService.create(customer);
        return "Saved";
    }


    @GetMapping(path = "/deleteCustomer")
    public
    @ResponseBody
    String deleteCustomer( long  customerID) {

        customerService.delete(customerID);

        return "Customer deleted";
    }




}
