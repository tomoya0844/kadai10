package com.kadai10.user.controller;

import com.kadai10.user.excepention.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.ZonedDateTime;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * アプリケーション内で発生する例外に対する処理を提供する. ControllerAdvice として機能するクラスです。
 * 例外処理、エラーハンドリング、および異常状態のレスポンス生成などを行います。
 */
public class UserControllerAdvice {

  /**
   * ユーザーが見つからない場合の例外ハンドリングメソッド.
   *
   * @param e       ユーザーが見つからない例外
   * @param request HTTPリクエスト
   * @return エラーレスポンス
   */
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<Map<String, String>> handleUserNotFoundException(
      final UserNotFoundException e, final @NotNull HttpServletRequest request) {
    Map<String, String> body = Map.of(
        "timestamp", ZonedDateTime.now().toString(),
        "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
        "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
        "message", "指定されたユーザーが見つかりません",
        "path", request.getRequestURI());
    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  /**
   * 入力が不足している場合の例外ハンドリングメソッド.
   *
   * @param e       入力が不足している例外
   * @param request HTTPリクエスト
   * @return エラーレスポンス
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
      final MethodArgumentNotValidException e, final HttpServletRequest request) {
    Map<String, String> body = Map.of(
        "timestamp", ZonedDateTime.now().toString(),
        "status", String.valueOf(HttpStatus.BAD_REQUEST.value()),
        "error", HttpStatus.BAD_REQUEST.getReasonPhrase(),
        "message", "リクエストが不完全です。すべての必須フィールドに値を入力してください。",
        "path", request.getRequestURI());
    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }

  /**
   * 重複したデータが見つかった場合の例外ハンドリングメソッド.
   *
   * @param e       重複したデータが見つかった例外
   * @param request HTTPリクエスト
   * @return エラーレスポンス
   */
  @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
  @ExceptionHandler(SqlIntegrityConstraintViolationException.class)
  public ResponseEntity<Map<String, String>> handleSqlIntegrityConstraintViolationException(
      final SqlIntegrityConstraintViolationException e, final HttpServletRequest request) {
    Map<String, String> body = Map.of(
        "timestamp", ZonedDateTime.now().toString(),
        "status", String.valueOf(HttpStatus.CONFLICT.value()),
        "error", HttpStatus.CONFLICT.getReasonPhrase(),
        "message", e.getMessage() + "データが既に存在しています。新しいデータを追加できません。",
        "path", request.getRequestURI());
    return new ResponseEntity<>(body, HttpStatus.CONFLICT);
  }
}
