package com.kirylshreyter.smart_dictionary.webapp.models.security;

public class AuthHeader {

	private String authorization;

	private String authSchema;

	private String base64encodedCredentials;

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
		try {
			String[] result = authorization.split("Basic");
			authSchema = result[0].trim();
			base64encodedCredentials = result[1].trim();
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		}
	}

	public String getAuthorization() {
		return authorization;
	}

	public String getAuthSchema() {
		return authSchema;
	}

	public void setAuthSchema(String authSchema) {
		this.authSchema = authSchema;
	}

	public String getBase64encodedCredentials() {
		return base64encodedCredentials;
	}

	public void setBase64encodedCredentials(String base64encodedCredentials) {
		this.base64encodedCredentials = base64encodedCredentials;
	}

	public boolean isCompleted() {
		if (getAuthSchema() != null && getBase64encodedCredentials() != null) {
			return true;
		}
		return false;
	}

}
