package com.kadai10.user.controller.request;

import lombok.Getter;
import lombok.Setter;

/**
 * ユーザー情報の更新リクエストを表すクラスです. このクラスはユーザーの名前や職業などの更新が必要な情報を受け取ります。 ユーザー情報を更新する際に使用されます。
 */
@Setter
@Getter
public class UserUpdateRequest {

  /**
   * 静的な職業を表すクラス変数. この変数はすべてのインスタンスで共有され、クラスから直接アクセス可能 -- GETTER -- ユーザーの職業を取得するメソッド. -- SETTER
   * --ユーザーの職業を設定するメソッド.
   */
  private String occupation;
  /**
   * 静的な名前を表すクラス変数. この変数はすべてのインスタンスで共有され、クラスから直接アクセス可能 -- GETTER -- ユーザーの名前を取得するメソッド. -- SETTER
   * --ユーザーの名前を設定するメソッド.
   */
  private String name;

  /**
   * ユーザー情報を更新するためのリクエストオブジェクト.
   *
   * @param name       ユーザーの新しい名前
   * @param occupation ユーザーの新しい職業
   */
  public UserUpdateRequest(String name, String occupation) {
    this.name = name;
    this.occupation = occupation;
  }
}
