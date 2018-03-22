package com.kirylshreyter.smart_dictionary.webapp.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class WordModel extends AbstractModel {

	private String value;

	private long repeatCount;

	@JsonIgnore
	private long userId;

	private Set<TranslationModel> translations;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public long getRepeatCount() {
		return repeatCount;
	}

	public void setRepeatCount(long repeatCount) {
		this.repeatCount = repeatCount;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Set<TranslationModel> getTranslations() {
		return translations;
	}

	public void setTranslations(Set<TranslationModel> translations) {
		this.translations = translations;
	}

}
