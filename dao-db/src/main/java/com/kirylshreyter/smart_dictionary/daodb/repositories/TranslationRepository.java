package com.kirylshreyter.smart_dictionary.daodb.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.kirylshreyter.smart_dictionary.daodb.entities.Translation;
import com.kirylshreyter.smart_dictionary.datamodel.ITranslation;

public interface TranslationRepository extends JpaRepository<ITranslation, Long> {

    public Translation findByValue(String value);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query(value = "DELETE FROM translations WHERE id IN (SELECT id FROM translations t LEFT OUTER JOIN words_2_translations wt ON t.id = wt.translation_id WHERE wt.word_id IS NULL AND wt.translation_id IS NULL)", nativeQuery = true)
    public void deleteOrphanTranslations();

}
