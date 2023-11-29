package com.kadai10.user.service;


import com.kadai10.user.UserUpdateRequest;
import com.kadai10.user.entity.User;
import com.kadai10.user.excepention.UserNotFoundException;
import com.kadai10.user.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserMapper userMapper;

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
        User user = User.updateUser(id, name, occupation);
        userMapper.updateUser(user);
        return user;
    }

    public Integer findById(Integer id, UserUpdateRequest updateRequest) throws MethodArgumentNotValidException {
        User foundUser = userMapper.findById(id).orElseThrow(() -> new UserNotFoundException("userID:" + id + " not found"));
        if (updateRequest.getName() != null) {
            foundUser.setName(updateRequest.getName());
        }
        if (updateRequest.getOccupation() != null) {
            foundUser.setOccupation(updateRequest.getOccupation());
        }

        userMapper.updateUser(foundUser);
        return foundUser.getId();
    }
}