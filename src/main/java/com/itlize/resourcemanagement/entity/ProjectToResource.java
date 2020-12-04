package com.itlize.resourcemanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "project_resources")
public class ProjectToResource {
    @Id
    @GeneratedValue
    private int projectResourceId;

    @Column(name = "create_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp create_time;

    @JsonIgnore
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="resources_id")
    private Resource resource;

    @JsonIgnore
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }
}
