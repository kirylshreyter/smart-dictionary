package com.kirylshreyter.smart_dictionary.webapp.converters;

import org.springframework.core.convert.converter.Converter;

import com.kirylshreyter.smart_dictionary.datamodel.IUser;
import com.kirylshreyter.smart_dictionary.webapp.models.UserModel;
import com.kirylshreyter.smart_dictionary.webapp.models.impl.UserModelImpl;

public class UserToUserModelConverter implements Converter<IUser, UserModel> {

	@Override
	public UserModel convert(IUser source) {
		UserModel userModel = new UserModelImpl();
		userModel.setId(source.getId());
		userModel.setFirstName(source.getFirstName().getValue());
		userModel.setLastName(source.getLastName().getValue());
		userModel.setPassword(source.getPassword());
		userModel.setEmail(source.getEmail());
		userModel.setToken(source.getToken());
		return userModel;
	}

}
