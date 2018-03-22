package com.kirylshreyter.smart_dictionary.webapp.models.security;

public class RestrictedResourceRequested {

	public RestrictedResourceRequested(String error) {
		this.error = error;
	}

	public RestrictedResourceRequested() {
	}

	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
