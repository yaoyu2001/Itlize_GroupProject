package com.itlize.resourcemanagement.Service.imp;

import com.itlize.resourcemanagement.DAO.FindProjectByUserId;
import com.itlize.resourcemanagement.Service.FindProjectByUserService;
import com.itlize.resourcemanagement.Service.ProjectService;
import com.itlize.resourcemanagement.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itlize.resourcemanagement.DAO.ProjectDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectDAO repository;

    @Override
    public Project findOneById(Integer Id) {
        return repository.findById(Id).orElse(null);
    }

    @Override
    public List<Project> findAll() {
        return repository.findAll();
    }
    @Override
    public Project save(Project project){
        return repository.save(project);
    }

    public void deleteById(Integer Id){
        repository.deleteById(Id);
    }

    @Override
    public List<Project> findOneByUserId(Integer Id) {
        return repository.findOneByUserId(Id);
    }

    //    @Override
    //    public List<Project> findAll() {
    //        return findProjectByUserIdDAO.findAll();
    //    }

}
