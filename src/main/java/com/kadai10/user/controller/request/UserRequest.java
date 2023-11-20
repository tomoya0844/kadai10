package com.kadai10.user.controller.request;

import jakarta.validation.constraints.NotNull;

public class UserRequest {
    @NotNull(message = "入力してください")
    private String name;
    @NotNull(message = "入力してください")
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
