package com.kirylshreyter.smart_dictionary.webapp.models.impl;

import com.kirylshreyter.smart_dictionary.webapp.models.AbstractModel;

public class AbstractModelImpl implements AbstractModel {

	private long id;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
