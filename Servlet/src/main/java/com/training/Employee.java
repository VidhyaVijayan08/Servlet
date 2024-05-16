package com.training;

public class Employee {
	String name;
	String phoneNumber;
	String role;
	String address;
	String userName;
	String password;
	
	
	
	public Employee( String name, String phoneNumber, String role, String address, String userName,
			String password) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.address = address;
		this.userName = userName;
		this.password = password;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [ name=" + name + ", phoneNumber=" + phoneNumber + ", role=" + role
				+ ", address=" + address + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}
