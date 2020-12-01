package com.itlize.resourcemanagement.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Resources", uniqueConstraints = {@UniqueConstraint (columnNames = "resource_name")})
public class Resources {

    public Resources() {
    }

    public Resources(int resourceCode, String resourceName, boolean editable, int itemId, Timestamp createTime, Timestamp updateTime) {
        this.resourceCode = resourceCode;
        this.resourceName = resourceName;
        this.editable = editable;
        this.itemId = itemId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int resourceCode;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "editable")
    private boolean editable;


    @Column(name = "item_id")
    private int itemId;

//    @Column (name = "create_time",columnDefinition = "DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", updatable = false, nullable = false)
    @CreatedDate
    @Column (name = "create_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createTime;

    @LastModifiedDate
    @Column (name = "update_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
//    @Column(name = "update_time",columnDefinition = "Current_timestamp", nullable = false)
    private Timestamp updateTime;

    @OneToMany(mappedBy = "resource")
    private Set<ProjectToResource> projectToResource;

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

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
