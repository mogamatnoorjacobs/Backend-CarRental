package com.vehicleRental.repositories;

import com.vehicleRental.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
    Address findAddressById(Long id);
    Address findAddressByCustomer(Long id);

}
