package com.kirylshreyter.smart_dictionary.webapp.models;

public class UserModel extends AbstractModel {

	private String email;

	private String password;

	private String firstName;

	private String lastName;

	private String token;

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailName) {
		this.email = emailName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
