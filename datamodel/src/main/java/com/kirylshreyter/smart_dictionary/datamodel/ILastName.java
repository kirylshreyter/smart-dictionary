package com.kirylshreyter.smart_dictionary.datamodel;

import java.util.Set;

public interface ILastName extends IAbstract {

	public String getValue();

	public void setValue(String value);

	public Set<IUser> getUsers();

}
