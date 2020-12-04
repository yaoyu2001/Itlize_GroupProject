package com.itlize.resourcemanagement.test;

import com.itlize.resourcemanagement.DAO.ResourceDAO;
import com.itlize.resourcemanagement.DAO.UserDAO;
import com.itlize.resourcemanagement.Service.ResourceService;
import com.itlize.resourcemanagement.Service.UserService;
import com.itlize.resourcemanagement.Service.imp.ResourceServiceImpl;
import com.itlize.resourcemanagement.Service.imp.UserServiceImp;
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
public class UserServiceTest {


    @TestConfiguration
    static class ResourceTestServiceContextConfiguration {

        @Bean
        public UserService resourceService() {
            return new UserServiceImp();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserDAO userDAO;

    @Before
    public void setUp() {
        Date d = new Date(System.currentTimeMillis());
        User user = new User("yyao", "123456",d,d,"yyao@gmail.com","Yongchang","Yao");

        Mockito.when(userDAO.findUserByUsername("yyao"))
                .thenReturn(user);
    }

    // write test cases here
    @Test
    public void testResourceService() {
        String name = "yyao";

        User found = userService.findUserByUsername("yyao");
        System.out.println(found);
        Assert.assertEquals(found.getUserName(), name);
    }
}