//package com.itlize.resourcemanagement.entity;
//
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "user_project")
//public class UserToProject {
//    @Id
//    @GeneratedValue
//    private int userprojectid;
//
//    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//            CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinColumn(name = "user_id")
//    private User user;
//

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@ManyToOne (cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//            CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinColumn (name = "project_id")
//    private Project project;
//
//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject( Project project ) {
//        this.project = project;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//}
