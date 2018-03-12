package com.kirylshreyter.smart_dictionary.daodb.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.kirylshreyter.smart_dictionary.datamodel.ITranslation;
import com.kirylshreyter.smart_dictionary.datamodel.IWord;

@Entity
@Table(name = "Translations")
public class Translation extends AbstractEntity implements ITranslation {

	@Column(name = "value")
	private String value;

	@ManyToMany(mappedBy = "translations")
	private Set<Word> words;

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public Set<IWord> getWords() {
		Set<IWord> result = new HashSet<IWord>();
		words.forEach((word) -> {
			result.add(word);
		});
		return result;
	}

	@Override
	public void setWords(Set<IWord> words) {
		Set<Word> result = new HashSet<Word>();
		words.forEach((word) -> {
			result.add((Word) word);
		});
		;
		this.words = result;
	}

}
