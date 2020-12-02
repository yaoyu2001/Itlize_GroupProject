package com.itlize.resourcemanagement.Service.imp;


import com.itlize.resourcemanagement.DAO.FindProjectByUserId;
import com.itlize.resourcemanagement.DAO.ResourceRepository;
import com.itlize.resourcemanagement.Service.FindProjectByUserService;
import com.itlize.resourcemanagement.entity.Project;
import com.itlize.resourcemanagement.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // Guarantee all manipulates all completed
public class FindProjectByUserIdImp implements FindProjectByUserService {


    @Autowired
    private FindProjectByUserId findProjectByUserIdDAO;

    @Override
    public List<Project> findOneByUserId(Integer Id) {
        return findProjectByUserIdDAO.findOneByUserId(Id);
    }

//    @Override
//    public List<Project> findAll() {
//        return findProjectByUserIdDAO.findAll();
//    }

}
