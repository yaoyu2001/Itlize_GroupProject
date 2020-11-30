package com.itlize.resourcemanagement.service;


import com.itlize.resourcemanagement.entity.Resources;

import java.util.List;

public interface ResourceService {
    public Resources findOneById(Integer Id);

    List<Resources> findAll();

    public Resources save(Resources luckymoney);

}
