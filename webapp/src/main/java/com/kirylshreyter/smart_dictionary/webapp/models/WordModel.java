package com.kirylshreyter.smart_dictionary.webapp.models;

import java.util.List;

import com.kirylshreyter.smart_dictionary.webapp.models.impl.TranslationModelImpl;

public interface WordModel extends AbstractModel {

	public String getValue();

	public void setValue(String value);

	public long getRepeatCount();

	public void setRepeatCount(long repeatCount);

	public long getUserId();

	public void setUserId(long userId);

	public List<TranslationModelImpl> getTranslations();

	public void setTranslations(List<TranslationModelImpl> translations);

}
