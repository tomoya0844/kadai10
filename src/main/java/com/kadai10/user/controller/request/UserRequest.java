package com.kadai10.user.controller.request;

public class UserRequest {
    private String name;
    private String occupation;

    public UserRequest(String name, String occupation) {
        this.name = name;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }
}
