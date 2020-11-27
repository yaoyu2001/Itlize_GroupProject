package com.itlize.resourcemanagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Resources")
public class Resources {
    public Resources() {
    }

    public Resources(int resourceCode, String resourceName, boolean editable, int itemId, Date createTime, Date updateTime) {
        this.resourceCode = resourceCode;
        this.resourceName = resourceName;
        this.editable = editable;
        this.itemId = itemId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Id
    @GeneratedValue
    private int resourceCode;

    @Column(name = "resource_name", unique=true)
    private String resourceName;

    @Column(name = "editable")
    private boolean editable;

    @Column(name = "item_id")
    private int itemId;

    @Column (name = "create_time", updatable = false, nullable = false)
    private Date createTime;

    @Column(name = "update_time", nullable = false)
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
