package com.itlize.resourcemanagement.controller;

import com.itlize.resourcemanagement.entity.Role;
import com.itlize.resourcemanagement.entity.User;
import com.itlize.resourcemanagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/Users")
    public List<User> list() {
        return service.findAll();
    }

    @PostMapping("/Newuser")
    public User create(@RequestParam("username") String username,
                       @RequestParam("Password") String password,
                       @RequestParam("Role") Role role,
                       @RequestParam("Email") String email,
                       @RequestParam("First Name") String Fname,
                       @RequestParam("Last Name") String Lname) {
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setRole(role);
        user.setEmail(email);
        user.setFirst_name(Fname);
        user.setLast_name(Lname);

        return service.save(user);
    }
    @GetMapping("/User/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return service.findOneById(id);
    }
}