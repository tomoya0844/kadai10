package com.kadai10.user.controller;

import com.kadai10.user.entity.User;
import com.kadai10.user.excepention.UserNotFoundException;
import com.kadai10.user.request.UserRequest;
import com.kadai10.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int id) {
        try {
            return userService.findUser(id);
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/users")
    public User insert(@RequestBody UserRequest userRequest) {
        return userService.insert(userRequest.getName(), userRequest.getOccupation());
    }
}