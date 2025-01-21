package com.demo.entity;

public class User {
	
	private int id;
	
	private String first_name;
	
	private String last_name;
	
	private String email;
	
	private String password;
	
	private String address;
	
	private String mobile_number;
	
	private String gender;

	public User() {
		super();
	}

	public User(String first_name, String last_name, String email, String password, String address,
			String mobile_number, String gender) {
		super();
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobile_number = mobile_number;
		this.gender = gender;
	}

	

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [ first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", mobile_number=" + mobile_number + ", gender="
				+ gender + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	 
	
}
