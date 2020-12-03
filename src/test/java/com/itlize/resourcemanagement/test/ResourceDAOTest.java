package com.itlize.resourcemanagement.test;

import com.itlize.resourcemanagement.DAO.ResourceRepository;
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
public class ResourceDAOTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ResourceRepository resourceRepository;

    // write test cases here
    @Test
    public void testFindResource() {
        // given

        Date d = new Date(System.currentTimeMillis());
        Resource wood = new Resource(123, "wood", false, 123456, d,d);

        entityManager.persist(wood);
        entityManager.flush();

        Resource found = resourceRepository.findById(wood.getResourceCode()).get();
        Assert.assertEquals(found.getResourceName(), wood.getResourceName());
        Assert.assertEquals(found.getResourceCode(), wood.getResourceCode());

    }

}