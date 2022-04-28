package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.BookDTO;

/*
 * Form, View, Thymeleaf로 뷰페이지 만들기
 * BookDTO 사용
 */

@Controller
public class SampleController5 {

	@GetMapping("/SampleController5Form")
	public String insertBook(Model model) {
		
		model.addAttribute("bookDTO", new BookDTO());

		return "/post/SampleController5Form";
	}

	@PostMapping("/SampleController5View")
	public String insertView(
			BookDTO bookDTO,
			Model model) {
		// bookDTO 객체 통해 출력
		
		System.out.println(bookDTO.getTitle());
		
		model.addAttribute("heading", "Book Information");
		
		return "/post/SampleController5View";
	}
}
