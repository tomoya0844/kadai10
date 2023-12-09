package com.kadai10.user.controller.response;

/**
 * UserResponse クラスは、ユーザーのレスポンスを表現するためのクラスです.
 */
public class UserResponse {

  /**
   * メッセージを保持するプライベート変数です.
   */
  private final String message;

  /**
   * ユーザーレスポンスを作成するためのコンストラクタです.
   *
   * @param message メッセージ
   */
  public UserResponse(final String message) {
    this.message = message;
  }

  /**
   * メッセージを取得します.
   *
   * @return メッセージ
   */

  public String getMessage() {
    return message;
  }
}

