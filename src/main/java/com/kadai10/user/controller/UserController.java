package com.kadai10.user.controller;

import com.kadai10.user.UserUpdateRequest;
import com.kadai10.user.controller.request.UserRequest;
import com.kadai10.user.controller.response.UserResponse;
import com.kadai10.user.entity.User;
import com.kadai10.user.excepention.UserNotFoundException;
import com.kadai10.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findUsers();
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
    public ResponseEntity<UserResponse> insert(@RequestBody @Valid UserRequest userRequest, UriComponentsBuilder uriBuilder) {
        User user = userService.insert(userRequest.getName(), userRequest.getOccupation());
        URI location = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        UserResponse body = new UserResponse(user.getName() + "を登録しました");
        return ResponseEntity.created(location).body(body);

    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody UserUpdateRequest updateRequest) {
        User user = userService.findById(id);
        userService.updateUser(user);
        return ResponseEntity.ok("更新しました");
    }
}
