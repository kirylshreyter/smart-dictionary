package com.kirylshreyter.smart_dictionary.daodb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirylshreyter.smart_dictionary.datamodel.IFirstName;

public interface FirstNameRepository extends JpaRepository<IFirstName, Long> {

}
