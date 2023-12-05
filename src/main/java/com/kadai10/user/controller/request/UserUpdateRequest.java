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
     * @param newName       ユーザーの新しい名前
     * @param newOccupation ユーザーの新しい職業
     */
    public UserUpdateRequest(final String newName, final String newOccupation) {

        name = newName;
        occupation = newOccupation;
    }

    /**
     * ユーザーの名前を設定するメソッド.
     *
     * @param newName ユーザーの新しい名前
     */
    public void setName(final String newName) {
        name = newName;
    }

    /**
     * ユーザーの職業を設定するメソッド.
     *
     * @param newOccupation ユーザーの新しい職業
     */

    public void setOccupation(final String newOccupation) {
        occupation = newOccupation;
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
