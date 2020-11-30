package com.itlize.resourcemanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "project_resources")
public class ProjectToResource {
    @Id
    @GeneratedValue
    private int projectResourceId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resourceCode", referencedColumnName = "resourceCode")
    private Resources resource;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectID", referencedColumnName = "project_id")
    private Projects project;

    public int getProjectResourceId() {
        return projectResourceId;
    }

    public void setProjectResourceId(int projectResourceId) {
        this.projectResourceId = projectResourceId;
    }

    public Resources getResource() {
        return resource;
    }

    public void setResource(Resources resource) {
        this.resource = resource;
    }

    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }
}
