package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.user.model.MUser;

/**
 * sqlの処理を実行を管理するクラス
 * 
 * @author yukishi
 *
 */
@Mapper
public interface UserMapper {

	/**
	 * ユーザー登録
	 * @param user
	 * @return
	 */
	public int insertOne(MUser user);
}
