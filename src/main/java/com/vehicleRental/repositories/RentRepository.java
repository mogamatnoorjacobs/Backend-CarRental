package com.vehicleRental.repositories;

import com.vehicleRental.domain.Rent;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<Rent, Long>
{
    Iterable<Rent> findAllById(long id);

}
