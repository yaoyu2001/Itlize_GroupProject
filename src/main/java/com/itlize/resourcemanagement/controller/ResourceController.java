package com.itlize.resourcemanagement.controller;


import com.itlize.resourcemanagement.entity.Resource;
import com.itlize.resourcemanagement.Service.ResourceService;
import com.itlize.resourcemanagement.entity.ResourceColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ResourceController {

    @Qualifier ("resourceServiceImpl")
    @Autowired
    private ResourceService service;


    @GetMapping("/resources")
    public List<Resource> list() {
        return service.findAll();
    }

    @PostMapping("/resources")
    public Resource create(@RequestParam("name") String name,
                             @RequestParam("resource_code") Integer code) {
        Resource resource = new Resource();
        resource.setResourceName(name);
        resource.setResourceCode(code);
        return service.save(resource);
    }

    @GetMapping("/resources/{id}")
    public Resource findById( @PathVariable("id") Integer id) {
        return service.findOneById(id);
    }


    @PutMapping("/resources/{id}")
    public Resource update( @PathVariable("id") Integer id,
                            @RequestParam("name") String name) {
        Resource resource = service.findOneById(id);
        resource.setResourceName(name);
        return service.save(resource);
    }


    @DeleteMapping("/resources/{id}")
    public void deleteResource(@PathVariable("id") Integer id){
        Resource resource = service.findOneById(id);
        service.deleteById(id);
    }

    @PostMapping("/resources/addColumn")
    public void addColumn(@RequestBody ResourceColumn resourceColumn){
        service.addColumnForResource(resourceColumn.getColumnName(),resourceColumn.getColumnValue(),
                resourceColumn.getColumnType(),resourceColumn.getResource());
    }
}
