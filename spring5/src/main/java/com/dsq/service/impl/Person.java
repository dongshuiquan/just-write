package com.dsq.service.impl;

public class Person {
	
	String id;
	
	String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", email=" + email + "]";
	}
	
	

}
