package com.kirylshreyter.smart_dictionary.datamodel;

import java.util.Set;

public interface ITranslation extends IAbstract {

	public String getValue();

	public void setValue(String value);

	public Set<IWord> getWords();

	public void setWords(Set<IWord> words);

}
