package com.kirylshreyter.smart_dictionary.daodb.impl;

import org.springframework.stereotype.Repository;

import com.kirylshreyter.smart_dictionary.daodb.WordDaoDb;
import com.kirylshreyter.smart_dictionary.datamodel.IWord;

@Repository
public class WordDaoDbImpl extends AbstractEntityDaoDbImpl<IWord> implements WordDaoDb {

}
