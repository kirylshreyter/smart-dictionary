package com.kirylshreyter.smart_dictionary.daodb.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kirylshreyter.smart_dictionary.datamodel.IFirstName;
import com.kirylshreyter.smart_dictionary.datamodel.ILastName;
import com.kirylshreyter.smart_dictionary.datamodel.IUser;

@Entity
@Table(name = "Users")
public class User extends AbstractEntity implements IUser {

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = FirstName.class)
	@JoinColumn(name = "first_name_id", nullable = false)
	private FirstName firstName;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = LastName.class)
	@JoinColumn(name = "last_name_id", nullable = false)
	private LastName lastName;

	@Column(name = "token")
	private String token;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public IFirstName getFirstName() {
		return this.firstName;
	}

	public void setFirstName(IFirstName firstName) {
		this.firstName = (FirstName) firstName;
	}

	public ILastName getLastName() {
		return this.lastName;
	}

	public void setLastName(ILastName lastName) {
		this.lastName = (LastName) lastName;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
