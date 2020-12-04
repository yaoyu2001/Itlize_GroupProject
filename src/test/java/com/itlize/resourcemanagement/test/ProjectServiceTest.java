package com.itlize.resourcemanagement.test;

import com.itlize.resourcemanagement.DAO.ProjectDAO;
import com.itlize.resourcemanagement.DAO.ResourceDAO;
import com.itlize.resourcemanagement.DAO.UserDAO;
import com.itlize.resourcemanagement.Service.ProjectService;
import com.itlize.resourcemanagement.Service.ResourceService;
import com.itlize.resourcemanagement.Service.UserService;
import com.itlize.resourcemanagement.Service.imp.ProjectServiceImp;
import com.itlize.resourcemanagement.Service.imp.ResourceServiceImpl;
import com.itlize.resourcemanagement.Service.imp.UserServiceImp;
import com.itlize.resourcemanagement.entity.Project;
import com.itlize.resourcemanagement.entity.Resource;
import com.itlize.resourcemanagement.entity.User;
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
public class ProjectServiceTest {


    @TestConfiguration
    static class ResourceTestServiceContextConfiguration {

        @Bean
        public ProjectService resourceService() {
            return new ProjectServiceImp();
        }
    }

    @Autowired
    private ProjectService projectService;

    @MockBean
    private ProjectDAO projectDAO;

    @Before
    public void setUp() {
        Date d = new Date(System.currentTimeMillis());
        Project wood_project = new Project("wood_project",d,d);

        Mockito.when(projectDAO.findByProject_name("wood_project"))
                .thenReturn(wood_project);
    }

    // write test cases here
    @Test
    public void testResourceService() {
        String name = "wood_project";

        Project found = projectService.findOneByProjectName(name);
//        System.out.println(found);
        Assert.assertEquals(found.getProject_name(), name);
    }
}