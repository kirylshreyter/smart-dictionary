package com.kirylshreyter.smart_dictionary.webapp.converters;

import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;

import com.kirylshreyter.smart_dictionary.datamodel.IWord;
import com.kirylshreyter.smart_dictionary.webapp.models.TranslationModel;
import com.kirylshreyter.smart_dictionary.webapp.models.WordModel;

public class WordToWordModelConverter implements Converter<IWord, WordModel> {

	@Override
	public WordModel convert(IWord source) {
		WordModel wordModel = new WordModel();
		wordModel.setId(source.getId());
		wordModel.setValue(source.getValue());
		wordModel.setRepeatCount(source.getRepeatCount());
		wordModel.setUserId(source.getUser().getId());
		wordModel.setTranslations(source.getTranslations().stream().map((translation) -> {
			TranslationModel translationModel = new TranslationModel();
			translationModel.setId(translation.getId());
			translationModel.setValue(translation.getValue());
			return translationModel;
		}).collect(Collectors.toSet()));
		return wordModel;
	}

}
