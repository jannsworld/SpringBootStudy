package com.testboard2.service;

import org.springframework.stereotype.Service;

import com.testboard2.dto.MemberDTO;

@Service
public interface MemberService {

	public void insertMember(MemberDTO memberDTO);

	public MemberDTO getMemberOne(int num);
	

}
