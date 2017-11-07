package com.vehicleRental.factories;

import com.vehicleRental.domain.Customer;
import com.vehicleRental.domain.Invoices;

import java.util.List;
import java.util.Map;

/**
 * Created by Noor on 27/10/2017.
 */
public class CustomerFactory
{
    public static Customer getCustomer(Map<String, String> stringValues, Map<String,Integer> intValues)
    {
        Customer customer = new Customer.Builder()
                .name(stringValues.get("name"))
                .surname(stringValues.get("surname"))
                .email(stringValues.get("email"))
                .city(stringValues.get("city"))
                .province(stringValues.get("province"))
                .complex(stringValues.get("complex"))
                .street(stringValues.get("street"))
                .houseNumber(intValues.get("houseNumber"))
                .postalCode(intValues.get("postalCode"))
                //.invoices(invoices)
                .build();
        return customer;
    }

}
