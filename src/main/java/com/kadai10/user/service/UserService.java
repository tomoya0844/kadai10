package com.kadai10.user.service;

import com.kadai10.user.UserUpdateRequest;
import com.kadai10.user.entity.User;
import com.kadai10.user.excepention.UserNotFoundException;
import com.kadai10.user.mapper.UserMapper;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
        Optional<User> user = userMapper.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else throw new UserNotFoundException("指定されたユーザーIDが存在しません。");
    }

    public User findById(int id) {
        return findUser(id);
    }
    public void updateUser(Integer id, UserUpdateRequest updateRequest) throws MethodArgumentNotValidException {
        if (id == null && updateRequest.getName() == null && updateRequest.getOccupation() == null) {
            throw new MethodArgumentNotValidException((MethodParameter) null, createBindingResult("ID、名前、職業のいずれかが指定されていません。"));
        }

        User user = findById(id);

        if (updateRequest.getName() != null) {
            user.setName(updateRequest.getName());
        }

        if (updateRequest.getOccupation() != null) {
            user.setOccupation(updateRequest.getOccupation());
        }

        userMapper.update(user);
    }
}
