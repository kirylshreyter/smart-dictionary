package com.kirylshreyter.smart_dictionary.webapp.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.kirylshreyter.smart_dictionary.datamodel.IWord;
import com.kirylshreyter.smart_dictionary.webapp.models.WordModel;
import com.kirylshreyter.smart_dictionary.webapp.models.impl.TranslationModelImpl;
import com.kirylshreyter.smart_dictionary.webapp.models.impl.WordModelImpl;

public class WordToWordModelConverter implements Converter<IWord, WordModel> {

	@Override
	public WordModel convert(IWord source) {
		WordModel wordModel = new WordModelImpl();
		wordModel.setId(source.getId());
		wordModel.setValue(source.getValue());
		wordModel.setRepeatCount(source.getRepeatCount());
		wordModel.setUserId(source.getUser().getId());
		List<TranslationModelImpl> set = new ArrayList<TranslationModelImpl>();
		source.getTranslations().forEach((translation) -> {
			TranslationModelImpl translationModel = new TranslationModelImpl();
			translationModel.setId(translation.getId());
			translationModel.setValue(translation.getValue());
			set.add(translationModel);
		});

		wordModel.setTranslations(set);
		return wordModel;
	}

}
