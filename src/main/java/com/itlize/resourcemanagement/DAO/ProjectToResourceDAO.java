package com.itlize.resourcemanagement.DAO;

import com.itlize.resourcemanagement.entity.Project;
import com.itlize.resourcemanagement.entity.ProjectToResource;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectToResourceDAO extends JpaRepository<ProjectToResource,Integer> {
//    @EntityGraph(value = "ProjectToResource.Project", type = EntityGraph.EntityGraphType.FETCH)
//    List<ProjectToResource> findAllByProjectId(Integer id);
    @Query (value = "SELECT * FROM project_resources where project_id =?", nativeQuery = true)
    public List<ProjectToResource> findByProjectId(Integer projectid);
}
