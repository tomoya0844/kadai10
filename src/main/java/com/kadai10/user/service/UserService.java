package com.kadai10.user.service;

import com.kadai10.user.controller.request.UserUpdateRequest;
import com.kadai10.user.entity.User;
import com.kadai10.user.exception.OccupationAlreadyExistsException;
import com.kadai10.user.exception.UserNotFoundException;
import com.kadai10.user.mapper.UserMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * システム内のユーザーサービスを提供するクラスです. ユーザー関連の操作や処理を担当し、データベースからユーザー情報を取得・管理します。
 */
@Service
public class UserService {

  /**
   * ユーザーマッパーへの参照を保持するためのフィールド.
   */
  private final UserMapper userMapper;

  /**
   * UserServiceのコンストラクタ.
   *
   * @param userMapper ユーザーマッパーへの参照
   */
  public UserService(final UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  /**
   * 全てのユーザー情報を取得するメソッド.
   *
   * @return ユーザー情報のリスト
   */
  public List<User> findUsers() {
    return userMapper.findAll();

  }

  /**
   * 指定されたIDに対応するユーザー情報を取得するメソッド.
   *
   * @param id 取得したいユーザーのID
   * @return 指定されたIDに対応するユーザー情報
   * @throws UserNotFoundException 指定されたIDに対応するユーザーが見つからない場合
   */
  public User findUser(final Integer id) {
    Optional<User> user = this.userMapper.findById(id);
    if (user.isPresent()) {
      return user.get();
    } else {
      throw new UserNotFoundException("userID:" + id + "not found");
    }
  }

  /**
   * 新しいユーザーを登録するメソッド.
   *
   * @param name       登録するユーザーの名前
   * @param occupation 登録するユーザーの職業
   * @return 登録されたユーザー情報
   * @throws OccupationAlreadyExistsException 登録する職業が重複する場合
   */
  public User insert(final String name, final String occupation) {
    User user = User.createUser(name, occupation);
    if (userMapper.findByOccupation(occupation).isPresent()) {
      throw new OccupationAlreadyExistsException(
          "userOccupation:" + occupation + " already exists");
    }
    userMapper.insert(user);
    return user;
  }


  /**
   * ユーザー情報を更新するメソッド.
   *
   * @param id 更新するユーザーのID
   * @return 更新されたユーザー情報
   * @throws UserNotFoundException            指定されたIDのユーザーが見つからない場合
   * @throws OccupationAlreadyExistsException 職業が重複する場合
   */
  public User updateUser(final Integer id, UserUpdateRequest updateRequest) {
    try {
      User user = userMapper.findById(id)
          .orElseThrow(() -> new UserNotFoundException("userID:" + id + "not fond"));
      if (updateRequest.getName() != null) {
        user.setName(updateRequest.getName());
      }
      if (updateRequest.getOccupation() != null) {
        user.setOccupation(updateRequest.getOccupation());
      }
      userMapper.updateUser(user);
      return user;
    } catch (OccupationAlreadyExistsException e) {
      throw new OccupationAlreadyExistsException("職業が重複している");
    }
  }

  /**
   * ユーザー情報を削除するメソッド.
   *
   * @param id 削除するユーザーのID
   * @return 削除されたユーザー情報
   * @throws UserNotFoundException 指定されたIDのユーザーが見つからない場合
   */
  public User deleteUser(final Integer id) {
    User user = userMapper.findById(id)
        .orElseThrow(() -> new UserNotFoundException("userID:" + id + " not found"));
    userMapper.deleteUser(id);
    return user;
  }
}
