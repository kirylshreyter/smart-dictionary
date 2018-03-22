package com.kirylshreyter.smart_dictionary.services;

import java.util.List;

import com.kirylshreyter.smart_dictionary.datamodel.IWord;

public interface WordService extends AbstractService<IWord> {

    public IWord findByIdAndUserId(long id, long userId);

    public List<IWord> findAllByUserId(long userId);

    public IWord updateFields(IWord source, IWord target);

    public void deleteOrphanTranslations();

}
