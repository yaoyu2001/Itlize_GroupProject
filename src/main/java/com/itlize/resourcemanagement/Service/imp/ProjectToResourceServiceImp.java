package com.itlize.resourcemanagement.Service.imp;

import com.itlize.resourcemanagement.Service.ProjectService;
import com.itlize.resourcemanagement.Service.ProjectToResourceService;
import com.itlize.resourcemanagement.DAO.ProjectToResourceDAO;
import com.itlize.resourcemanagement.Service.ResourceService;
import com.itlize.resourcemanagement.entity.Project;
import com.itlize.resourcemanagement.entity.ProjectToResource;
import com.itlize.resourcemanagement.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectToResourceServiceImp implements ProjectToResourceService {

    @Autowired
    ProjectToResourceDAO repository;

    @Autowired
    ResourceService resourceService;

    @Qualifier ("projectServiceImp")
    @Autowired
    ProjectService projectService;

    @Override
    public ProjectToResource addResourceToProject(Project project, Resource resource) {
        ProjectToResource projectToResource = new ProjectToResource();
        projectToResource.setProject(project);
        projectToResource.setResource(resource);
        repository.save(projectToResource);
        return projectToResource;
    }

    @Override
    public List<ProjectToResource> findAll() {
        return repository.findAll();
    }

    @Override
    public ProjectToResource findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ProjectToResource updateResource(Integer projectResourceId, Integer resourceId) {
        ProjectToResource projectToResource = findById(projectResourceId);
        Resource resource = resourceService.findOneById(resourceId);
        projectToResource.setResource(resource);
        return repository.save(projectToResource);
    }

    @Override
    public void deleteProjectResource(Integer id) {
        repository.deleteById(id);
    }

}

