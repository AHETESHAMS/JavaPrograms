package com.bridegelabz.fundoo.user.dto;
public class UserDto 
{
	private String name;
	private String emailId;
	private String phNumber;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDto [name=" + name + ", emailId=" + emailId + ", phNumber=" + phNumber + ", password=" + password
				+ "]";
	} 
	
}
