package com.model;

public class User {
	private String Username;
	private String Password;

	public User(String userName, String password) {
		this.Username = userName;
		this.Password = password;
	}

	public String getuserName() {
		return Username;
	}

	public void setuserName(String userName) {
		this.Username = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}
}
