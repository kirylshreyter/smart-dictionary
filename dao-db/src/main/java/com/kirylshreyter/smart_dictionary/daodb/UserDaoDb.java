package com.kirylshreyter.smart_dictionary.daodb;

import com.kirylshreyter.smart_dictionary.datamodel.IUser;

public interface UserDaoDb extends AbstractEntityDaoDb<IUser> {

	public IUser findByToken(String token);

	public IUser findByEmailAndPassword(String email, String password);

	public IUser findByEmail(String email);
	
	public void setFixedTokenFor(String token, long id);

}
