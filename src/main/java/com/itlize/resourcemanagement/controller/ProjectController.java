package com.itlize.resourcemanagement.controller;

import com.itlize.resourcemanagement.Service.ProjectService;
import com.itlize.resourcemanagement.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping("/projects")
    public List<Project> projectsList(){
        return service.findAll();
    }

    @GetMapping("/projects/{id}")

    public Project getProject(@PathVariable("id") Integer id){
        return service.findOneById(id);
    }

    @PostMapping("/projects")
    public Project create(@RequestParam("name") String name){
        Project project = new Project();
        project.setProject_name(name);
        return service.save(project);
    }
}

