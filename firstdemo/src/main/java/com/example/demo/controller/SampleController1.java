package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController1 {

	@GetMapping("/user/userinfo")
	public String userInfo() {

		return "";
	}

	@GetMapping
	public String userData(Model model) {

		model.addAttribute("username", "홍길동");
		// 뷰페이지로 데이터(model) 전달
		
		return "/user/userinfo";
	}

}
