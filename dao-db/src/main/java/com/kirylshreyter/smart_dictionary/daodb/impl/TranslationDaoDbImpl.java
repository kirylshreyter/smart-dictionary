package com.kirylshreyter.smart_dictionary.daodb.impl;

import org.springframework.stereotype.Repository;

import com.kirylshreyter.smart_dictionary.daodb.TranslationDaoDb;
import com.kirylshreyter.smart_dictionary.datamodel.ITranslation;

@Repository
public class TranslationDaoDbImpl extends AbstractEntityDaoDbImpl<ITranslation> implements TranslationDaoDb {

}
