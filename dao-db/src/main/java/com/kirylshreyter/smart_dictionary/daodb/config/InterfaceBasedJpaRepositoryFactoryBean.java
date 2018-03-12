package com.kirylshreyter.smart_dictionary.daodb.config;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class InterfaceBasedJpaRepositoryFactoryBean<T extends Repository<S, ID>, S, ID>
		extends JpaRepositoryFactoryBean<T, S, ID> {
	public InterfaceBasedJpaRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
		super(repositoryInterface);
	}

	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new InterfaceBasedJpaRepositoryFactory(entityManager);
	}

}
