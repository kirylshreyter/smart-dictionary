package com.kirylshreyter.smart_dictionary.daodb.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.smart_dictionary.daodb.UserDaoDb;
import com.kirylshreyter.smart_dictionary.daodb.repositories.UserRepository;
import com.kirylshreyter.smart_dictionary.datamodel.IUser;

@Repository
public class UserDaoDbImpl extends AbstractEntityDaoDbImpl<IUser> implements UserDaoDb {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private static final String FIND_OBJECT = "Try to find object by token.";

	@Autowired
	private UserRepository userRepository;

	@Override
	public IUser findByToken(String token) {
		LOGGER.info(FIND_OBJECT);
		return userRepository.findByToken(token);
	}

	@Override
	public IUser findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

}
