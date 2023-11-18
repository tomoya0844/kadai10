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

    public static User createUser(String name, String email) {
        return new User(null, name, email);
    }

    public int getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public String getOccupation() {
        return occupation;
    }
}
