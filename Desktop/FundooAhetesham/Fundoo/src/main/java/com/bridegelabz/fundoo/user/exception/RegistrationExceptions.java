package com.bridegelabz.fundoo.user.exception;

public class RegistrationExceptions extends RuntimeException
{
	private String meassage;
	private int errorCode;
	public RegistrationExceptions(String meassage, int errorCode) {
		super();
		this.meassage = meassage;
		this.errorCode = errorCode;
	}
	public String getMeassage() {
		return meassage;
	}
	public void setMeassage(String meassage) {
		this.meassage = meassage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	@Override
	public String toString() {
		return "RegistrationExceptions [meassage=" + meassage + ", errorCode=" + errorCode + "]";
	}
	
}
