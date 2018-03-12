package com.kirylshreyter.smart_dictionary.webapp.models.security;

public class AuthenticationModel {

	private String token;

	public AuthenticationModel(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
