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

import java.util.Collections;
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

    public void updateUser(User user) throws UserNotFoundException {
        userMapper.updateUser(user);
        Optional<User> updatedUser = userMapper.findById(user.getId());
        updatedUser.orElseThrow(() -> new UserNotFoundException("指定されたユーザーIDが存在しません。"));
    }


    public User findById(Integer id, UserUpdateRequest updateRequest) throws MethodArgumentNotValidException {
        if (id == null || (updateRequest.getName() == null && updateRequest.getOccupation() == null)) {
            throw new MethodArgumentNotValidException((MethodParameter) null, createBindingResult("ID、名前、職業のいずれかが指定されていません。"));
        }

        Optional<User> user = userMapper.findById(id);
        if (user.isPresent()) {
            User foundUser = user.get();

            if (updateRequest.getName() != null) {
                foundUser.setName(updateRequest.getName());
            }

            if (updateRequest.getOccupation() != null) {
                foundUser.setOccupation(updateRequest.getOccupation());
            }

            userMapper.updateUser(foundUser);

            return foundUser;
        } else {
            throw new UserNotFoundException("userID:" + id + " not found");
        }
    }

    private BindingResult createBindingResult(String message) {
        BindingResult bindingResult = new BeanPropertyBindingResult(Collections.emptyMap(), "target");
        bindingResult.addError(new FieldError("target", "fieldName", message));
        return bindingResult;
    }
}
