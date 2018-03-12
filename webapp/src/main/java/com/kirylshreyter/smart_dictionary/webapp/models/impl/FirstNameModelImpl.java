package com.kirylshreyter.smart_dictionary.webapp.models.impl;

import com.kirylshreyter.smart_dictionary.webapp.models.FirstNameModel;

public class FirstNameModelImpl extends AbstractModelImpl implements FirstNameModel {

	private String value;

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
