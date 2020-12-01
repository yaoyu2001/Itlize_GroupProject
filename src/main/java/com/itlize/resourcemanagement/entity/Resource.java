package com.itlize.resourcemanagement.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "resource", uniqueConstraints = {@UniqueConstraint (columnNames = "resource_name")})
@EntityListeners(AuditingEntityListener.class)
public class Resource {

    public Resource() {
    }

    public Resource( int resourceCode, String resourceName, boolean editable,
                     int itemId, Date createTime, Date updateTime) {
        this.resourceCode = resourceCode;
        this.resourceName = resourceName;
        this.editable = editable;
        this.itemId = itemId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }


    @Id
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int resourceCode;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "editable")
    private boolean editable = false;


    @Column(name = "item_id")
    private int itemId;

    @CreatedDate
    @Column (name = "create_time",updatable = false, nullable = false)
    private Date createTime;

    @LastModifiedDate
    @Column (name = "update_time",nullable = false)
    private Date updateTime;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="resource",
            cascade = CascadeType.ALL)
    private List<ResourceColumn> ResourceColumn;


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
