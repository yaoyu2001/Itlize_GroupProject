package com.itlize.resourcemanagement.Service;
import com.itlize.resourcemanagement.entity.Projects;
import java.util.List;

public interface ProjectService {
    public Projects findOneById(Integer id);

    List<Projects> findAll();

    public Projects save (Projects project);

    public void deleteById(Integer Id);

    }