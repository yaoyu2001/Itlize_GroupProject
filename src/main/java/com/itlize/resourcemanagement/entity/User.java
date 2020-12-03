package com.itlize.resourcemanagement.entity;


//import com.sun.javafx.geom.transform.Identity;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "user", uniqueConstraints = {@UniqueConstraint (columnNames = "user_name")})
@EntityListeners(AuditingEntityListener.class)
public class User {
    public enum Role {
        ADMIN, USER;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int userId;

    @Column (name = "user_name")
    private String username;

    @Column (name = "password")
    private String password;

    @Enumerated (EnumType.STRING)
    @Column (name = "role")
    private Role role;

    @CreatedDate
    @Column (name = "create_time",updatable = false, nullable = false)
    private Date create_time;

    @LastModifiedDate
    @Column (name = "update_time",nullable = false)
    private Date update_time;

    @Column (name = "main_image")
    private String mainImage;

    @Column (name = "email")
    private String email;

    @Column (name = "first_name", nullable = false)
    private String first_name;

    @Column (name = "last_name", nullable = false)
    private String last_name;

    @OneToMany(mappedBy = "user")
    private Set<Project> UserToProjectSet = new HashSet<>();

    //Constructors
    public User() {
    }

    public User(String username, String password, Date create_time, Date update_time, String email, String first_name, String last_name) {
        this.username = username;
        this.password = password;
        this.create_time = create_time;
        this.update_time = update_time;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getUserName() {
        return username;
    }
    public void setUserName(String username) {
        this.username = username;
    }
    public String getPassword() { return password; }
    public void setPassword(String password) {
        this.password = password;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
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
    public String getMainImage() {
        return mainImage;
    }
    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Set<Project> getUserToProjectSet() {
        return UserToProjectSet;
    }

    public void setUserToProjectSet(Set<Project> userToProjectSet) {
        UserToProjectSet = userToProjectSet;
    }

}
