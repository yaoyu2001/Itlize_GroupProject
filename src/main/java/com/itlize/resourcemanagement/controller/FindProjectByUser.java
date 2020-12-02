package com.itlize.resourcemanagement.controller;

import com.itlize.resourcemanagement.Service.FindProjectByUserService;
import com.itlize.resourcemanagement.Service.ProjectService;
import com.itlize.resourcemanagement.Service.UserService;
import com.itlize.resourcemanagement.entity.Project;
import com.itlize.resourcemanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FindProjectByUser {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private FindProjectByUserService findProjectByUserService;

    @GetMapping("/findProjectByUserId")
    public List<Project> list(@RequestParam("user_id") Integer id) {
        return findProjectByUserService.findOneByUserId(id);
    }
}
