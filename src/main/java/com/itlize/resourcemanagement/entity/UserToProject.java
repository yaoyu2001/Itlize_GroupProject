package com.itlize.resourcemanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_project")
public class UserToProject {
    @Id
    @GeneratedValue
    private long userProjectId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID", referencedColumnName = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectID", referencedColumnName = "project_id")
    private Projects project;
}
