package com.testboard2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.testboard2.dto.MemberDTO;
import com.testboard2.service.MemberService;

@Controller
public class MemberController {
	/*
	 * DI
	 */

	@Autowired
	private MemberService memberService;

	/*
	 * 회원등록 Form 페이지 + 회원 수정 Form
	 */

	@GetMapping("/member/memberWriteForm")
	public String memberWriteForm(@RequestParam(value = "num", required = false) Integer num, Model model) {
		// required 옵션 디폴트 True : @RequestParam(value = "num")

		// 넘어온 값이 null 인지 체크, num이 null인지 비교할 때 : Primitive Type(원시타입) int null 불가
		// null 이 필요한 경우 Integer 사용 또는 0을 사용 :: if(num !0 = null) {~
		if (num != null) {

			System.out.println(num);
			// null 이 아닌 경우는 파라미터 값으로 null 넘어왔다는 것이기에 "수정"처리로 볼 수 있다.
			// 따라서 여기에 수정 처리 코드 작성

			// 넘어온 num값에 대한 회원 정보를 DB에서 가져와서 해당 회원 정보를 Form에 전달

			MemberDTO m1 = memberService.getMemberOne(num);

			System.out.println(m1.getName());
			System.out.println(m1.getId());
			System.out.println(m1.getPhone());

			// Form 페이지로 m1 객체를 전달 -> 모델(model)
			model.addAttribute("memberDTO", m1);
			model.addAttribute("formTitle", "Modification");

		} else {
			System.out.println("null 입니다!");
			// null 이라는 것은 파라미터 값으로 num 값이 넘어온게 없다는 것이므로 Insert

			model.addAttribute("memberDTO", new MemberDTO());
			model.addAttribute("formTitle", "Registration");

		}

		return "member/memberWriteForm"; // memberWriteForm.html
	}

	/*
	 * 회원 등록 Ok
	 */

	@PostMapping("/member/memberWriteOk")
	public String insertMember(MemberDTO m1) {

		try {
			// 등록처리
			System.out.println(m1.getName());
			System.out.println(m1.getId());
			System.out.println(m1.getPhone());

			memberService.insertMember(m1);
		} catch (Exception e) {
			// err
		}

		return "redirect:/";

		// return "member/memberWriteForm";
		// 리턴과 redirect 리턴의 차이 : redirect 경우 다시 한번 해당 URL로 HTTP 요청을 넣는 형태
	}
}
