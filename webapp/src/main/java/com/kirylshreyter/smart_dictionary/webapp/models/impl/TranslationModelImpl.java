package com.kirylshreyter.smart_dictionary.webapp.models.impl;

import com.kirylshreyter.smart_dictionary.webapp.models.TranslationModel;

public class TranslationModelImpl extends AbstractModelImpl implements TranslationModel {

	private String value;

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

}
