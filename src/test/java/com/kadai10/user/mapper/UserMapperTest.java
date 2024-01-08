package com.kadai10.user.mapper;


import static org.assertj.core.api.Assertions.assertThat;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.kadai10.user.entity.User;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {

  @Autowired
  UserMapper userMapper;

  @Test
  @DataSet(value = "datasets/users.yml")
  @Transactional
  void すべてのユーザーが取得できること() {
    List<User> users = userMapper.findAll();
    assertThat(users)
        .hasSize(3)
        .contains(
            new User(1, "小山", "警察官"),
            new User(2, "北野", "介護士"),
            new User(3, "田中", "看護師"));
  }

  @Test
  @DataSet(value = "datasets/users.yml")
  @Transactional
  void 存在するユーザーのIDを指定した時に正常にユーザーが返されること() {
    Optional<User> users = userMapper.findById(3);
    assertThat(users)
        .contains(new User(3, "田中", "看護師"));
  }

  @Test
  @DataSet(value = "datasets/users.yml")
  @Transactional
  void 存在しないユーザーのIDを指定した時に空の情報が返されること() {
    Optional<User> users = userMapper.findById(39);
    assertThat(users).isEmpty();
  }

  @Test
  @DataSet(value = "datasets/users.yml")
  @Transactional
  void 存在するユーザーの職業を指定した時に正常にユーザーが返されること() {
    Optional<User> users = userMapper.findByOccupation("介護士");
    assertThat(users)
        .contains(new User(2, "北野", "介護士"));
  }

  @Test
  @DataSet(value = "datasets/users.yml")
  @Transactional
  void 存在しないユーザーの職業を指定した時に空の情報が返されること() {
    Optional<User> users = userMapper.findByOccupation("農家");
    assertThat(users).isEmpty();
  }

  @Test
  @DataSet(value = "datasets/users.yml")
  @Transactional
  public void 正常に新規のユーザーが登録できること() {
    User user = new User(null, "山田", "建築士");
    userMapper.insert(user);
    List<User> users = userMapper.findAll();
    assertThat(users).hasSize(4)
        .contains(
            new User(1, "小山", "警察官"),
            new User(2, "北野", "介護士"),
            new User(3, "田中", "看護師"),
            user
        );
  }
}
