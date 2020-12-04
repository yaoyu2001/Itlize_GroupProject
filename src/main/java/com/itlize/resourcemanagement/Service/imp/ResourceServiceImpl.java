package com.itlize.resourcemanagement.Service.imp;

import com.itlize.resourcemanagement.DAO.ResourceDAO;
import com.itlize.resourcemanagement.entity.Project;
import com.itlize.resourcemanagement.entity.Resource;
import com.itlize.resourcemanagement.Service.ResourceService;
import com.itlize.resourcemanagement.entity.ResourceColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional // Guarantee all manipulates all completed
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    private ResourceDAO resourceDao;

    @Override
    public Resource findOneById( Integer Id) {
        return resourceDao.findById(Id).orElse(null);
    }

    @Override
    public Resource findResById( Integer Id) {
        return resourceDao.findByResourceCode(Id);
    }

    @Override
    public List<Resource> findAll() {
        return resourceDao.findAll();
    }

    @Override
    public Resource save( Resource resource ) {
        return resourceDao.save(resource);
    }

    @Override
    public void deleteById(Integer id){
        resourceDao.deleteById(id);
    }

    @Override
    public void addColumnForResource(String columnName, String columnValue,
                                    ResourceColumn.ColumnType columnType, Resource resource_id) {
        resourceDao.addColumnForProject(columnName,columnValue,columnType,resource_id);

    }
}