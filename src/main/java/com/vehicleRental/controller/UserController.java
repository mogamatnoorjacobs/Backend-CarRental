package com.vehicleRental.controller;

import com.vehicleRental.domain.User;
import com.vehicleRental.factories.UserFactory;
import com.vehicleRental.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fatimam on 28/10/2017.
 */
@Controller
@RequestMapping(path = "/user")
public class UserController
{
    private User user;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(path="/addUser")
    public @ResponseBody
    User addUser(@RequestParam String name, @RequestParam String surname,@RequestParam String password,@RequestParam String role)
    {
        user = UserFactory.getUser(name,surname,password,role);
        return  userService.create(user);
}

    @GetMapping (path="/findByUserID")
    public @ResponseBody User findByUserID(@RequestParam long userID)
    {
        return userService.read(userID);
    }

    @GetMapping (path = "/findAllUsers")
    public @ResponseBody Iterable<User> findAllUsers()
    {
        return userService.findAllUsers();
    }


    @GetMapping(path="/updateUser")
    public @ResponseBody
    User updateUser(@RequestParam long userID,@RequestParam String name, @RequestParam String surname,@RequestParam String password,@RequestParam String role)
    {

        User userUpdate=UserFactory.getUserByID(userID,name,surname,password,role);

        return  userService.update(userUpdate);
    }

    @GetMapping (path = "/deleteUser")
    public @ResponseBody void delete(@RequestParam long userID)
    {
        userService.delete(userID);
    }


}
