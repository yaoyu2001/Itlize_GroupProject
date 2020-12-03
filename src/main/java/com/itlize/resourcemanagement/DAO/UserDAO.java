package com.itlize.resourcemanagement.DAO;

import com.itlize.resourcemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User,Integer> {
    User findUserByUsername(String name);
}
