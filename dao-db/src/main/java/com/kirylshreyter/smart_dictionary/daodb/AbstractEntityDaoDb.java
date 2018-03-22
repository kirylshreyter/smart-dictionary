package com.kirylshreyter.smart_dictionary.daodb;

import java.util.List;

import com.kirylshreyter.smart_dictionary.datamodel.IAbstract;

public interface AbstractEntityDaoDb<T extends IAbstract> {

	T read(long id);

	T create(T entity);

	List<T> readAll();

	void delete(T entity);

	List<T> saveAll(Iterable<T> entities);
	
	void deleteAll(Iterable<T> entities);
	
}