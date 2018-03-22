package com.kirylshreyter.smart_dictionary.daodb;

import com.kirylshreyter.smart_dictionary.datamodel.ITranslation;

public interface TranslationDaoDb extends AbstractEntityDaoDb<ITranslation> {

    public ITranslation findByValue(String value);

}
