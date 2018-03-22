package com.kirylshreyter.smart_dictionary.daodb.entities;

import java.util.Set;
import java.util.stream.Collectors;

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
		return words.stream().map(e -> e).collect(Collectors.toSet());
	}

	@Override
	public void setWords(Set<IWord> words) {
		this.words = words.stream().map(e -> (Word) e).collect(Collectors.toSet());
	}

}
