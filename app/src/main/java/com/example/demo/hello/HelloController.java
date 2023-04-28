package com.example.demo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String getHello() {
		//hello.htmlに遷移する
		return "hello";
	}

	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1") String str, Model model) {
		//受け取ったパラメータをmodelに登録する
		model.addAttribute("sample", str);

		//response.htmlに遷移
		return "/hello/response";
	}
}
