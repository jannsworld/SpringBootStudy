package com.testboard2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.testboard2.dto.MemberDTO;
import com.testboard2.mapper.MemberMapper;

@SpringBootTest
public class MapperTests {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testInsert() {
		
		MemberDTO m1 = new MemberDTO();
		
		m1.setName("장발장");
		m1.setId("mr.Jang");
		m1.setPhone("010-897-1234");
		
		System.out.println(m1);
		memberMapper.insertMember(m1);
		
		System.out.println("-------------------");
		System.out.println(" 멤버가 추가되었어요! 축하해요! ");
		System.out.println("-------------------");
		
	}
	
}
