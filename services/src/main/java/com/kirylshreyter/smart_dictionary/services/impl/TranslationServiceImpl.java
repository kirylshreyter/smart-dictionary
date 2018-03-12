package com.kirylshreyter.smart_dictionary.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirylshreyter.smart_dictionary.daodb.TranslationDaoDb;
import com.kirylshreyter.smart_dictionary.datamodel.ITranslation;
import com.kirylshreyter.smart_dictionary.services.TranslationService;

@Service
public class TranslationServiceImpl implements TranslationService {

	@Autowired
	private TranslationDaoDb translationDaoDb;

	public ITranslation create(ITranslation t) {
		return translationDaoDb.create(t);
	}

	public ITranslation read(long id) {
		return translationDaoDb.read(id);
	}

	public List<ITranslation> readAll() {
		return translationDaoDb.readAll();
	}

	public void delete(ITranslation t) {
		translationDaoDb.delete(t);
	}

}
