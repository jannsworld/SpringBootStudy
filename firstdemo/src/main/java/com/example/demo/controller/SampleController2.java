package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController2 {

	@PostMapping("/post")
	public String demoPost(
			@RequestParam String membername, 
			@RequestParam String memberid, 
			@RequestParam String memberemail, 
			Model model) {
		
		model.addAttribute("membername", membername);
		model.addAttribute("memberid", memberid);
		model.addAttribute("memberemail", memberemail);


//		@RequsetBody는 전달된 데이터를 일괄로 묶어 출력

//		System.out.println("성공");
//		System.out.println(req);

		return "/post/post"; // post.html
	}

}
