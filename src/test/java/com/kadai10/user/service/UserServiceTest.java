package com.kadai10.user.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.kadai10.user.controller.request.UserUpdateRequest;
import com.kadai10.user.entity.User;
import com.kadai10.user.exception.OccupationAlreadyExistsException;
import com.kadai10.user.exception.UserNotFoundException;
import com.kadai10.user.mapper.UserMapper;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

  @InjectMocks
  UserService userService;
  @Mock
  UserMapper userMapper;

  @Test
  public void 存在するユーザーのIDを指定したときに正常にユーザーが返されること() {
    doReturn(Optional.of(new User(2, "北野", "介護士"))).when(userMapper).findById(2);
    User actual = userService.findUser(2);
    assertThat(actual).isEqualTo(new User(2, "北野", "介護士"));
    verify(userMapper).findById(2);
  }

  @Test
  public void 存在するユーザーを全て返されること() {
    List<User> user = List.of(
        new User(1, "小山", "警察官"),
        new User(2, "北野", "介護士"),
        new User(3, "田中", "看護師"));
    doReturn(user).when(userMapper).findAll();
    List<User> actual = userService.findUsers();
    assertThat(actual).isEqualTo(user);
    verify(userMapper).findAll();
  }

  @Test
  public void 存在しないユーザーのIDを指定したときにエラーが返されること() {
    doReturn(Optional.empty()).when(userMapper).findById(8);
    assertThrows(UserNotFoundException.class, () -> {
      userService.findUser(8);
    });
  }

  @Test
  public void 正常に新規のユーザーが登録できること() {
    User user = new User(null, "山田", "建築士");
    doNothing().when(userMapper).insert(user);
    assertThat(userService.insert("山田", "建築士")).isEqualTo(user);
    verify(userMapper).insert(user);
  }

  @Test
  public void すでに存在する職業を再度登録時にエラーが返されること() {
    when(userMapper.findByOccupation("医者")).thenReturn(Optional.of(new User(1, "田中", "医者")));
    assertThrows(OccupationAlreadyExistsException.class, () -> {
      userService.insert("田中", "医者");
    });
  }

  @Test
  public void 存在するユーザーの名前と職業の更新できること() {
    doReturn(Optional.of(new User(2, "北野", "介護士"))).when(userMapper).findById(2);
    User actual = userService.updateUser(2, new UserUpdateRequest("三田", "消防士"));
    User user = new User(2, "三田", "消防士");
    assertThat(actual).isEqualTo(user);
    verify(userMapper).findById(2);
    verify(userMapper).updateUser(user);
  }

  @Test
  public void 存在するユーザーの名前のみ更新できること() {
    doReturn(Optional.of(new User(1, "小山", "警察官"))).when(userMapper).findById(1);
    UserUpdateRequest updateRequest =
        new UserUpdateRequest("小川", null);
    User actual = userService.updateUser(1, updateRequest);
    User user = new User(1, "小川", "警察官");
    assertThat(actual).isEqualTo(user);
    verify(userMapper).findById(1);
    verify(userMapper).updateUser(user);
  }

  @Test
  public void 存在するユーザーの職業のみ更新できること() {
    doReturn(Optional.of(new User(1, "小山", "警察官"))).when(userMapper).findById(1);
    UserUpdateRequest updateRequest = new UserUpdateRequest(null, "警備員");
    User actual = userService.updateUser(1, updateRequest);
    User user = new User(1, "小山", "警備員");
    assertThat(actual).isEqualTo(user);
    verify(userMapper).findById(1);
    verify(userMapper).updateUser(user);
  }

  @Test
  public void すでに存在する職業に更新時にエラーが返されること() {
    when(userMapper.findByOccupation("医者")).thenReturn(Optional.of(new User(1, "田中", "医者")));
    assertThrows(OccupationAlreadyExistsException.class, () -> {
      userService.insert("田中", "医者");
    });
  }

  @Test
  public void 存在するIDを指定して削除できること() {
    doReturn(Optional.of(new User(1, "小山", "警察官"))).when(userMapper).findById(1);
    userService.deleteUser(1);
    verify(userMapper).findById(1);
    verify(userMapper).deleteUser(1);
  }

  @Test
  public void 存在しないIDを指定した時にエラーが返ること() {
    doReturn(Optional.empty()).when(userMapper).findById(100);
    assertThrows(UserNotFoundException.class, () -> {
      userService.deleteUser(100);
    });
    verify(userMapper).findById(100);
  }
}
