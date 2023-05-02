package com.example.demo.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.application.service.UserApplicationService;
import com.example.demo.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {

	@Autowired
	private UserApplicationService applicationService;

	//ユーザー登録画面に遷移
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {
		//性別を取得
		Map<String, Integer> genderMap = applicationService.getGenderMap(locale);
		model.addAttribute("genderMap", genderMap);

		//ユーザー登録画面に遷移
		return "/user/signup";
	}

	//ユーザー登録処理
	@PostMapping("/signup")
	public String postSignup(Model model, Locale locale, @ModelAttribute SignupForm form, BindingResult bindingResult) {

		//入力チェック
		if (bindingResult.hasErrors()) {
			//NG:ユーザー登録画面に遷移
			return getSignup(model, locale, form);
		}

		log.info(form.toString());

		//ログイン画面にリダイレクト
		return "redirect:/login";
	}
}
