package com.example.demo.domain.user.service;

import com.example.demo.domain.user.model.MUser;

public interface UserService {

	/**
	 * ユーザー登録処理
	 * 
	 * @param user	mysqlのmusertableのマッピング
	 */
	public void signup(MUser user);
}
