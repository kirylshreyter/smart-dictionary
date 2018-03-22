package com.kirylshreyter.smart_dictionary.webapp.converters;

import org.springframework.core.convert.converter.Converter;

import com.kirylshreyter.smart_dictionary.datamodel.IUser;
import com.kirylshreyter.smart_dictionary.webapp.models.UserModel;

public class UserToUserModelConverter implements Converter<IUser, UserModel> {

	@Override
	public UserModel convert(IUser source) {
		UserModel userModel = new UserModel();
		userModel.setId(source.getId());
		userModel.setFirstName(source.getFirstName());
		userModel.setLastName(source.getLastName());
		userModel.setPassword(source.getPassword());
		userModel.setEmail(source.getEmail());
		userModel.setToken(source.getToken());
		return userModel;
	}

}
