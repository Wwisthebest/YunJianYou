package com.groupthree.yunjianyou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ss_admin")
public class AdminUser {

  @Id
  private String aId;
  private String aName;
  private String aPassword;
  private String aUsername;
  private Integer aState;


  public String getAId() {
    return aId;
  }

  public void setAId(String aId) {
    this.aId = aId;
  }


  public String getAName() {
    return aName;
  }

  public void setAName(String aName) {
    this.aName = aName;
  }


  public String getAPassword() {
    return aPassword;
  }

  public void setAPassword(String aPassword) {
    this.aPassword = aPassword;
  }


  public String getAUsername() {
    return aUsername;
  }

  public void setAUsername(String aUsername) {
    this.aUsername = aUsername;
  }


  public Integer getAState() {
    return aState;
  }

  public void setAState(Integer aState) {
    this.aState = aState;
  }
}
