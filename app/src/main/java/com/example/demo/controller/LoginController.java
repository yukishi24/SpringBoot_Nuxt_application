package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ログイン画面の制御を行うコントローラー
 * @author yukishi
 *
 */
@Controller
public class LoginController {
	/**
	 * ログイン画面に遷移
	 * @return　htmlファイルパス(/login/login.html)
	 */
	@GetMapping("/login")
	public String getLogin() {
		return "/login/login";
	}

	/**
	 * ユーザー一覧画面にリダイレクト
	 * @return htmlファイルパス(user/list.html)
	 */
	@PostMapping("/login")
	public String postLogin() {
		return "redirect:/user/list";
	}
}
