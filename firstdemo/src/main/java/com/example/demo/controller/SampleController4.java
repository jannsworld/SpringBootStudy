package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserDTO;

/* 
 * 스프링부트 객체 전달 : Form과 View를 폴더 내에서 처리
 */

@Controller
public class SampleController4 {

	@GetMapping("/SampleController4Form")
	public String mainPge() {

		return "/post/SampleController4Form";
	}

	@PostMapping("/SampleController4View")
	public String userForm(UserDTO userDTO, Model model) {

		// userDTO 객체 통해ㄴ 출력
		System.out.println(userDTO.getUserName());
		System.out.println(userDTO.getUserId());
		System.out.println(userDTO.getUserPhone());

		// model 통해 데이터 추가
		model.addAttribute("heading", "User Information");

		return "/post/SampleController4View";
	}

}
