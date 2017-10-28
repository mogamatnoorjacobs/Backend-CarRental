package com.vehicleRental.services.Impl;

import com.vehicleRental.domain.Address;
import com.vehicleRental.repositories.AddressRepository;
import com.vehicleRental.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;
   // @Autowired
   // CustomerRepository customerRepository;

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address read(long id) {
        return addressRepository.findAddressById(id);
    }

    @Override
    public Address update(Address address, Long id, Long CustomerId) {

        //Customer customer =

        Address address1 = new Address.Builder()
                .postalCode(address.getPostalCode())
                .houseNumber(address.getHouseNumber())
                .complex(address.getComplex())
                .city(address.getCity())
                //.customer(customerRepository.getCustomerById)
                .province(address.getProvince())
                .street(address.getStreet())
                .build();
        // = addressRepository.findAddressById(id);



        return addressRepository.save(address);
    }

    @Override
    public void delete(long id) {
        addressRepository.delete(id);

    }

    @Override
    public Address findByCustomer(Long id) {
        return addressRepository.findAddressByCustomer(id);
    }
}
