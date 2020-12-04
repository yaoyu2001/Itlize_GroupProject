package com.itlize.resourcemanagement.Service.imp;

import com.itlize.resourcemanagement.Service.ProjectService;
import com.itlize.resourcemanagement.entity.Project;
import com.itlize.resourcemanagement.entity.Resource;
import com.itlize.resourcemanagement.entity.ResourceColumn;
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

    @Override
    public void deleteById(Integer Id){
        repository.deleteById(Id);
    }

    @Override
    public List<Project> findALLByUserId(Integer Id) {
        return repository.findALLByUserId(Id);
    }

    @Override
    public void addColumnForProject(String columnName, String columnValue,
                                    ResourceColumn.ColumnType columnType, Resource resource_id, Project project_id) {
        repository.addColumnForProject(columnName,columnValue,columnType,resource_id,project_id);

    }


}
