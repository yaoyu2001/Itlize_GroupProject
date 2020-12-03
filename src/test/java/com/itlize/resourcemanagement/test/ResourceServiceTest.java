package com.itlize.resourcemanagement.test;

import com.itlize.resourcemanagement.DAO.ResourceRepository;
import com.itlize.resourcemanagement.Service.ResourceService;
import com.itlize.resourcemanagement.Service.imp.ResourceServiceImpl;
import com.itlize.resourcemanagement.entity.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith (SpringRunner.class)
public class ResourceServiceTest {

    @TestConfiguration
    static class ResourceTestServiceContextConfiguration {

        @Bean
        public ResourceService resourceService() {
            return new ResourceServiceImpl();
        }
    }

    @Autowired
    private ResourceService resourceService;

    @MockBean
    private ResourceRepository resourceRepository;

    @Before
    public void setUp() {
        Date d = new Date(System.currentTimeMillis());
        Resource wood = new Resource(123, "wood", false, 123456, d,d);

        Mockito.when(resourceRepository.findByResourceCode(123))
                .thenReturn(wood);
    }

    // write test cases here
    @Test
    public void testResourceService() {
        String name = "wood";
        Integer id = 123;

        Resource found = resourceService.findOneById(id);
        System.out.println(found);
        Assert.assertEquals(found.getResourceName(), name);
        Assert.assertEquals(found.getResourceName(), name);
    }
}