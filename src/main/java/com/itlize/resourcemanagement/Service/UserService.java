package com.itlize.resourcemanagement.Service;

import com.itlize.resourcemanagement.entity.User;

import java.util.List;

public interface UserService {
    public User findOneById(Integer Id);

    List<User> findAll();

    public User findUserByUserName(String name);

    public User save(User user);

}
