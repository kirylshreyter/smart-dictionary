package com.kirylshreyter.smart_dictionary.datamodel;

import java.util.Set;

public interface IWord extends IAbstract {

	public String getValue();

	public void setValue(String value);

	public long getRepeatCount();

	public void setRepeatCount(long repeatCount);

	public IUser getUser();

	public void setUser(IUser user);

	public Set<ITranslation> getTranslations();

	public void setTranslations(Set<ITranslation> translations);

}
