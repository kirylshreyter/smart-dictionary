package com.kirylshreyter.smart_dictionary.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirylshreyter.smart_dictionary.daodb.UserDaoDb;
import com.kirylshreyter.smart_dictionary.datamodel.IUser;
import com.kirylshreyter.smart_dictionary.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoDb userDaoDb;

	public IUser create(IUser t) {
		return userDaoDb.create(t);
	}

	public IUser read(long id) {
		return userDaoDb.read(id);
	}

	public List<IUser> readAll() {
		return userDaoDb.readAll();
	}

	public void delete(IUser t) {
		userDaoDb.delete(t);
	}

	public IUser findByToken(String token) {
		return userDaoDb.findByToken(token);
	}

	public IUser findByEmailAndPassword(String email, String password) {
		return userDaoDb.findByEmailAndPassword(email, password);
	}

}
