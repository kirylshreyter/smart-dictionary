package com.kirylshreyter.smart_dictionary.datamodel;

public interface IUser extends IAbstract {

	public String getEmail();

	public void setEmail(String email);

	public String getPassword();

	public void setPassword(String password);

	public IFirstName getFirstName();

	public void setFirstName(IFirstName firstName);

	public ILastName getLastName();

	public void setLastName(ILastName lastName);

	public String getToken();

	public void setToken(String token);

}
