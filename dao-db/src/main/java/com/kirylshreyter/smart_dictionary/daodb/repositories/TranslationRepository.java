package com.kirylshreyter.smart_dictionary.daodb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirylshreyter.smart_dictionary.datamodel.ITranslation;

public interface TranslationRepository extends JpaRepository<ITranslation, Long> {

}
