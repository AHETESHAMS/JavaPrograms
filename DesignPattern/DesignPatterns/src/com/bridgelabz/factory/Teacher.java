package com.bridgelabz.factory;

public class Teacher implements Person 
{
	private String name;
	private String phNumber;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", phNumber=" + phNumber + ", address=" + address + "]";
	}
	
}
