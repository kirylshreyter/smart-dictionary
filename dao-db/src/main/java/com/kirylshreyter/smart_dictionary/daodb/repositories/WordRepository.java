package com.kirylshreyter.smart_dictionary.daodb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirylshreyter.smart_dictionary.daodb.entities.Word;
import com.kirylshreyter.smart_dictionary.datamodel.IWord;

public interface WordRepository extends JpaRepository<IWord, Long> {

	public Word findByIdAndUserId(long id, long userId);

	public List<Word> findAllByUserId(long userId);

}
