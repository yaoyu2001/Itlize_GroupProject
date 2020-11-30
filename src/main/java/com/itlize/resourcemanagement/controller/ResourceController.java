package com.itlize.resourcemanagement.controller;

import com.itlize.resourcemanagement.entity.Resources;
import com.itlize.resourcemanagement.service.ResourceService;
import com.itlize.resourcemanagement.service.impl.ResourceServiceImpl;
import com.itlize.resourcemanagement.DAO.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
    public List<Resources> list() {
        return service.findAll();
    }

    /**
     * creat a resources
     */
    @PostMapping("/resources")
    public Resources create(@RequestParam("name") String name,
                             @RequestParam("money") Integer code) {
        Resources resources = new Resources();
        resources.setResourceName(name);
        resources.setResourceCode(code);
        return service.save(resources);
    }

    /**
     * find a resources by its id
     */
    @GetMapping("/resources/{id}")
    public Resources findById(@PathVariable("id") Integer id) {
        return service.findOneById(id);
    }

    /**
     * updated a resources information
     */
    @PutMapping("/resources/{id}")
    public Resources update(@PathVariable("id") Integer id,
                             @RequestParam("name") String name) {
        Resources resources= service.findOneById(id);
        resources.setResourceName(name);
        return service.save(resources);
    }

}
