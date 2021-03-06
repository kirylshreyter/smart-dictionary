package com.kirylshreyter.smart_dictionary.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kirylshreyter.smart_dictionary.daodb.WordDaoDb;
import com.kirylshreyter.smart_dictionary.datamodel.IWord;
import com.kirylshreyter.smart_dictionary.services.TranslationService;
import com.kirylshreyter.smart_dictionary.services.WordService;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordDaoDb wordDaoDb;

    @Autowired
    private TranslationService translationService;

    @Transactional
    public IWord create(IWord t) {
	t = wordDaoDb.create(t);
	wordDaoDb.deleteOrphanTranslations();
	return t;
    }

    public IWord read(long id) {
	return wordDaoDb.read(id);
    }

    public List<IWord> readAll() {
	return wordDaoDb.readAll();
    }

    public void delete(IWord t) {
	wordDaoDb.delete(t);
    }

    public IWord findByIdAndUserId(long id, long userId) {
	return wordDaoDb.findByIdAndUserId(id, userId);
    }

    public List<IWord> findAllByUserId(long userId) {
	return wordDaoDb.findAllByUserId(userId);
    }

    public List<IWord> saveAll(Iterable<IWord> entities) {
	return wordDaoDb.saveAll(entities);
    }

    public void deleteAll(Iterable<IWord> entities) {
	wordDaoDb.deleteAll(entities);
    }

    @Transactional
    public IWord updateFields(IWord source, IWord target) {
	target.setValue(source.getValue());
	target.setRepeatCount(
		source.getRepeatCount() > target.getRepeatCount() ? source.getRepeatCount() : target.getRepeatCount());
	target.deleteAllTranslations();
	source.getTranslations().forEach(e -> target.addTranslation(translationService.create(e)));
	return target;
    }

    public void deleteOrphanTranslations() {
	wordDaoDb.deleteOrphanTranslations();
    }
}
