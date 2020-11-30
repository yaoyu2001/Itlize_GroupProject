package com.itlize.resourcemanagement.service.impl;

import com.itlize.resourcemanagement.DAO.ResourceRepository;
import com.itlize.resourcemanagement.entity.Resources;
import com.itlize.resourcemanagement.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional // Guarantee all manipulates all completed
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    private ResourceRepository resourceDao;

    @Override
    public Resources findOneById(Integer Id) {
        return resourceDao.findById(Id).orElse(null);
    }

    @Override
    public List<Resources> findAll() {
        return resourceDao.findAll();
    }

    @Override
    public Resources save( Resources resources) {
        return resourceDao.save(resources);
    }

    public void deleteById(Integer id){
        resourceDao.deleteById(id);
    }


}