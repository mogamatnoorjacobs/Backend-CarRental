package com.vehicleRental.services.Impl;

import com.vehicleRental.domain.User;
import com.vehicleRental.repositories.UserRepository;
import com.vehicleRental.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fatimam on 28/10/2017.
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User read(long userID) {
        return userRepository.findOne(userID);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(long userID) {
        userRepository.delete(userID);
    }

    @Override
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
