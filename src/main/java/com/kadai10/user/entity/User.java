package com.kadai10.user.entity;

import java.util.Objects;

/**
 * アプリケーション内で扱うユーザー情報を表現するクラスです. ユーザーの識別子、名前、メールアドレスなどの属性が含まれます。
 */
public class User {

  /**
   * ユーザーの一意の識別子（ID）を表すフィールド.
   */
  private final Integer id;
  /**
   * ユーザーの一意の識別子（名前）を表すフィールド.
   */
  private String name;

  /**
   * ユーザーの一意の識別子(職業）を表すフィールド.
   */
  private String occupation;

  /**
   * ユーザーオブジェクトのコンストラクタ.
   *
   * @param id         ユーザーの一意の識別子
   * @param name       ユーザーの名前
   * @param occupation ユーザーの職業
   */
  public User(final Integer id, final String name, final String occupation) {
    this.id = id;
    this.name = name;
    this.occupation = occupation;
  }

  /**
   * 指定された名前と職業から新しいユーザーオブジェクトを作成する静的メソッド.
   *
   * @param name       ユーザーの名前
   * @param occupation ユーザーの職業
   * @return 新しいユーザーオブジェクト
   */
  public static User createUser(final String name, final String occupation) {
    return new User(null, name, occupation);
  }

  /**
   * ユーザーの一意の識別子である ID を取得します.
   *
   * @return ユーザーの ID
   */
  public Integer getId() {
    return id;
  }

  /**
   * ユーザーの名前を取得します.
   *
   * @return ユーザーの名前
   */
  public String getName() {
    return name;
  }

  /**
   * ユーザーの名前を設定するメソッド.
   *
   * @param name 設定するユーザーの名前
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * ユーザーの職業を取得するメソッド. このメソッドは現在のコードベースで使用されていません
   *
   * @return ユーザーの職業
   */
  public String getOccupation() {
    return occupation;
  }

  /**
   * ユーザーの職業を設置するメソッド.
   *
   * @param occupation 設定するユーザーの職業
   */
  public void setOccupation(final String occupation) {
    this.occupation = occupation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(name, user.name)
        && Objects.equals(occupation, user.occupation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, occupation);
  }
}
