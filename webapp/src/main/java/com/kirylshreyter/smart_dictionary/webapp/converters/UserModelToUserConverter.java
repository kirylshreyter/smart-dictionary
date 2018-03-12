package com.kirylshreyter.smart_dictionary.webapp.converters;

import org.springframework.core.convert.converter.Converter;

import com.kirylshreyter.smart_dictionary.daodb.entities.FirstName;
import com.kirylshreyter.smart_dictionary.daodb.entities.LastName;
import com.kirylshreyter.smart_dictionary.daodb.entities.User;
import com.kirylshreyter.smart_dictionary.datamodel.IFirstName;
import com.kirylshreyter.smart_dictionary.datamodel.ILastName;
import com.kirylshreyter.smart_dictionary.datamodel.IUser;
import com.kirylshreyter.smart_dictionary.webapp.models.UserModel;

public class UserModelToUserConverter implements Converter<UserModel, IUser> {

	@Override
	public IUser convert(UserModel source) {
		IUser user = new User();
		user.setEmail(source.getEmail());
		user.setPassword(source.getPassword());
		IFirstName iFirstName = new FirstName();
		iFirstName.setValue(source.getFirstName());
		user.setFirstName(iFirstName);
		ILastName iLastName = new LastName();
		iLastName.setValue(source.getLastName());
		user.setLastName(iLastName);
		user.setToken(source.getToken());
		return user;
	}

}
