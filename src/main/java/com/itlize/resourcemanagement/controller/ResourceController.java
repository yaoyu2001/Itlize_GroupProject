package com.itlize.resourcemanagement.controller;

import com.itlize.resourcemanagement.entity.Resource;
import com.itlize.resourcemanagement.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yang shu
 * 2018-03-11 21:35
 */
@RestController
public class ResourceController {



    @Autowired
    private ResourceService service;

    /**
     * get all resources from database
     */
    @GetMapping("/resources")
    public List<Resource> list() {
        return service.findAll();
    }

    /**
     * creat a resources
     */
    @PostMapping("/resources")
    public Resource create(@RequestParam("name") String name,
                             @RequestParam("resource_code") Integer code) {
        Resource resource = new Resource();
        resource.setResourceName(name);
        resource.setResourceCode(code);
        return service.save(resource);
    }

    /**
     * find a resources by its id
     */
    @GetMapping("/resources/{id}")
    public Resource findById( @PathVariable("id") Integer id) {
        return service.findOneById(id);
    }

    /**
     * updated a resources information
     */
    @PutMapping("/resources/{id}")
    public Resource update( @PathVariable("id") Integer id,
                            @RequestParam("name") String name) {
        Resource resource = service.findOneById(id);
        resource.setResourceName(name);
        return service.save(resource);
    }

}
