package com.vehicleRental.repositories;

import com.vehicleRental.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Noor on 28/10/2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {


}
