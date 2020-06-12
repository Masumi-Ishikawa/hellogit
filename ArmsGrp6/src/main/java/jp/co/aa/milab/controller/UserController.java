package jp.co.aa.milab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.aa.milab.form.UserForm;
import jp.co.aa.milab.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	// ユーザー情報新規登録画面 - Get
	@GetMapping("/user/regist")
	public String getUserRegist(@ModelAttribute UserForm userForm) {
		return "userregist";

	}

	// ユーザー情報新規登録画面 - Post
	@PostMapping("/user/regist")
	public String postUserRegist(@Validated @ModelAttribute UserForm userForm,
								BindingResult bindingResult, RedirectAttributes attr, Model model) {

		if(bindingResult.hasErrors()) {
			model.addAttribute("notinput", "全て入力してください");
			return "userregist";
		}

		userService.inputUser(userForm);
		//attr.addFlashAttribute("userForm", userForm);

		return "redirect:/user/regist";

	}

	@GetMapping("/user/update")
	public String getUserUpdate(@RequestParam(name = "userid", defaultValue = "")String userid,
			@ModelAttribute UserForm userForm, Model model) {

		//UserForm user = userService.searchUser(userid);
		//model.addAttribute("userForm", user);

		return "useredit";

	}

	@PostMapping("/user/update")
	public String postUserUpdate(@Validated @ModelAttribute UserForm userForm,
			BindingResult bindingResult, RedirectAttributes attr, Model model) {

		if(bindingResult.hasErrors()) {
			model.addAttribute("notinput", "全て入力してください");
			return "userregist";
		}

		userService.updateUser(userForm);
		//attr.addFlashAttribute("userForm", userForm);
		userService.updateUser(userForm);
		//attr.addFlashAttribute("userForm", userForm);

		return "redirect:/user/update";
	}

}
