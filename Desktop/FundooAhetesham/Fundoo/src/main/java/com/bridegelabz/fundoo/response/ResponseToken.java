package com.bridegelabz.fundoo.response;

public class ResponseToken 
{
	private String message;
	private int code;
	private String token;
	public ResponseToken() 
	{
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "Token [message=" + message + ", code=" + code + ", token=" + token + "]";
	}
	
}
