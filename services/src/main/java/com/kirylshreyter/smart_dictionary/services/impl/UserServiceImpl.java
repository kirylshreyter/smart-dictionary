package com.kirylshreyter.smart_dictionary.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirylshreyter.smart_dictionary.daodb.UserDaoDb;
import com.kirylshreyter.smart_dictionary.datamodel.IUser;
import com.kirylshreyter.smart_dictionary.services.AuthenticationService;
import com.kirylshreyter.smart_dictionary.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoDb userDaoDb;

    @Autowired
    private AuthenticationService authenticationService;

    public IUser create(IUser t) {
	t.setPassword(authenticationService.generateToken(t.getPassword()));
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

    public IUser findByEmail(String email) {
	return userDaoDb.findByEmail(email);
    }

    public void setFixedTokenFor(String token, long id) {
	userDaoDb.setFixedTokenFor(token, id);
    }

    public List<IUser> saveAll(Iterable<IUser> entities) {
	return userDaoDb.saveAll(entities);
    }

    public void deleteAll(Iterable<IUser> entities) {
	userDaoDb.deleteAll(entities);
    }

}
