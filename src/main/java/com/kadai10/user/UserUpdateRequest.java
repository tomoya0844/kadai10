package com.kadai10.user;


public class UserUpdateRequest {

  String name;

  String occupation;

  public UserUpdateRequest(String name, String occupation) {
    this.name = name;
    this.occupation = occupation;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getName() {
    return name;
  }

  public String getOccupation() {
    return occupation;
  }
}
