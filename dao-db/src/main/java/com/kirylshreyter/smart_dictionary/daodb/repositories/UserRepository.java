package com.kirylshreyter.smart_dictionary.daodb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirylshreyter.smart_dictionary.daodb.entities.User;
import com.kirylshreyter.smart_dictionary.datamodel.IUser;

public interface UserRepository extends JpaRepository<IUser, Long> {

	public User findByToken(String token);

	public User findByEmailAndPassword(String email, String password);

}
