package com.kirylshreyter.smart_dictionary.services;

import com.kirylshreyter.smart_dictionary.datamodel.IUser;

public interface UserService extends AbstractService<IUser> {

	public IUser findByToken(String token);

	public IUser findByEmailAndPassword(String email, String password);

}
