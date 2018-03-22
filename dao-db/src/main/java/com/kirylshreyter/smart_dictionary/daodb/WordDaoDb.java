package com.kirylshreyter.smart_dictionary.daodb;

import java.util.List;

import com.kirylshreyter.smart_dictionary.datamodel.IWord;

public interface WordDaoDb extends AbstractEntityDaoDb<IWord> {

    public IWord findByIdAndUserId(long id, long userId);

    public List<IWord> findAllByUserId(long userId);

    public void deleteOrphanTranslations();

}
