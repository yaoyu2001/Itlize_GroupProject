package com.itlize.resourcemanagement.controller;

import com.itlize.resourcemanagement.entity.Role;
import com.itlize.resourcemanagement.entity.User;
import com.itlize.resourcemanagement.services.UserService;
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
                       @RequestParam("Last Name") String Lname,
                       @RequestParam("Create_time") Date Ctime,
                       @RequestParam("Update_time") Date UTime) {
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setRole(role);
        user.setEmail(email);
        user.setFirst_name(Fname);
        user.setLast_name(Lname);
        user.setCreate_time(Ctime);
        user.setUpdate_time(UTime);
        return service.save(user);
    }
    @GetMapping("/Users/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return service.findOneById(id);
    }

}
