package com.vehicleRental.controller;

import com.vehicleRental.domain.Customer;
import com.vehicleRental.factories.CustomerFactory;
import com.vehicleRental.services.Impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Noor on 28/10/2017.
 */
@Controller
@RequestMapping(path = "/customer")
public class CustomerController {


    @Autowired
    private CustomerServiceImpl customerService;

    private Customer customer;


    @CrossOrigin
    //http://localhost:8080/customer/addCustomer?name=noor&surname=mo&email=thab.moopa&city=Cape+town&province=western+cape&complex=rosenvale&street=kaapzchit&houseNumber=1&postalCode=0123    @GetMapping(path = "/addCustomer")
    public
    @ResponseBody
    Customer addCustomer(@RequestParam String name, @RequestParam String surname, @RequestParam String email,
                         @RequestParam String city, @RequestParam String province, @RequestParam String complex,
                         @RequestParam String street, @RequestParam int houseNumber, @RequestParam int postalCode)
                         {
        Map<String, String> stringValues = new HashMap<String, String>();
        Map<String, Integer> intValues = new HashMap<String, Integer>();
        stringValues.put("name", name);
        stringValues.put("surname", surname);
        stringValues.put("email", email);
        stringValues.put("city", city);
        stringValues.put("province", province);
        stringValues.put("complex", complex);
        stringValues.put("street", street);
        intValues.put("houseNumber", houseNumber);
        intValues.put("postalCode", postalCode);

        customer = CustomerFactory.getCustomer(stringValues, intValues);

        return customerService.create(customer);
    }

    @CrossOrigin
    //http://localhost:8080/customer/findCustomerByID?customerID=1
    @GetMapping(path = "/findCustomerByID")
    public
    @ResponseBody
    Customer findCustomerByID(long customerID) {
        return  customer = customerService.read(customerID);
    }

    @CrossOrigin
    @GetMapping(path = "/updateCustomer")
    public
    @ResponseBody
    Customer updateCustomer(@RequestParam long id, @RequestParam String name, @RequestParam String surname, @RequestParam String email,
                            @RequestParam String city, @RequestParam String province, @RequestParam String complex,
                            @RequestParam String street, @RequestParam int houseNumber, @RequestParam int postalCode) {


        customerService.read(id);
        Customer customerUpdate = new Customer.Builder()
                .id(id)
                .name(name)
                .surname(surname)
                .email(email)
                .city(city)
                .province(province)
                .complex(complex)
                .street(street)
                .houseNumber(houseNumber)
                .postalCode(postalCode)
                .build();

        return customerService.update(customerUpdate);
    }

    @CrossOrigin
    @GetMapping(path = "/deleteCustomer")
    public
    @ResponseBody
    void deleteCustomer(long customerID) {
        customerService.delete(customerID);
    }

    @CrossOrigin
    @GetMapping(path = "/findAll")
    public @ResponseBody Iterable<Customer> getAllCustomers()
    {
        return customerService.findAll();
    }


}
