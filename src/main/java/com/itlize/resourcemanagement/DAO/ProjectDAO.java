package com.itlize.resourcemanagement.DAO;
import com.itlize.resourcemanagement.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDAO extends JpaRepository<Projects, Integer>{

}
