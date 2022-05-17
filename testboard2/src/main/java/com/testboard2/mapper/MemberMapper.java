package com.testboard2.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.testboard2.dto.MemberDTO;

// 사용자 요청에 맞는 메서드 호출

@Mapper
public interface MemberMapper {
	
	public void insertMember(MemberDTO memberDTO);
	

}
