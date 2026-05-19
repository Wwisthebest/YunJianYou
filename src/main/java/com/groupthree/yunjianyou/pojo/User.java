package com.groupthree.yunjianyou.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name="ss_user")
public class User {

  @Id
  @Column(name = "u_id")
  private Integer id;
  @Column(name = "u_name")
  private String uName;
  @Column(name = "u_nick_name")
  private String uNickName;
  @Column(name = "u_id_num")
  private String uIdNum;
  @Column(name = "phone")
  private String phone;
  @Column(name = "email")
  private String email;
  @Column(name = "is_state")
  private String isState;
  @Column(name = "sex")
  private String sex;
  @Column(name = "salt")
  private String salt;
  @Column(name = "u_password")
  private String uPassword;
  @Column(name = "confirm_code")
  private String confirmCode;
  @Column(name = "activate_time")
  private Date activateTime;
  @Column(name = "user_url")
  private String userUrl;
  @Column(name = "user_address")
  private String userAddress;
  @Column(name = "face_photo")
  private String facePhoto;

  public User() {
  }

  public User(Integer id, String uName, String uNickName, String uIdNum, String phone, String email, String isState, String sex, String salt, String uPassword, String confirmCode, Date activateTime, String userUrl, String userAddress, String facePhoto) {
    this.id = id;
    this.uName = uName;
    this.uNickName = uNickName;
    this.uIdNum = uIdNum;
    this.phone = phone;
    this.email = email;
    this.isState = isState;
    this.sex = sex;
    this.salt = salt;
    this.uPassword = uPassword;
    this.confirmCode = confirmCode;
    this.activateTime = activateTime;
    this.userUrl = userUrl;
    this.userAddress = userAddress;
    this.facePhoto = facePhoto;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getuName() {
    return uName;
  }

  public void setuName(String uName) {
    this.uName = uName;
  }

  public String getuNickName() {
    return uNickName;
  }

  public void setuNickName(String uNickName) {
    this.uNickName = uNickName;
  }

  public String getuIdNum() {
    return uIdNum;
  }

  public void setuIdNum(String uIdNum) {
    this.uIdNum = uIdNum;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getIsState() {
    return isState;
  }

  public void setIsState(String isState) {
    this.isState = isState;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getuPassword() {
    return uPassword;
  }

  public void setuPassword(String uPassword) {
    this.uPassword = uPassword;
  }

  public String getConfirmCode() {
    return confirmCode;
  }

  public void setConfirmCode(String confirmCode) {
    this.confirmCode = confirmCode;
  }

  public Date getActivateTime() {
    return activateTime;
  }

  public void setActivateTime(Date activateTime) {
    this.activateTime = activateTime;
  }

  public String getUserUrl() {
    return userUrl;
  }

  public void setUserUrl(String userUrl) {
    this.userUrl = userUrl;
  }

  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }

  public void setDeleteStatus(int i) {
    this.isState = String.valueOf(i);
  }

  public String getFacePhoto() {
    return facePhoto;
  }

  public void setFacePhoto(String facePhoto) {
    this.facePhoto = facePhoto;
  }
}
