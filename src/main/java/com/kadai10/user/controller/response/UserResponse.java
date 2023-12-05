package com.kadai10.user.controller.response;

public class UserResponse {
    /**
     * メッセージを保持するプライベート変数です.
     */
    private String message;

    /**
     * メッセージを取得します.
     *
     * @return メッセージ
     */

    public String getMessage() {
        return message;
    }

    /**
     * ユーザーレスポンスを作成するためのコンストラクタです.
     *
     * @param message メッセージ
     */
    public UserResponse(final String message) {
        this.message = message;
    }
}
