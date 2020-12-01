package com.itlize.resourcemanagement.Service.Imp;

import com.itlize.resourcemanagement.Service.ProjectService;
import com.itlize.resourcemanagement.entity.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itlize.resourcemanagement.DAO.ProjectDAO;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {

   @Autowired
   private ProjectDAO repository;

    @Override
    public Projects findOneById(Integer Id) {
        return repository.findById(Id).orElse(null);
    }

    @Override
    public List<Projects> findAll() {
        return repository.findAll();
    }
    @Override
    public Projects save(Projects project){
        return repository.save(project);
    }

    public void deleteById(Integer Id){
        repository.deleteById(Id);
    }


}
