/**
 * 
 */
package com.example.demo.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 画面の入力内容とマッピングするフォームクラス
 * 
 * @author yukishi
 *
 */

/**
 * 新規ユーザー登録画面用のバインドレコード
 * @author yukishi
 *
 */
public record SignupForm(
    String userId,
    String password,
    String userName,
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    Date birthday,
    Integer age,
    Integer gender
    ) {

}