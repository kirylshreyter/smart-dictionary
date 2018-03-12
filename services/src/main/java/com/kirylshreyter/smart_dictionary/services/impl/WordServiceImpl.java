package com.kirylshreyter.smart_dictionary.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirylshreyter.smart_dictionary.daodb.WordDaoDb;
import com.kirylshreyter.smart_dictionary.datamodel.IWord;
import com.kirylshreyter.smart_dictionary.services.WordService;

@Service
public class WordServiceImpl implements WordService {

	@Autowired
	private WordDaoDb wordDaoDb;

	public IWord create(IWord t) {
		return wordDaoDb.create(t);
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

}
