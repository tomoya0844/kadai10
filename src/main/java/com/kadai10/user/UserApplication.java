package com.kadai10.user;

import org.springframework.boot.SpringApplication;

/**
 * ユーザーアプリケーションのエントリーポイントとなるクラスです. アプリケーション全体の初期化や実行フローの制御を担当します。
 */
public class UserApplication {

  /**
   * アプリケーションのエントリーポイント。Spring Bootアプリケーションを起動するためのメインメソッド.
   *
   * @param args 起動時に受け取るコマンドライン引数
   */
  public static void main(final String[] args) {
    SpringApplication.run(UserApplication.class, args);
  }
}
