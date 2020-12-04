package com.itlize.resourcemanagement.test;

import com.itlize.resourcemanagement.DAO.ProjectDAO;
import com.itlize.resourcemanagement.DAO.ResourceDAO;
import com.itlize.resourcemanagement.entity.Project;
import com.itlize.resourcemanagement.entity.Resource;
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
public class ProjectDAOTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProjectDAO projectDAO;

    // write test cases here
    @Test
    public void testFindResource() {
        // given

        Date d = new Date(System.currentTimeMillis());
        Project wood_project = new Project("wood_project",d,d);

        entityManager.persist(wood_project);
        entityManager.flush();

        Project found = projectDAO.findByProject_name(wood_project.getProject_name());
        Assert.assertEquals(found.getProject_name(), wood_project.getProject_name());


    }

}
