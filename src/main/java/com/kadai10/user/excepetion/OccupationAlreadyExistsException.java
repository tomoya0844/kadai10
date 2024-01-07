package com.kadai10.user.excepetion;

/**
 * 職業が既に存在する場合にスローされる例外クラスです. ユーザーが特定の条件を満たさない場合や、IDに対応するユーザーが存在する場合に使用されます。
 */
public class OccupationAlreadyExistsException extends RuntimeException {

  /**
   * 職業が既に存在する場合にスローされる例外クラス. この例外は、指定された職業がデータベースやリポジトリで見つかった場合にスローされます
   *
   * @param message 例外メッセージ
   */
  public OccupationAlreadyExistsException(final String message) {
    super(message);
  }
}
