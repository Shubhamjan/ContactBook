package com.demo.entity;

public class Contact {

	private int contact_id;

	private String first_name;

	private String last_name;

	private String email;

	private String phone_number;
	
	private String about;
	
	private int userId;

	public Contact() {
		super();
	}

	

	public Contact(String first_name, String last_name, String email, String phone_number, String about,
			int userId) {
		super();
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.about = about;
		this.userId = userId;
	}



	

	public int getContact_id() {
		return contact_id;
	}



	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
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

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	@Override
	public String toString() {
		return "Contact [contact_id=" + contact_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", phone_number=" + phone_number + ", about=" + about + ", userId=" + userId
				+ "]";
	}



	



	

	
}
