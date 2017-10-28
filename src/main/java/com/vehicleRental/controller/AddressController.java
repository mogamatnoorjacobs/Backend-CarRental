package com.vehicleRental.controller;


import com.vehicleRental.domain.Address;
import com.vehicleRental.factories.AddressFactory;
import com.vehicleRental.services.Impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/customer")
public class AddressController {

    private Address address;

    @Autowired
    private AddressServiceImpl addressService;

    @GetMapping(path="/addAddress")
    public @ResponseBody
    Address create(@RequestParam int houseNumber,
                   @RequestParam String city, @RequestParam String province,
                   @RequestParam int postalCode, @RequestParam String complex,
                   @RequestParam String street) //, @RequestParam Customer customer)
    {
        address = AddressFactory.getAddress(houseNumber, city, province, postalCode,  complex, street);//,  customer);
        return  addressService.create(address);
    }

    @GetMapping (path="/findAddress")
    public @ResponseBody Address findByCustomer (@RequestParam Long id)
    {
        return addressService.findByCustomer(id);
    }


    @GetMapping (path="/updateAddress")
    public @ResponseBody Address updateAddress (@RequestParam Long id,
                                                @RequestParam int houseNumber,
                                                @RequestParam String city, @RequestParam String province,
                                                @RequestParam int postalCode, @RequestParam String complex,
                                                @RequestParam String street, @RequestParam Long customerId) {

       // Customer customer = new Customer();
        address = AddressFactory.getAddress(houseNumber, city, province, postalCode,  complex, street);//,  customer);


        return addressService.update(address, id, customerId);
    }

    @GetMapping (path="/deleteAddress")
    public @ResponseBody void updateAddress (@RequestParam Long id) {
        addressService.delete(id);

    }



}
