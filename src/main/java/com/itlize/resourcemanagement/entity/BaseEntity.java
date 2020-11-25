package com.itlize.resourcemanagement.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
public class BaseEntity implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "version")
    private String version;

    @Column(name = "flag")
    private String flag;

    @Column(name = "status")
    private String status;

    @Column(name = "createDate")
    private String createDate;

    @Column(name = "updateDate")
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
//        return "BaseEntity [id=" + id + ", version=" + version + ", flag=" + flag + ", status=" + status
//                + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
        return "BaseEntity [id=" +"]";
    }

}