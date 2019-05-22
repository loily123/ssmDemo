package com.entity;

public class Admin {
	private String userName, password;
	private int id;

	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", password=" + password + ", id=" + id + "]";
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
