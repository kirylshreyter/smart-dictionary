package com.kirylshreyter.smart_dictionary.services.security;

import com.kirylshreyter.smart_dictionary.datamodel.IUser;

public class Authentication {

	private boolean authenticated;

	private String token;

	private IUser user;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public IUser getUser() {
		return user;
	}

	public void setUser(IUser user) {
		this.user = user;
	}

}
