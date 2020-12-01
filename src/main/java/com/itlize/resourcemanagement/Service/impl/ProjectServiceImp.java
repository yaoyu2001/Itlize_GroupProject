package com.itlize.resourcemanagement.Service.impl;

import com.itlize.resourcemanagement.Service.ProjectService;
import com.itlize.resourcemanagement.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itlize.resourcemanagement.DAO.ProjectRepo;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {

   @Autowired
   private ProjectRepo repository;

    @Override
    public Project findOneById( Integer Id) {
        return repository.findById(Id).orElse(null);
    }

    @Override
    public List<Project> findAll() {
        return repository.findAll();
    }
    @Override
    public Project save( Project project){
        return repository.save(project);
    }

    public void deleteById(Integer Id){
        repository.deleteById(Id);
    }


}
