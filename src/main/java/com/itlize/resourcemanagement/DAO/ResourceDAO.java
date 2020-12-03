
package com.itlize.resourcemanagement.DAO;

import com.itlize.resourcemanagement.entity.Project;
import com.itlize.resourcemanagement.entity.Resource;
import com.itlize.resourcemanagement.entity.ResourceColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceDAO extends JpaRepository<Resource, Integer>{
    @Query(value = "INSERT INTO resource_column (resource_column_name,resource_column_value," +
            "resource_column_type,resource_id,project_id)" +
            "VALUES (?,?,?,?,null)", nativeQuery = true)
    public void addColumnForProject(String columnName, String columnValue, ResourceColumn.ColumnType columnType,
                                    Resource resource_id);

}
