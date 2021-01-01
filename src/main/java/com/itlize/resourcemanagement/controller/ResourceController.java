package com.itlize.resourcemanagement.controller;


import com.itlize.resourcemanagement.entity.Resource;
import com.itlize.resourcemanagement.Service.ResourceService;
import com.itlize.resourcemanagement.entity.ResourceColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("resources")
public class ResourceController {

    @Qualifier ("resourceServiceImpl")
    @Autowired
    private ResourceService service;

    @GetMapping("/all")
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

    @GetMapping("/{id}")
    public Resource findById( @PathVariable("id") Integer id) {
        return service.findOneById(id);
    }


    @PutMapping("/{id}")
    public Resource update( @PathVariable("id") Integer id,
                            @RequestParam("name") String name) {
        Resource resource = service.findOneById(id);
        resource.setResourceName(name);
        return service.save(resource);
    }


    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable("id") Integer id){
        Resource resource = service.findOneById(id);
        service.deleteById(id);
    }

    @PostMapping("/addColumn")
    public void addColumn(@RequestBody ResourceColumn resourceColumn){
        service.addColumnForResource(resourceColumn.getColumnName(),resourceColumn.getColumnValue(),
                resourceColumn.getColumnType(),resourceColumn.getResource());
    }
}
