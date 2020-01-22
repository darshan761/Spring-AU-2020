package com.springAU.RESTAssignment;

// POJO for User
public class User {
	
	String name;
	int userId;
	
	public String getName() {
		return name;
	}
		
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "User:[name=" + name + " Id="+userId+" ]";
	}

}
