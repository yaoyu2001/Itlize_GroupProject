package com.itlize.resourcemanagement.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "resource", uniqueConstraints = {@UniqueConstraint (columnNames = "resource_code")})
@EntityListeners(AuditingEntityListener.class)
public class Resource {

    @Id
    @Column(name = "resource_code")
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int resourceCode;

    @Column(name = "resource_name")
    private String resourceName;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="resource",
            cascade = CascadeType.ALL)
    private List<ResourceColumn> ResourceColumn;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="resource",
            cascade = CascadeType.ALL)
    private List<ProjectToResource> ProjectToResource;

    public Resource() {
    }

    public Resource( int resourceCode, String resourceName, boolean editable,
                     int itemId, Date createTime, Date updateTime) {
        this.resourceCode = resourceCode;
        this.resourceName = resourceName;
    }
    public int getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(int resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }


    public List<ResourceColumn> getResourceColumn() {
        return ResourceColumn;
    }

    public void setResourceColumn(List<ResourceColumn> resourceColumn) {
        this.ResourceColumn = resourceColumn;
    }

    public List<ProjectToResource> getProjectToResource() {
        return ProjectToResource;
    }

    public void setProjectToResource(List<ProjectToResource> projectToResource) {
        ProjectToResource = projectToResource;
    }
}
