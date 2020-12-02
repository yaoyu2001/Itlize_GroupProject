package com.itlize.resourcemanagement.Service;

import com.itlize.resourcemanagement.entity.Project;

import java.util.List;


public interface FindProjectByUserService {

    List<Project> findOneByUserId(Integer id);

}