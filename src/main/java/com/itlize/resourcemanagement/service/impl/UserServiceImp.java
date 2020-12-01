package com.itlize.resourcemanagement.services.Impl;

import com.itlize.resourcemanagement.DAO.UserDAO;
import com.itlize.resourcemanagement.entity.User;
import com.itlize.resourcemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findOneById(Integer Id) {
        return userDAO.findById(Id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Transactional
    public void createTwo() {

    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }
}
