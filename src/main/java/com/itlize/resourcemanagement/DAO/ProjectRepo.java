package com.itlize.resourcemanagement.DAO;
import com.itlize.resourcemanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer>{

}
