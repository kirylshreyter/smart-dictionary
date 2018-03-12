package com.kirylshreyter.smart_dictionary.webapp.models.security;

public class BadAuthenticationModel {

	public BadAuthenticationModel(String error) {
		this.error = error;
	}

	public BadAuthenticationModel() {
	}

	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
