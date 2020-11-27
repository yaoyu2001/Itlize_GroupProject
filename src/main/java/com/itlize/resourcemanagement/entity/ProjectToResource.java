package com.itlize.resourcemanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "project_resources")
public class ProjectToResource {
    @Id
    @GeneratedValue
    private int projectResourceId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resourceID", referencedColumnName = "resource_Code")
    private Resources resource;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectID", referencedColumnName = "project_id")
    private Projects project;
}
