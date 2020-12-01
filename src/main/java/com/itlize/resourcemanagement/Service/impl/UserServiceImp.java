package com.itlize.resourcemanagement.Service.impl;

import com.itlize.resourcemanagement.DAO.UserDAO;
import com.itlize.resourcemanagement.entity.User;
import com.itlize.resourcemanagement.Service.UserService;
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

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    public void deleteById(Integer Id){
        userDAO.deleteById(Id);
    }

    public User findUserByUserName(String name){return userDAO.findUserByUserName(name);}
}
