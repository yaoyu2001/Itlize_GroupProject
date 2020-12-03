package com.itlize.resourcemanagement.Service.imp;

import com.itlize.resourcemanagement.DAO.UserDAO;
import com.itlize.resourcemanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String Username) throws UsernameNotFoundException {
        User user = userDAO.findUserByUsername(Username);

        if (user == null){
            throw new UsernameNotFoundException("User not find by the username" + Username);
        }
        else{
            return new org.springframework.security.
                    core.userdetails.User(user.getUserName(),
                    passwordEncoder.encode(user.getPassword()),
                    new ArrayList<>());
        }
    }
}
