package com.kirylshreyter.smart_dictionary.daodb.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.smart_dictionary.daodb.WordDaoDb;
import com.kirylshreyter.smart_dictionary.daodb.repositories.TranslationRepository;
import com.kirylshreyter.smart_dictionary.daodb.repositories.WordRepository;
import com.kirylshreyter.smart_dictionary.datamodel.IWord;

@Repository
public class WordDaoDbImpl extends AbstractEntityDaoDbImpl<IWord> implements WordDaoDb {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private TranslationRepository translationRepository;

    @Override
    public IWord findByIdAndUserId(long id, long userId) {
	return wordRepository.findByIdAndUserId(id, userId);
    }

    @Override
    public List<IWord> findAllByUserId(long userId) {
	return wordRepository.findAllByUserId(userId).stream().map(s -> s).collect(Collectors.toList());
    }

    @Override
    public void deleteOrphanTranslations() {
	translationRepository.deleteOrphanTranslations();
    }

}
