package com.example.demo.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	@Autowired
	private HelloRepository repository;

	//従業員1人を検索
	public Employee getEmployee(String id) {
		//検索
		Map<String, Object> map = repository.findById(id);

		//Mapから値を取得
		String employeeId = (String) map.get("id");
		String employeeName = (String) map.get("name");
		int age = (Integer) map.get("age");

		//Employeeに値をセット
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setEmployeeAge(age);

		return employee;
	}
}
