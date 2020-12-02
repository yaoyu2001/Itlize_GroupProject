package com.itlize.resourcemanagement.DAO;

import com.itlize.resourcemanagement.entity.ProjectToResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectToResourceDAO extends JpaRepository<ProjectToResource,Integer> {
}
