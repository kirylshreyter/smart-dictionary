package com.kirylshreyter.smart_dictionary.daodb.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kirylshreyter.smart_dictionary.datamodel.ITranslation;
import com.kirylshreyter.smart_dictionary.datamodel.IUser;
import com.kirylshreyter.smart_dictionary.datamodel.IWord;

@Entity
@Table(name = "Words")
public class Word extends AbstractEntity implements IWord {

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(name = "value")
	private String value;

	@Column(name = "repeat_count")
	private long repeatCount;

	@ManyToMany(cascade = { CascadeType.ALL }, targetEntity = Translation.class)
	@JoinTable(name = "words_2_translations", joinColumns = @JoinColumn(name = "word_id"), inverseJoinColumns = @JoinColumn(name = "translation_id"))
	private Set<Translation> translations;

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
	public IUser getUser() {
		return user;
	}

	@Override
	public Set<ITranslation> getTranslations() {
		Set<ITranslation> result = new HashSet<ITranslation>();
		translations.forEach((translation) -> {
			result.add(translation);
		});
		return result;
	}

	@Override
	public void setUser(IUser user) {
		this.user = (User) user;
	}

	@Override
	public void setTranslations(Set<ITranslation> translations) {
		Set<Translation> result = new HashSet<Translation>();
		translations.forEach((translation) -> {
			result.add((Translation) translation);
		});
		;
		this.translations = result;
	}

}
