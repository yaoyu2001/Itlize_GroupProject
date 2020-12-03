package com.itlize.resourcemanagement.Service;
import com.itlize.resourcemanagement.entity.Project;

import java.util.List;

public interface ProjectService {
    public Project findOneById( Integer id);

    List<Project> findAll();

    public Project save (Project project);

    public void deleteById(Integer Id);
    List<Project> findOneByUserId(Integer id);
    }