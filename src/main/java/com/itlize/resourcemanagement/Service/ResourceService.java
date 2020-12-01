package com.itlize.resourcemanagement.Service;


import com.itlize.resourcemanagement.entity.Resource;

import java.util.List;

public interface ResourceService {
    public Resource findOneById( Integer Id);

    List<Resource> findAll();

    public Resource save( Resource luckymoney);

}