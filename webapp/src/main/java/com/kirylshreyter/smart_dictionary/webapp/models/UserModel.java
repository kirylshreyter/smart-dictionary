package com.kirylshreyter.smart_dictionary.webapp.models;

public interface UserModel extends AbstractModel {

	public String getEmail();

	public void setEmail(String email);

	public String getPassword();

	public void setPassword(String password);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public String getToken();

	public void setToken(String token);

}
