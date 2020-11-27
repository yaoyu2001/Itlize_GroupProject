package com.itlize.resourcemanagement.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Resources", uniqueConstraints = {@UniqueConstraint (columnNames = "resource_name")})
public class Resources {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int resourceCode;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "editable")
    private boolean editable = false;

    @Column(name = "item_id")
    private int itemId;

//    @Column (name = "create_time",columnDefinition = "Current_timestamp", updatable = false, nullable = false)
    @CreatedDate
    @Column (name = "create_time")
    private Date createTime;

    @LastModifiedDate
    @Column (name = "update_time")
//    @Column(name = "update_time",columnDefinition = "Current_timestamp", nullable = false)
    private Date updateTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
