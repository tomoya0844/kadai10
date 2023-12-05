package com.kadai10.user.controller.request;

public class UserRequest {
    /**
     * ユーザーの名前を表すフィールド.
     */
    private String name;
    /**
     * ユーザーの職業を表すフィールド.
     */
    private String occupation;

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

    /**
     * ユーザーの名前を取得する.
     *
     * @return ユーザーの名前
     */
    public String getName() {
        return name;
    }

    /**
     * ユーザーの職業を取得する.
     *
     * @return ユーザーの職業
     */
    public String getOccupation() {
        return occupation;
    }
}
