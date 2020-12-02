package com.itlize.resourcemanagement.DAO;

import com.itlize.resourcemanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FindProjectByUserId extends JpaRepository<Project, Integer> {

    @Query (value = "SELECT * FROM project WHERE user_id=?", nativeQuery = true)
    public List<Project> findOneByUserId(Integer userID);

}