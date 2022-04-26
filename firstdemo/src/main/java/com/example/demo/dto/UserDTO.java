package com.example.demo.dto;

// 변수만 만들어주고, 나머지 getter, setter, toString 자동으로 생성 -> 전달 값들 객체화
public class UserDTO {
	
	private String userName;
	private String userId;
	private String userPhone;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", userId=" + userId + ", userPhone=" + userPhone + "]";
	}
	

}
