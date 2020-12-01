package com.itlize.resourcemanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "project_resources")
public class ProjectToResource {
    @Id
    @GeneratedValue
    private int projectResourceId;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="resources_id")
    private Resource resource;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "project_id")
    private Project project;

    public int getProjectResourceId() {
        return projectResourceId;
    }

    public void setProjectResourceId(int projectResourceId) {
        this.projectResourceId = projectResourceId;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource( Resource resource) {
        this.resource = resource;
    }

//    public Projects getProject() {
//        return project;
//    }
//
//    public void setProject(Projects project) {
//        this.project = project;
//    }
}
