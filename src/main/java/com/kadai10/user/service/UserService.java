package com.kadai10.user.service;


import com.kadai10.user.controller.request.UserDeleteRequest;
import com.kadai10.user.controller.request.UserUpdateRequest;
import com.kadai10.user.entity.User;
import com.kadai10.user.excepention.UserNotFoundException;
import com.kadai10.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserMapper userMapper;
    private UserDeleteRequest dUserDelete;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> findUsers() {
        return userMapper.findAll();

    }

    public User findUser(Integer id) {
        Optional<User> user = this.userMapper.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else throw new UserNotFoundException("userID:" + id + "not found");
    }


    public User insert(String name, String occupation) {
        User user = User.createUser(name, occupation);
        userMapper.insert(user);
        return user;
    }

    public User updateUser(Integer id, String name, String occupation) {
        User user = userMapper.findById(id).orElseThrow(() -> new UserNotFoundException("userID:" + id + " not found"));
        if (UserUpdateRequest.getName() != null) {
            user.setName(UserUpdateRequest.getName());
        }
        if (UserUpdateRequest.getOccupation() != null) {
            user.setOccupation(UserUpdateRequest.getOccupation());
        }
        userMapper.updateUser(user);
        return user;
    }

    public User deleteUser(Integer id) {
        User user = userMapper.findById(id).orElseThrow(() -> new UserNotFoundException("userID:" + id + " not found"));
        userMapper.deleteUser(user);
        return user;
    }
}
