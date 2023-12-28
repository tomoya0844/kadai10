package com.kadai10.user.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import com.kadai10.user.entity.User;
import com.kadai10.user.mapper.UserMapper;
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
    doReturn(Optional.of(new User(1, "yoshihito koyama", "java講師"))).when(userMapper).findById(1);
    User actual = userService.findUser(1);
    assertThat(actual).isEqualTo(new User(1, "yoshihito koyama", "java講師"));
    verify(userMapper).findById(1);
  }
}
