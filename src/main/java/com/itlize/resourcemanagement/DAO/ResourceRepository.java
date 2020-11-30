
package com.itlize.resourcemanagement.DAO;

import com.itlize.resourcemanagement.entity.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itlize.resourcemanagement.entity.Resources;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resources, Integer>{
//    public Resources findById(Long id);
//
//    @SuppressWarnings("unchecked")
//    public Resources save(Resources resources);//Save resources
//
//
//    // Delete user
//    @SuppressWarnings("")
//    public void deleteById(Long id);
//
//    //
//    public List<Resources> findAll();

}
