package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/user/userid")
	public String userId(@RequestParam( value = "userid", required=false) String userid, Model model) {
/*
 * required = true 옵션 디폴트며, 이 때는 반드시 userid 파라미터 값 넣어 HTTP 요청되어야 하고,
 * 	required = false 지정하면, 값이 필수가 아니기에 입력되지 않더라도 에러 발생하지 않음
 */
		model.addAttribute("userid", userid);
		
		return "/user/userinfo"; // userinfo.html
	}

}
