package com.kirylshreyter.smart_dictionary.webapp.models.impl;

import com.kirylshreyter.smart_dictionary.webapp.models.LastNameModel;

public class LastNameModelImpl extends AbstractModelImpl implements LastNameModel {

	private String value;

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
