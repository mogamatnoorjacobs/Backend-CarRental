package com.vehicleRental.repositories;

import com.vehicleRental.domain.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by thabomoopa on 2017/10/26.
 */
public interface CarRepository extends CrudRepository<Car, Long>{
    Iterable<Car> findAllById(long id);
}
