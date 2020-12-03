package com.itlize.resourcemanagement.DAO;
import com.itlize.resourcemanagement.entity.Project;
import com.itlize.resourcemanagement.entity.Resource;
import com.itlize.resourcemanagement.entity.ResourceColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDAO extends JpaRepository<Project, Integer>{
    @Query(value = "SELECT * FROM project WHERE user_id=?", nativeQuery = true)
    public List<Project> findALLByUserId(Integer userID);


    @Query(value = "INSERT INTO resource_column (resource_column_name,resource_column_value," +
            "resource_column_type,resource_id,project_id)" +
            "VALUES (?,?,?,?,?)", nativeQuery = true)
    public void addColumnForProject(String columnName, String columnValue, ResourceColumn.ColumnType columnType,
                                    Resource resource_id, Project project_id);

}
