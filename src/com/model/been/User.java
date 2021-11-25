package com.model.been;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String userName;
	private String email;
	private String password;
	private String cnfpassword;

	public User(String id, String userName, String email, String password, String cnfpassword) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.cnfpassword = cnfpassword;
	}

	public User() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getCnfpassword() {
		return cnfpassword;
	}

	public void setCnfpassword(String cnfpassword) {
		this.cnfpassword = cnfpassword;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", cnfpassword=" + cnfpassword + "]";
	}

}
