package com.kirylshreyter.smart_dictionary.daodb.entities;

import java.util.Set;
import java.util.stream.Collectors;

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

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, targetEntity = Translation.class)
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
	return translations.stream().map(e -> e).collect(Collectors.toSet());
    }

    @Override
    public void setUser(IUser user) {
	this.user = (User) user;
    }

    @Override
    public void setTranslations(Set<ITranslation> translations) {
	this.translations = translations.stream().map(e -> (Translation) e).collect(Collectors.toSet());
    }

    @Override
    public boolean addTranslation(ITranslation translation) {
	return translations.add((Translation) translation);
    }

    @Override
    public boolean removeTranslation(ITranslation translation) {
	return translations.remove(translation);
    }

    @Override
    public Set<ITranslation> findTranslationsByValue(String value) {
	return translations.stream().filter((e) -> {
	    return e.getValue().equals(value);
	}).collect(Collectors.toSet());
    }

    @Override
    public void deleteAllTranslations() {
	translations.clear();
    }

}
