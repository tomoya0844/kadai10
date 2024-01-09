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
   * 静的な名前を表すクラス変数. この変数はすべてのインスタンスで共有され、クラスから直接アクセス可能 -- GETTER -- ユーザーの名前を取得するメソッド. -- SETTER
   * --ユーザーの名前を設定するメソッド.
   */
  @Getter
  private static String name;
  /**
   * 静的な職業を表すクラス変数. この変数はすべてのインスタンスで共有され、クラスから直接アクセス可能 -- GETTER -- ユーザーの職業を取得するメソッド. -- SETTER
   * --ユーザーの職業を設定するメソッド.
   */
  @Getter
  private static String occupation;

  /**
   * ユーザー情報を更新するためのリクエストオブジェクト.
   *
   * @param name       ユーザーの新しい名前
   * @param occupation ユーザーの新しい職業
   */
  public UserUpdateRequest(String name, String occupation) {
    UserUpdateRequest.name = name;
    UserUpdateRequest.occupation = occupation;
  }

  /**
   * ユーザーの名前を設定するための静的メソッド.
   *
   * @param name ユーザーの新しい名前
   */
  public static void setName(String name) {
    UserUpdateRequest.name = name;
  }

  /**
   * ユーザーの職業を設定するための静的メソッド.
   *
   * @param occupation ユーザーの新しい職業
   */
  public static void setOccupation(String occupation) {
    UserUpdateRequest.occupation = occupation;
  }
}
