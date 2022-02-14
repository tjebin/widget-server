package com.example.wbdvsp2102mdserverjava.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userID;
  private String userName;
  private String userPW;
  private String userRole;
  private String userPicUrl;
  private String userBio;
  private String userEmail;


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public Integer getUserID() {
    return userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPW() {
    return userPW;
  }

  public void setUserPW(String userPW) {
    this.userPW = userPW;
  }

  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }

  public String getUserPicUrl() {
    return userPicUrl;
  }

  public void setUserPicUrl(String userPicUrl) {
    this.userPicUrl = userPicUrl;
  }

  public String getUserBio() {
    return userBio;
  }

  public void setUserBio(String userBio) {
    this.userBio = userBio;
  }


  public User(Integer userID, String userName, String userPW, String userRole,
              String userEmail) {
    this.userID = userID;
    this.userName = userName;
    this.userPW = userPW;
    this.userRole = userRole;
    this.userEmail = userEmail;
    this.userBio = "";
    this.userPicUrl = "";
  }

  public User () {}

}
