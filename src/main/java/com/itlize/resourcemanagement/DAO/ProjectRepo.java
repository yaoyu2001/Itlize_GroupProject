package com.itlize.resourcemanagement.DAO;
import com.itlize.resourcemanagement.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Projects, Integer>{

}
