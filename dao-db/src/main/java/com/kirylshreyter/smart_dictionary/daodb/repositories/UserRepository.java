package com.kirylshreyter.smart_dictionary.daodb.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.kirylshreyter.smart_dictionary.daodb.entities.User;
import com.kirylshreyter.smart_dictionary.datamodel.IUser;

public interface UserRepository extends JpaRepository<IUser, Long> {

	public User findByToken(String token);

	public User findByEmailAndPassword(String email, String password);

	public User findByEmail(String email);

	@Transactional
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Query("update User u set u.token = ?1 where u.id = ?2")
	public void setFixedTokenFor(String token, long id);

}
