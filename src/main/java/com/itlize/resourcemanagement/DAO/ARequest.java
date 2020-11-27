package com.itlize.resourcemanagement.DAO;

import com.itlize.resourcemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ARequest extends JpaRepository<User, String > {
}
