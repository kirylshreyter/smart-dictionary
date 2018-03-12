package com.kirylshreyter.smart_dictionary.daodb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirylshreyter.smart_dictionary.datamodel.ILastName;

public interface LastNameRepository extends JpaRepository<ILastName, Long> {

}