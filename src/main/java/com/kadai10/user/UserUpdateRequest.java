package com.kadai10.user;


public class UserUpdateRequest {
    Integer id;

    String name;

    String occupation;

    public UserUpdateRequest(Integer id, String name, String occupation) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public String getOccupation() {

        return occupation;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

}