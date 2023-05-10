package com.example.demo.controller;

import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.application.service.UserApplicationService;
import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.form.GroupOrder;
import com.example.demo.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

/**
 * ユーザー登録画面に遷移する時の処理を統括するコントローラー
 * 
 * @author yukishi
 *
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {

	@Autowired
	private UserApplicationService applicationService;
	private UserService userService;
	private ModelMapper modelMapper;
	
	/**
	 * ユーザー登録画面に遷移<br>
	 * APIの処理結果を画面に送るためのインターフェース<br>
	 * ブラウザの画面の言語設定<br>
	 * <br>
	 * UserApplicationServiceを使用して性別を取得する。
	 * @param model
	 * @param locale
	 * @param form
	 * @return　user/signup.html
	 */
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {
		//性別を取得
		Map<String, Integer> genderMap = applicationService.getGenderMap(locale);
		model.addAttribute("genderMap", genderMap);

		//ユーザー登録画面に遷移
		return "/user/signup";
	}


	/**
	 * ユーザー登録処理<br>
	 * ユーザー登録画面の入力値のチェックする。
	 * 
	 * @param model
	 * @param locale
	 * @param form
	 * @param bindingResult
	 * @return ログイン画面にリダイレクト
	 */
	@PostMapping("/signup")
	public String postSignup(Model model, Locale locale, @ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult) {

		//入力チェック
		if (bindingResult.hasErrors()) {
			//NG:ユーザー登録画面に遷移
			return getSignup(model, locale, form);
		}

		log.info(form.toString());
		
		//formをMUserクラスに変換
		MUser user = modelMapper.map(form, MUser.class);
		
		//ユーザ登録
		userService.signup(user);

		//ログイン画面にリダイレクト
		return "redirect:/login";
	}
}
