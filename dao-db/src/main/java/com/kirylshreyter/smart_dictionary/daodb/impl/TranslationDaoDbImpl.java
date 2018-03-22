package com.kirylshreyter.smart_dictionary.daodb.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.smart_dictionary.daodb.TranslationDaoDb;
import com.kirylshreyter.smart_dictionary.daodb.repositories.TranslationRepository;
import com.kirylshreyter.smart_dictionary.datamodel.ITranslation;

@Repository
public class TranslationDaoDbImpl extends AbstractEntityDaoDbImpl<ITranslation> implements TranslationDaoDb {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private static final String FIND_OBJECT = "Try to find object by value = %s.";

    @Autowired
    private TranslationRepository translationRepository;

    @Override
    public ITranslation findByValue(String value) {
	LOGGER.info(String.format(FIND_OBJECT, value));
	return translationRepository.findByValue(value);
    }

    

}
