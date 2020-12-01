package com.itlize.resourcemanagement.Service;

import com.itlize.resourcemanagement.entity.Project;
import com.itlize.resourcemanagement.entity.ProjectToResource;
import com.itlize.resourcemanagement.entity.Resource;

import java.util.List;

public interface ProjectToResourceService {
    public ProjectToResource addResourceToProject(Project project, Resource resource);

    public List<ProjectToResource> findAll();

    public ProjectToResource findById(Integer id);
    public ProjectToResource updateResource(Integer projectResourceId, Integer resourceId);
    public void deleteProjectResource(Integer id);
//
//    public ProjectToResource setResourceForProject(Project project, Resource resource);
//
//    public ProjectToResource deleteResourceForProject(Project project, Resource resource);

}
