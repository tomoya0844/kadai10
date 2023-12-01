package com.kadai10.user.controller.request;

public class UserDeleteRequest {
    private Integer id;
    private static String name;
    private static String occupation;

    public UserDeleteRequest(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getId() {
        return id;
    }

    public static String getName() {
        return name;
    }

    public static String getOccupation() {
        return occupation;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
