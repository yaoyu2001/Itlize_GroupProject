package com.itlize.resourcemanagement.Service;

import com.itlize.resourcemanagement.entity.User;

import java.util.List;

public interface UserService {
    public User findOneById(Integer Id);

    List<User> findAll();

    public User findUserByUsername(String name);

    public User save(User user);

    public void deleteById(Integer Id);

    public User getUserByCredentials(String username, String Password);

}
