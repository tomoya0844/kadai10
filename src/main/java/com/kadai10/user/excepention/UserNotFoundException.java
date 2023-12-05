package com.kadai10.user.excepention;

public class UserNotFoundException extends RuntimeException {
    /**
     * ユーザーが見つからない場合にスローされる例外クラス.
     * この例外は、指定されたユーザーがデータベースやリポジトリで見つからない場合にスローされます
     *
     * @param message 例外メッセージ
     */
    public UserNotFoundException(final String message) {
        super(message);
    }
}
