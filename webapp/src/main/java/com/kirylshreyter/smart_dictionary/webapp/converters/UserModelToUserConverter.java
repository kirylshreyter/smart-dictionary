package com.kirylshreyter.smart_dictionary.webapp.converters;

import org.springframework.core.convert.converter.Converter;

import com.kirylshreyter.smart_dictionary.daodb.entities.User;
import com.kirylshreyter.smart_dictionary.datamodel.IUser;
import com.kirylshreyter.smart_dictionary.webapp.models.UserModel;

public class UserModelToUserConverter implements Converter<UserModel, IUser> {

	@Override
	public IUser convert(UserModel source) {
		IUser user = new User();
		user.setEmail(source.getEmail());
		user.setPassword(source.getPassword());
		user.setFirstName(source.getFirstName());
		user.setLastName(source.getLastName());
		user.setToken(source.getToken());
		return user;
	}

}
