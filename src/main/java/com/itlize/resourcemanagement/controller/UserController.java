package com.itlize.resourcemanagement.controller;

import com.itlize.resourcemanagement.Service.imp.MyUserDetailsService;
import com.itlize.resourcemanagement.entity.AuthenticationResponse;

import com.itlize.resourcemanagement.entity.User;
import com.itlize.resourcemanagement.Service.UserService;
import com.itlize.resourcemanagement.util.JwtUtil;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Qualifier ("userServiceImp")
    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<User> list() {
        return service.findAll();
    }

    @PostMapping("/register")
    public User create(@RequestBody User testuser) {
       if (service.findUserByUsername(testuser.getUserName()) != null){
           return null;
       }
        return service.save(testuser);
    }

    @PostMapping("/UpdateUser")
    public User update(@RequestBody User user){
        return service.save(user);
    }


    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Integer id) {return service.findOneById(id);}

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User TestUser) throws Exception {
        User user = service.findUserByUsername(TestUser.getUserName());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(TestUser.getUserName(), TestUser.getPassword())
            );

        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(TestUser.getUserName());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        JSONObject result = new JSONObject();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        result.put("jwt",jwt);
        result.put("time", dateFormat.format(user.getCreate_time()));
        result.put("Name",user.getUserName());
        result.put("userId", user.getUserId());

        return ResponseEntity.ok().body(result);
    }
}
