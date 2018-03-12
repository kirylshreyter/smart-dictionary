package com.kirylshreyter.smart_dictionary.webapp.converters;

import org.springframework.core.convert.converter.Converter;

import com.kirylshreyter.smart_dictionary.webapp.models.security.AuthHeader;

public class StringToAuthHeaderConverter implements Converter<String, AuthHeader> {

	@Override
	public AuthHeader convert(String source) {
		AuthHeader authHeader = new AuthHeader();
		authHeader.setAuthorization(source);
		return authHeader;
	}

}
