package com.itlize.resourcemanagement.Service;
import com.itlize.resourcemanagement.entity.Project;
import com.itlize.resourcemanagement.entity.Resource;
import com.itlize.resourcemanagement.entity.ResourceColumn;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public interface ProjectService {
    public Project findOneById( Integer id);

    List<Project> findAll();

    public Project save (Project project);

    public void deleteById(Integer Id);

    public List<Project> findALLByUserId(Integer id);

    public void addColumnForProject(String columnName, String columnValue, ResourceColumn.ColumnType columnType,
                                    Resource resource_id, Project project_id);
}