package com.kadai10.user.excepention;

/**
 * ユーザーが既に存在する場合にスローされる例外クラスです. ユーザーが特定の条件を満たさない場合や、IDに対応するユーザーが存在する場合に使用されます。
 */

public class UserAlreadyExistsException extends RuntimeException {

  /**
   * ユーザーが既に存在する場合にスローされる例外クラス. この例外は、指定されたユーザーがデータベースやリポジトリで見つかった場合にスローされます
   *
   * @param message 例外メッセージ
   */
  public UserAlreadyExistsException(final String message) {
    super(message);
  }
}
