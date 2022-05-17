package com.testboard2.service;

import org.springframework.stereotype.Service;

import com.testboard2.dto.MemberDTO;

@Service
public interface MemberService {

	void insertMember(MemberDTO memberDTO);
	

}
