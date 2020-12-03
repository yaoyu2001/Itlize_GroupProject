package com.itlize.resourcemanagement.Service.imp;

import com.itlize.resourcemanagement.DAO.ResourceRepository;
import com.itlize.resourcemanagement.entity.Resource;
import com.itlize.resourcemanagement.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional // Guarantee all manipulates all completed
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    private ResourceRepository resourceDao;

    @Override
    public Resource findOneById( Integer Id) {
//        return resourceDao.findByResourceCode(Id).orElse(null);
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

    public void deleteById(Integer id){
        resourceDao.deleteById(id);
    }


}