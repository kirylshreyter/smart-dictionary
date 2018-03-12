package com.kirylshreyter.smart_dictionary.daodb.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kirylshreyter.smart_dictionary.datamodel.IAbstract;

public class AbstractEntityDaoDbImpl<T extends IAbstract> {

	private static final String FIND_OBJECT = "Try to find object with id = %s.";
	private static final String SAVE_OBJECT = "Saving object %s.";
	private static final String FIND_ALL_OBJECTS = "Try to find all objects.";
	private static final String DELETE_OBJECT = "Try to delete object %s.";

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JpaRepository<T, Long> repository;

	public T read(long id) {
		LOGGER.info(String.format(FIND_OBJECT, id));
		return repository.getOne(id);
	}

	public T create(T entity) {
		LOGGER.info(String.format(SAVE_OBJECT, entity.toString()));
		return repository.save(entity);
	}

	public List<T> readAll() {
		LOGGER.info(FIND_ALL_OBJECTS);
		return repository.findAll();
	}

	public void delete(T entity) {
		LOGGER.info(String.format(DELETE_OBJECT, entity.toString()));
		repository.delete(entity);
	}

}
