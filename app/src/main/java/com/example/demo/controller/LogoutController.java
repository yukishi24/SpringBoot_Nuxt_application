package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * ログアウト画面に遷移する時の処理を統括するコントローラー
 * 
 * @author yukishi
 *
 */
@Controller
@Slf4j
public class LogoutController {

	/**
	 * ログイン画面にリダイレクト
	 * 
	 * @return　login.ttml
	 */
	@PostMapping("/logout")
	public String postLogout() {
		log.info("ログアウト");
		return "redirect:/login";
	}
}
