package com.example.demo.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String, Object> findById(String id) {
		//select文
		String query = "Select * from employee where id = ?";

		//検索実行
		Map<String, Object> employee = jdbcTemplate.queryForMap(query,id);
		
		return employee;
	}
}
