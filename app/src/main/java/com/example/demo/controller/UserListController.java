package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ユーザー詳細へ遷移する時の処理を統括するController.java
 * @author yukishi
 *
 */
@Controller
@RequestMapping("/user")
public class UserListController {

	/**
	 * ユーザー知覧画面を表示
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public String getUserList() {
		return "user/list";
	}
}
