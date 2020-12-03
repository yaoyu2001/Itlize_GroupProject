package com.itlize.resourcemanagement.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
@EntityListeners(AuditingEntityListener.class)
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

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="project",
            cascade = CascadeType.ALL)
    private Set<ProjectColumn> projectColumns = new HashSet<>();

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="project",
            cascade = CascadeType.ALL)
    private Set<ProjectToResource> projectToResources = new HashSet<>();

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

    public User getUser() {return user; }

    public void setUser(User user) {this.user = user;}

    public Set<ProjectColumn> getProjectColumns() {return projectColumns;}

    public void setProjectColumns(Set<ProjectColumn> projectColumns) { this.projectColumns = projectColumns; }

    public Set<ProjectToResource> getProjectToResources() {return projectToResources;}

    public void setProjectToResources(Set<ProjectToResource> projectToResources) {this.projectToResources = projectToResources; }

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
