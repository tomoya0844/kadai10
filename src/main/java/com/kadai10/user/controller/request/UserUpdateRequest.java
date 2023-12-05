package com.kadai10.user.controller.request;


public class UserUpdateRequest {
    /**
     * 静的な名前を表すクラス変数.
     * この変数はすべてのインスタンスで共有され、クラスから直接アクセス可能
     */
    private static String name;
    /**
     * 静的な職業を表すクラス変数.
     * この変数はすべてのインスタンスで共有され、クラスから直接アクセス可能
     */

    private static String occupation;

    /**
     * ユーザー情報を更新するためのリクエストオブジェクト.
     *
     * @param name       ユーザーの新しい名前
     * @param occupation ユーザーの新しい職業
     */
    public UserUpdateRequest(final String name, final String occupation) {
        this.name = name;
        this.occupation = occupation;
    }

    /**
     * ユーザーの名前を設定するメソッド.
     *
     * @param name ユーザーの新しい名前
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * ユーザーの職業を設定するメソッド.
     *
     * @param occupation ユーザーの新しい職業
     */

    public void setOccupation(final String occupation) {
        this.occupation = occupation;
    }

    /**
     * ユーザーの名前を取得するメソッド.
     *
     * @return ユーザーの現在の名前
     */
    public static String getName() {
        return name;
    }

    /**
     * ユーザーの職業を取得するメソッド.
     *
     * @return ユーザーの現在の職業
     */

    public static String getOccupation() {
        return occupation;
    }
}
