package com.kirylshreyter.smart_dictionary.daodb.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.kirylshreyter.smart_dictionary.datamodel.IAbstract;

@MappedSuperclass
public class AbstractEntity implements IAbstract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
