package com.itlize.resourcemanagement.entity;


import com.sun.javafx.geom.transform.Identity;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "user", uniqueConstraints = {@UniqueConstraint (columnNames = "user_name")})
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private long userId;

    @Column (name = "user_name", unique = true)
    private String userName;

    @Column (name = "password")
    private String password;

    @Enumerated (EnumType.STRING)
    @Column (name = "role")
    private Role role;

    @CreatedDate
    @Column (name = "create_time",columnDefinition = "Current_timestamp", updatable = false, nullable = false)
    private Date create_time;

    @LastModifiedDate
    @Column (name = "update_time",columnDefinition = "Current_timestamp", nullable = false)
    private Date update_time;

    @Column (name = "main_image")
    private String mainImage;

    @Column (name = "email")
    private String email;

    @Column (name = "first_name", nullable = false)
    private String first_name;

    @Column (name = "last_name", nullable = false)
    private String last_name;

    //Constructors
    public User() {
    }


    public User( String user_name, String password, String firstName, String lastName ) {
        this.userName = user_name;
        this.password = password;
        this.first_name = firstName;
        this.last_name = lastName;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId( long userId ) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }


    public Role getRole() {
        return role;
    }

    public void setRole( Role role ) {
        this.role = role;
    }


    public Date getTimeCreate() {
        return create_time;
    }

    public Date getLastUpdated() {
        return update_time;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage( String mainImage ) {
        this.mainImage = mainImage;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }


    public String getFirstname() {
        return first_name;
    }

    public void setFirstname( String firstname ) {
        this.first_name = firstname;
    }


    public String getLastname() {
        return last_name;
    }

    public void setLastname( String lastname ) {
        this.last_name = lastname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + userId + '\'' +
                ", user_name='" + userName + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
