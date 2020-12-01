package com.itlize.resourcemanagement.controller;

import com.itlize.resourcemanagement.service.ProjectService;
import com.itlize.resourcemanagement.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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
    public Project getProject( @PathVariable("id") Integer id){
        return service.findOneById(id);
    }

    @PostMapping("/projects")
    public Project create( @RequestParam("name") String name, @RequestParam("create_time") Date createTime,
                           @RequestParam("update_time") Date updateTime){
        Project project = new Project(name,createTime,updateTime);
        return service.save(project);
    }
}
