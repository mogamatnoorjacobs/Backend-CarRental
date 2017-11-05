package com.vehicleRental.services;

import com.vehicleRental.domain.User;

/**
 * Created by Noor on 28/10/2017.
 */
public interface UserService {

    User create(User user);
    User read(long id);
    User update(User user);
    void delete(long id);
    Iterable<User> findAllUsers();
    User findByName(String name);
}
