
package com.itlize.resourcemanagement.DAO;

import com.itlize.resourcemanagement.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer>{
}
