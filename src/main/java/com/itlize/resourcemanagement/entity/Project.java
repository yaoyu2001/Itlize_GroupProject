package com.itlize.resourcemanagement.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int project_id;

    @Column(name = "project_name")
    private String project_name;

    @CreatedDate
    @Column (name = "create_time",updatable = false, nullable = false)
    private Date create_time;

    @LastModifiedDate
    @Column (name = "update_time",nullable = false)
    private Date update_time;

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
    private Set<UserToProject> UserToProjectSet;

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
    private Set<ProjectToResource> projectToResource;

    public Project() {
    }

    public Project( String project_name, Date create_time, Date update_time) {
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

    public Set<UserToProject> getUserToProjectSet() {
        return UserToProjectSet;
    }

    public void setUserToProjectSet(Set<UserToProject> userToProjectSet) {
        UserToProjectSet = userToProjectSet;
    }

    public Set<ProjectToResource> getProjectToResource() {
        return projectToResource;
    }

    public void setProjectToResource(Set<ProjectToResource> projectToResource) {
        this.projectToResource = projectToResource;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "id='" + project_id + '\'' +
                ", project_name='" + project_name + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
