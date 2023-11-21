package com.kadai10.user.service;

import com.kadai10.user.entity.User;
import com.kadai10.user.excepention.UserNotFoundException;
import com.kadai10.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

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

    public User findUser(int id) {
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

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public User findById(int id) {
        return findUser(id);
    }
}