package com.itlize.resourcemanagement.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

import java.util.Set;

@Entity
@Table(name = "projects")
public class Projects {
    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private String project_id;

    @Column(name = "project_name")
    private String project_name;

    @CreatedDate
    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "update_time")
    private Date update_time;

    @OneToMany(mappedBy = "projects")
    private Set<UserToProject> UserToProjectSet;

    @OneToMany(mappedBy = "project")
    private Set<ProjectToResource >projectToResource;

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
