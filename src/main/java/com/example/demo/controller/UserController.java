package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<User> getUser(@PathVariable int id) {
        return this.userService.getUserById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllUsers() {
        this.userService.deleteAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUserById(id);
    }

}
