package com.itlize.resourcemanagement.controller;

import com.itlize.resourcemanagement.Service.ProjectService;
import com.itlize.resourcemanagement.entity.Project;
import com.itlize.resourcemanagement.entity.ResourceColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Qualifier ("projectServiceImp")
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

    @PutMapping("/projects/{id}")
    public Project updateProject(@PathVariable("id") Integer id, @RequestParam("name") String name){
        Project project = service.findOneById(id);
        project.setProject_name(name);
        return service.save(project);
    }

    @DeleteMapping("/projects/{id}")
    public void deleteProject(@PathVariable("id") Integer id){
        Project project = service.findOneById(id);
        service.deleteById(id);
    }

    @GetMapping("/findProjectByUserId")
    public List<Project> list(@RequestParam("user_id") Integer id) {
        return service.findALLByUserId(id);
    }

    @PostMapping("/projects/addColumn")
    public void addColumn(@RequestBody ResourceColumn resourceColumn){
        service.addColumnForProject(resourceColumn.getColumnName(),resourceColumn.getColumnValue(),
                resourceColumn.getColumnType(),resourceColumn.getResource(),resourceColumn.getProject());
    }


}