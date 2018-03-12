package com.kirylshreyter.smart_dictionary.services.security;

public class Credentials {

	public Credentials(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Credentials() {

	}

	private String email;

	private String password;

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

	public boolean completed() {
		if (getEmail() != null && getPassword() != null) {
			return true;
		}
		return false;
	}

}
