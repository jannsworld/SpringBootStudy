package com.testboard2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testboard2.dto.MemberDTO;
import com.testboard2.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	//DI
	@Autowired
	private MemberMapper memberMapper;
	
	//Insert
	@Override
	public void insertMember(MemberDTO memberDTO) {
		
		memberMapper.insertMember(memberDTO);
	}	
		
	//SelectMemberOne	
	@Override
	public MemberDTO getMemberOne(int num) {
		
		return memberMapper.selectMemberOne(num);
	}

}
