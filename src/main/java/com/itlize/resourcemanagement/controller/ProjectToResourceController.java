package com.itlize.resourcemanagement.controller;

import com.itlize.resourcemanagement.Service.ProjectService;
import com.itlize.resourcemanagement.Service.ProjectToResourceService;
import com.itlize.resourcemanagement.Service.ResourceService;
import com.itlize.resourcemanagement.entity.Project;
import com.itlize.resourcemanagement.entity.ProjectToResource;
import com.itlize.resourcemanagement.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectToResourceController {
    @Autowired
    ProjectToResourceService projectToResourceService;
    @Autowired
    ProjectService projectService;
    @Autowired
    ResourceService resourceService;

    @GetMapping("/project/resources")
    public List<ProjectToResource> findAll(){
        return projectToResourceService.findAll();
    }

    @GetMapping("/project/resources/{id}")
    public ProjectToResource findById(@PathVariable("id") Integer id){
        return projectToResourceService.findById(id);
    }

    @PostMapping("/project/resources/{projectId}/{resourceId}")
    public ProjectToResource addResource(@PathVariable("projectId") Integer projectId,
                                         @PathVariable("resourceId")Integer resourceId){
        Project project = projectService.findOneById(projectId);
        Resource resource = resourceService.findOneById(resourceId);
        if(project == null || resource == null) return null;
        return projectToResourceService.addResourceToProject(project, resource);
    }

    //To update resource for a project
    @PostMapping("/project/updateresource/{projectResourceId}/{resourceId}")
    public ProjectToResource updateResource(@PathVariable("projectResourceId")Integer projectResourceId,
                                            @PathVariable("resourceId")Integer resourceId){
        return projectToResourceService.updateResource(projectResourceId,resourceId);
    }

    //Delete Resource for a project
    @DeleteMapping("/project/deleteresource/{id}")
    public void DeleteProjectResource(@PathVariable("id") Integer id){
        projectToResourceService.deleteProjectResource(id);
    }

}
