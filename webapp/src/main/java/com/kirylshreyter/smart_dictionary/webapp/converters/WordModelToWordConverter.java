package com.kirylshreyter.smart_dictionary.webapp.converters;

import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;

import com.kirylshreyter.smart_dictionary.daodb.entities.Translation;
import com.kirylshreyter.smart_dictionary.daodb.entities.Word;
import com.kirylshreyter.smart_dictionary.datamodel.ITranslation;
import com.kirylshreyter.smart_dictionary.datamodel.IWord;
import com.kirylshreyter.smart_dictionary.webapp.models.WordModel;

public class WordModelToWordConverter implements Converter<WordModel, IWord> {

	public IWord convert(WordModel source) {
		IWord word = new Word();
		word.setId(source.getId());
		word.setValue(source.getValue());
		word.setRepeatCount(source.getRepeatCount());
		word.setTranslations(source.getTranslations().stream().map((translationModel) -> {
			ITranslation translation = new Translation();
			translation.setId(translationModel.getId());
			translation.setValue(translationModel.getValue());
			return translation;
		}).collect(Collectors.toSet()));
		return word;
	}

}
