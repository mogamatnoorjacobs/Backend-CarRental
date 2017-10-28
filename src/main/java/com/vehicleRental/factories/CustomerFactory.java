package com.vehicleRental.factories;

import com.vehicleRental.domain.Customer;

/**
 * Created by Noor on 27/10/2017.
 */
public class CustomerFactory
{
    public static Customer getCustomer(String name, String surname, String email, long addressID)
    {
        Customer customer = new Customer.Builder()
                .name(name)
                .surname(surname)
                .email(email)
                .addressID(addressID)
                .build();
        return customer;
    }

}
