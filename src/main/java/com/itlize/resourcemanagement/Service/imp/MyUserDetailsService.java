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
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userDAO.findById(Integer.parseInt(s));

        if (user == null){
            throw new UsernameNotFoundException("User not find by the username" + s);
        }
        else{
            return new org.springframework.security.
                    core.userdetails.User(user.get().getUserName(),
                    passwordEncoder.encode(user.get().getPassword()),
                    new ArrayList<>());
        }
    }
}
