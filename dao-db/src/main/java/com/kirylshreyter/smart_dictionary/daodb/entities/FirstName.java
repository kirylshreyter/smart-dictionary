package com.kirylshreyter.smart_dictionary.daodb.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kirylshreyter.smart_dictionary.datamodel.IFirstName;
import com.kirylshreyter.smart_dictionary.datamodel.IUser;

@Entity
@Table(name = "First_names")
public class FirstName extends AbstractEntity implements IFirstName {

	@Column(name = "value")
	private String value;

	@OneToMany(mappedBy = "firstName")
	private Set<User> users;

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Set<IUser> getUsers() {
		Set<IUser> result = new HashSet<IUser>();
		this.users.forEach((user) -> {
			result.add(user);
		});
		return result;
	}

}
