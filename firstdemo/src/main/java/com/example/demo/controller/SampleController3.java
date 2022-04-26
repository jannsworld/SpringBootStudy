package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserDTO;

/*
 * 스프링부트 객체 전달 (userDTO 객체 사용) 
 */

@Controller
public class SampleController3 {

	@PostMapping("/SampleController3")
	public String userForm(UserDTO userDTO, Model model) {
		
		// userDTO 객체 통해 출력
		System.out.println(userDTO.getUserName());
		System.out.println(userDTO.getUserId());
		System.out.println(userDTO.getUserPhone());
		
		model.addAttribute("heading", "DTO 객체 전달 값");

		return "/post/SampleController3View";
	}
}
