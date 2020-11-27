package com.itlize.resourcemanagement.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Projects {
    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private String id;

    @Column(name = "project_name")
    private String project_name;

    @CreatedDate
    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "update_time")
    private Date update_time;

    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    public Projects() {
    }

    public Projects(String project_name, Date create_time, Date update_time) {
        this.project_name = project_name;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "id='" + id + '\'' +
                ", project_name='" + project_name + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
