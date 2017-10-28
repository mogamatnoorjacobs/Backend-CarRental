package com.vehicleRental.services;

import com.vehicleRental.domain.Address;

public interface AddressService {

    Address create(Address address);
    Address read(long id);
    Address update(Address address, Long id, Long customerId);
    void delete(long id);
    Address findByCustomer(Long id);

}
