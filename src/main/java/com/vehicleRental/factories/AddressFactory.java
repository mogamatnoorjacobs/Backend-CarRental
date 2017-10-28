package com.vehicleRental.factories;

import com.vehicleRental.domain.Address;

public class AddressFactory {

    public static Address getAddress(int houseNumber,
                                     String city, String province,
                                     int postalCode, String complex,
                                     String street) {

        Address address = new Address.Builder()
                .postalCode(postalCode)
                .houseNumber(houseNumber)
                .complex(complex)
                .city(city)
                //.customer(customer)
                .province(province)
                .street(street)
                .build();

        return address;
    }
}
