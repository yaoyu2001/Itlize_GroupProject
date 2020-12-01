package com.itlize.resourcemanagement.controller;

import com.itlize.resourcemanagement.Service.imp.MyUserDetailsService;
import com.itlize.resourcemanagement.entity.AuthenticationResponse;
import com.itlize.resourcemanagement.entity.Role;
import com.itlize.resourcemanagement.entity.User;
import com.itlize.resourcemanagement.Service.UserService;
import com.itlize.resourcemanagement.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

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

    @PostMapping("/UpdateUser")
    public User update(@RequestParam("username") String username,
                       @RequestParam("Password") String password,
                       @RequestParam("Role") Role role,
                       @RequestParam("Email") String email,
                       @RequestParam("First Name") String Fname,
                       @RequestParam("Last Name") String Lname){
        User user = service.findUserByUserName(username);
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

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(user.getUserName());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}