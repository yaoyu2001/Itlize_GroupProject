package com.itlize.resourcemanagement.Service;


import com.itlize.resourcemanagement.entity.Project;
import com.itlize.resourcemanagement.entity.Resource;
import com.itlize.resourcemanagement.entity.ResourceColumn;

import java.util.List;

public interface ResourceService {
    public Resource findOneById( Integer Id);

    public Resource findResById( Integer Id);

    List<Resource> findAll();

    public Resource save( Resource luckymoney);

    public void deleteById(Integer Id);

    public void addColumnForResource(String columnName, String columnValue, ResourceColumn.ColumnType columnType,
                                    Resource resource_id);
}
