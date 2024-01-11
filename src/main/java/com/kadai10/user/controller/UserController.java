package com.kadai10.user.controller;

import com.kadai10.user.controller.request.UserRequest;
import com.kadai10.user.controller.request.UserUpdateRequest;
import com.kadai10.user.controller.response.UserResponse;
import com.kadai10.user.entity.User;
import com.kadai10.user.service.UserService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * ユーザー関連のHTTPリクエストに対するハンドラーを提供するコントローラークラスです. ユーザー情報の取得、登録、更新、削除などの操作を処理します。
 * エンドポイントを提供し、外部からのユーザー関連の操作を可能にします。
 */
@RestController
public class UserController {

  /**
   * UserServiceのインスタンスを格納するためのフィールド. このサービスはユーザー関連の機能を提供します。
   */
  private final UserService userService;

  /**
   * コントローラのコンストラクタ.
   *
   * @param userService ユーザーサービスのインスタンス
   */
  @Autowired
  public UserController(final UserService userService) {
    this.userService = userService;
  }

  /**
   * 全てのユーザー情報を取得するメソッド.
   *
   * @return 全てのユーザー情報のリスト
   */
  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userService.findUsers();
  }


  /**
   * idによるユーザー情報を取得するメソッド.
   *
   * @param id ユーザーidのインスタンス.
   * @return idによるユーザー情報の取得
   */
  @GetMapping("/users/{id}")
  public User getUser(final @PathVariable("id") int id) {
    return userService.findUser(id);
  }

  /**
   * 新しいユーザーを登録するメソッド.
   *
   * @param userRequest ユーザー登録に使用されるリクエストオブジェクト
   * @param uriBuilder  レスポンスヘッダーに含まれるLocation URI を構築するための UriComponentsBuilder
   * @return HTTP 201 Created ステータスでレスポンスされるユーザー情報
   */
  @PostMapping("/users")
  public ResponseEntity<UserResponse> insert(final @RequestBody @Valid UserRequest userRequest,
      final UriComponentsBuilder uriBuilder) {
    User user = userService.insert(userRequest.name(), userRequest.occupation());
    URI location = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
    UserResponse body = new UserResponse(user.getName() + "を登録しました");
    return ResponseEntity.created(location).body(body);

  }

  /**
   * ユーザー情報を更新するメソッド.
   *
   * @param id            更新対象のユーザーID
   * @param updateRequest ユーザー情報の更新に使用されるリクエストオブジェクト
   * @param uriBuilder    レスポンスヘッダーに含まれるLocation URI を構築するための UriComponentsBuilder
   * @return HTTP 201 Created ステータスでレスポンスされるユーザー情報
   */
  @PatchMapping("/users/{id}")
  public ResponseEntity<UserResponse> updateUser(final @PathVariable @Valid Integer id,
      final @RequestBody UserUpdateRequest updateRequest, final UriComponentsBuilder uriBuilder) {
    User user = userService.updateUser(id, updateRequest);
    URI location = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
    UserResponse body = new UserResponse(user.getName() + "を更新しました");
    return ResponseEntity.created(location).body(body);
  }

  /**
   * ユーザー情報を削除するメソッド.
   *
   * @param id 削除対象のユーザーID
   * @return HTTP 200 OK ステータスでレスポンスされるユーザー情報
   */
  @DeleteMapping("/users/delete/{id}")
  public ResponseEntity<UserResponse> deleteUser(final @PathVariable @Valid Integer id) {
    User user = userService.deleteUser(id);
    UserResponse response = new UserResponse(user.getName() + "を削除しました");
    return ResponseEntity.ok(response);
  }
}
