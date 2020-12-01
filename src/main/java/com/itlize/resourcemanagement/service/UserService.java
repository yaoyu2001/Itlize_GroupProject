package com.itlize.resourcemanagement.service;

import com.itlize.resourcemanagement.entity.User;

import java.util.List;

public interface UserService {
    public User findOneById(Integer Id);

    List<User> findAll();

    public void createTwo();

    public User save(User user);
}
