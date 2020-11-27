package com.itlize.resourcemanagement.entity;


import com.sun.javafx.geom.transform.Identity;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "resource_management" , uniqueConstraints = {@UniqueConstraint(columnNames="user_name")})
public class User {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="user_id")
  private long userId;

  @Column(name="user_name")
  private String userName;

  @Column(name = "password")
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "role")
  private Role role;

  @CreatedDate
  @Column(updatable = false, nullable = false)
  private Date timeCreate;

  @LastModifiedDate
  @Column(nullable = false)
  private Date lastModified;

  @Column(name = "main_image")
  private String mainImage;

  @Column(name = "email")
  private String email;

  @Column(name = "first_name")
  private String firstname;

  @Column(name = "last_name")
  private String lastname;

  //Constructors
  public User() {
  }


  public User(String user_name, String password, String firstName, String lastName) {
    this.userName = user_name;
    this.password = password;
    this.firstname = firstName;
    this.lastname = lastName;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }


  public Date getTimeCreate() {
    return timeCreate;
  }

  public Date getLastUpdated() {
    return lastModified;
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


  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }


  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  @Override
  public String toString() {
    return "User{" +
            "id='" + userId + '\'' +
            ", user_name='" + userName + '\'' +
            ", create_time=" + timeCreate +
            ", update_time=" + lastModified +
            '}';
  }

}
