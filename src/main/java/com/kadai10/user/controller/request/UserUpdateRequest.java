package com.kadai10.user.controller.request;


public class UserUpdateRequest {

    static String name;

    static String occupation;

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

    public static String getName() {
        return name;
    }

    public static String getOccupation() {
        return occupation;
    }
}