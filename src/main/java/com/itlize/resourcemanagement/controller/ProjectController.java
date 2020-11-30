package com.itlize.resourcemanagement.controller;

import com.itlize.resourcemanagement.Service.ProjectService;
import com.itlize.resourcemanagement.entity.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping("/projects")
    public List<Projects> projectsList(){
        return service.findAll();
    }

    @GetMapping("/projects/{id}")
    public Projects getProject(@PathVariable("id") Integer id){
        return service.findOneById(id);
    }

    @PostMapping("/projects")
    public Projects create(@RequestParam("name") String name, @RequestParam("create_time") Date createTime,
                           @RequestParam("update_time") Date updateTime){
        Projects project = new Projects(name,createTime,updateTime);
        return service.save(project);
    }
}
