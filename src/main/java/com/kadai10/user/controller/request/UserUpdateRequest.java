package com.kadai10.user.controller.request;

import lombok.Getter;

/**
 * ユーザー情報の更新リクエストを表すクラスです. このクラスはユーザーの名前や職業などの更新が必要な情報を受け取ります。 ユーザー情報を更新する際に使用されます。
 */

public class UserUpdateRequest {

  /**
   * 静的な名前を表すクラス変数. この変数はすべてのインスタンスで共有され、クラスから直接アクセス可能 -- GETTER -- ユーザーの名前を取得するメソッド.
   */
  @Getter
  private static String name;
  /**
   * 静的な職業を表すクラス変数. この変数はすべてのインスタンスで共有され、クラスから直接アクセス可能 -- GETTER -- ユーザーの職業を取得するメソッド.
   */
  @Getter
  private static String occupation;

  /**
   * ユーザー情報を更新するためのリクエストオブジェクト.
   *
   * @param newName       ユーザーの新しい名前
   * @param newOccupation ユーザーの新しい職業
   */
  public UserUpdateRequest(String newName, String newOccupation) {

    name = newName;
    occupation = newOccupation;
  }

  /**
   * ユーザーの名前を設定するメソッド.
   *
   * @param newName ユーザーの新しい名前
   */
  public void setName(String newName) {
    name = newName;
  }

  /**
   * ユーザーの職業を設定するメソッド.
   *
   * @param newOccupation ユーザーの新しい職業
   */

  public void setOccupation(String newOccupation) {
    occupation = newOccupation;
  }
}
