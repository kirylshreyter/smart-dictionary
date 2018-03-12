package com.kirylshreyter.smart_dictionary.webapp.models.impl;

import java.util.List;

import com.kirylshreyter.smart_dictionary.webapp.models.WordModel;

public class WordModelImpl extends AbstractModelImpl implements WordModel {

	private String value;

	private long repeatCount;

	private List<TranslationModelImpl> translations;

	private long userId;

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public long getRepeatCount() {
		return repeatCount;
	}

	@Override
	public void setRepeatCount(long repeatCount) {
		this.repeatCount = repeatCount;
	}

	@Override
	public List<TranslationModelImpl> getTranslations() {
		return translations;
	}

	@Override
	public void setTranslations(List<TranslationModelImpl> translations) {
		this.translations = translations;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
