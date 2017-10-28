package com.vehicleRental.controller;

import com.vehicleRental.domain.Address;
import com.vehicleRental.domain.Customer;
import com.vehicleRental.factories.CustomerFactory;
import com.vehicleRental.services.Impl.AddressServiceImpl;
import com.vehicleRental.services.Impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Noor on 28/10/2017.
 */
@Controller
@RequestMapping(path = "/customer")
public class CustomerController {


    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private AddressServiceImpl addressService;

    private Customer customer;

    private Address address;

    //  http://localhost:8080/customer/addCustomer?name=noor&surname=mo&email=thab.moopa&addressID=1
    @GetMapping(path = "{addressId}/addCustomer")
    public
    @ResponseBody
    Customer addCustomer(@RequestParam String name, @RequestParam String surname, @RequestParam String email, @PathVariable long addressId) {

        address = addressService.read(addressId);
        customer = CustomerFactory.getCustomer(name, surname, email, address);

        return customerService.create(customer);
    }

    //http://localhost:8080/customer/findCustomerByID?customerID=1
    @GetMapping(path = "/findCustomerByID")
    public
    @ResponseBody
    Customer findCustomerByID(long customerID) {
        return  customer = customerService.read(customerID);
    }

    @GetMapping(path = "/updateCustomer")
    public
    @ResponseBody
    Customer updateCustomer(String name, String surname, String email, Address address) {


        customer = CustomerFactory.getCustomer(name, surname, email, address);

        return customerService.create(customer);
    }


    @GetMapping(path = "/deleteCustomer")
    public
    @ResponseBody
    void deleteCustomer(long customerID) {

        customerService.delete(customerID);
    }




}
