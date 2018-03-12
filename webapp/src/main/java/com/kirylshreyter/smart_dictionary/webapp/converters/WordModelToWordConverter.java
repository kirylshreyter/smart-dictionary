package com.kirylshreyter.smart_dictionary.webapp.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;

import com.kirylshreyter.smart_dictionary.daodb.entities.Translation;
import com.kirylshreyter.smart_dictionary.daodb.entities.Word;
import com.kirylshreyter.smart_dictionary.datamodel.ITranslation;
import com.kirylshreyter.smart_dictionary.datamodel.IWord;
import com.kirylshreyter.smart_dictionary.webapp.models.WordModel;

public class WordModelToWordConverter implements Converter<WordModel, IWord> {

	@Override
	public IWord convert(WordModel source) {
		IWord word = new Word();
		word.setId(source.getId());
		word.setValue(source.getValue());
		word.setRepeatCount(source.getRepeatCount());
		Set<ITranslation> translations = new HashSet<ITranslation>();
		source.getTranslations().forEach((translation) -> {
			ITranslation resultTranslation = new Translation();
			resultTranslation.setValue(translation.getValue());
			translations.add(resultTranslation);
		});
		word.setTranslations(translations);
		return word;
	}

}
