package com.kadai10.user.controller.request;

/**
 * ユーザー情報のリクエストを表すクラスです. このクラスは新しいユーザーの作成や既存のユーザー情報の更新などの要求を受け取ります。
 *
 * @param name       ユーザーの名前を表すフィールド.
 * @param occupation ユーザーの職業を表すフィールド.
 */

public record UserRequest(String name, String occupation) {

  /**
   * UserRequest オブジェクトを生成するためのコンストラクタ.
   *
   * @param name       ユーザーの名前
   * @param occupation ユーザーの職業
   */
  public UserRequest {
  }
}
