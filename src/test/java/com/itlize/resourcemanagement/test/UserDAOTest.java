package com.itlize.resourcemanagement.test;

import com.itlize.resourcemanagement.DAO.ResourceDAO;
import com.itlize.resourcemanagement.DAO.UserDAO;
import com.itlize.resourcemanagement.entity.Resource;
import com.itlize.resourcemanagement.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;


@RunWith (SpringRunner.class)
@DataJpaTest
public class UserDAOTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserDAO userDAO;

    // write test cases here
    @Test
    public void testFindResource() {
        // given

        Date d = new Date(System.currentTimeMillis());
        User user = new User("yyao", "123456",d,d,"yyao@gmail.com","Yongchang","Yao");

        entityManager.persist(user);
        entityManager.flush();

        User found = userDAO.findUserByUsername(user.getUserName());
        Assert.assertEquals(found.getUserName(), user.getUserName());


    }

}