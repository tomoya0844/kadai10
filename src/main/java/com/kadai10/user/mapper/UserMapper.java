package com.kadai10.user.mapper;

import com.kadai10.user.entity.User;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * ユーザーエンティティとデータベースの間でデータの変換を担当するマッパーインターフェースです. ユーザーエンティティのデータベースへの保存や、データベースからの取得などの操作が含まれます。
 */
@Mapper
public interface UserMapper {

  /**
   * ユーザを全て取得する.
   *
   * @return 全てのユーザーのリスト
   */
  @Select("SELECT * FROM users")
  List<User> findAll();

  /**
   * 指定されたIDに対応するユーザーを取得する.
   *
   * @param id 取得したいユーザーのid
   * @return 指定されたIDに対応するユーザーを返す。存在しない場合は空のOptionalを返す。
   */
  @Select("SELECT * FROM users WHERE id = #{id}")
  Optional<User> findById(int id);

  /**
   * 指定された名前に対応するユーザーを取得する.
   *
   * @param name 取得したいユーザーの名前
   * @return 指定された名前に対応するユーザーを返す。存在しない場合はからのOptionalを返す。
   */
  @Select("SELECT * FROM users WHERE name = #{name}")
  boolean findByName(String name);


  /**
   * 指定された職業に対応するユーザーを取得する.
   *
   * @param occupation 取得したいユーザーの職業
   * @return 指定された職業に対応するユーザーを返す。存在しない場合は空のOptionalを返す。
   */
  @Select("SELECT * FROM users WHERE occupation = #{occupation}")
  Optional<User> findByOccupation(String occupation);


  /**
   * ユーザーをデータベースに登録.
   *
   * @param user 登録するユーザーオブジェクト
   */
  @Insert("INSERT INTO users (name, occupation) VALUES (#{name}, #{occupation})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(User user);


  /**
   * データベースのユーザー情報を更新.
   *
   * @param user 更新するユーザーオブジェクト
   */
  @Update("UPDATE users SET name = #{name}, occupation = #{occupation} WHERE id = #{id}")
  void updateUser(User user);

  /**
   * データベースのユーザーを削除.
   *
   * @param id 削除するユーザーのid
   */
  @Delete("DELETE FROM users WHERE id = #{id}")
  void deleteUser(int id);
}
