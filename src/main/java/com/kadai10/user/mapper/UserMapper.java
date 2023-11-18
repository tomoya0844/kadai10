package com.kadai10.user.mapper;

import com.kadai10.user.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{id}")
    Optional<User> findById(int id);

    @Insert("INSERT INTO users (name, occupation) VALUES (#{name}, #{occupation})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);
}
