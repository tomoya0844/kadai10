package com.kadai10.user.mapper;

import com.kadai10.user.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> findAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    Optional<User> findById(int id);

    @Select("SELECT * FROM users WHERE occupation = #{occupation}")
    Optional<User> findByOccupation(String occupation);

    @Insert("INSERT INTO users (name, occupation) VALUES (#{name}, #{occupation})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Update("UPDATE users SET name = #{name}, occupation = #{occupation} WHERE id = #{id}")
    void updateUser(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUser(User id);
}