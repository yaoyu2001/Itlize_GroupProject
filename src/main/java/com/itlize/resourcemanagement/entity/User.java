package com.itlize.resourcemanagement.entity;


//import com.sun.javafx.geom.transform.Identity;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "user", uniqueConstraints = {@UniqueConstraint (columnNames = "user_name")})
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private int userId;

    @Column (name = "user_name")
    private String userName;

    @Column (name = "password")
    private String password;

    @Enumerated (EnumType.STRING)
    @Column (name = "role")
    private Role role;

    @CreatedDate
    @Column (name = "create_time", updatable = false, nullable = false)
//    @Column (name = "create_time",columnDefinition = "Current_timestamp", updatable = false, nullable = false)
    private Date create_time;

    @LastModifiedDate
    @Column (name = "update_time", nullable = false)
//    @Column (name = "update_time",columnDefinition = "Current_timestamp", nullable = false)

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
    private Set<UserToProject> UserToProjectSet = new HashSet<>();

    //Constructors
    public User() {
    }


    public User(String userName, String password, Date create_time, Date update_time, String email, String first_name, String last_name) {
        this.userName = userName;
        this.password = password;
        this.create_time = create_time;
        this.update_time = update_time;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

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

    public Set<UserToProject> getUserToProjectSet() {
        return UserToProjectSet;
    }

    public void setUserToProjectSet(Set<UserToProject> userToProjectSet) {
        UserToProjectSet = userToProjectSet;
    }
}
