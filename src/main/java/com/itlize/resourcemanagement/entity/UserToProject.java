package com.itlize.resourcemanagement.entity;


import javax.persistence.*;

@Entity
@Table(name = "user_project")
public class UserToProject {
    @Id
    @GeneratedValue
    private int userprojectid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Projects projects;

    public Projects getProjects() {
        return projects;
    }

    public void setProjects(Projects projects) {
        this.projects = projects;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
