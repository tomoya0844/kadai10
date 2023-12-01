package com.kadai10.user.entity;

public class User {
    private Integer id;
    private String name;
    private String occupation;

    public User(Integer id, String name, String occupation) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
    }

    public static User createUser(String name, String occupation) {
        return new User(null, name, occupation);
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

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}

