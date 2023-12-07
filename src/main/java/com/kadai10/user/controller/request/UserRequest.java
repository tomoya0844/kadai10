package com.kadai10.user.controller.request;

import lombok.Getter;

/**
 * ユーザー情報のリクエストを表すクラスです. このクラスは新しいユーザーの作成や既存のユーザー情報の更新などの要求を受け取ります。
 */
@Getter
public class UserRequest {

  /**
   * ユーザーの名前を表すフィールド. -- GETTER -- ユーザーの名前を取得する.
   *
   * @return ユーザーの名前
   */
  private final String name;
  /**
   * ユーザーの職業を表すフィールド. -- GETTER -- ユーザーの職業を取得する.
   *
   * @return ユーザーの職業
   */
  private final String occupation;

  /**
   * UserRequest オブジェクトを生成するためのコンストラクタ.
   *
   * @param name       ユーザーの名前
   * @param occupation ユーザーの職業
   */
  public UserRequest(final String name, final String occupation) {
    this.name = name;
    this.occupation = occupation;
  }

}
