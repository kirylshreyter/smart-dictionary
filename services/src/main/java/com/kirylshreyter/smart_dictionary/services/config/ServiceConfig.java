package com.kirylshreyter.smart_dictionary.services.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

// DaoDb configuration
@ComponentScan(basePackageClasses = { com.kirylshreyter.smart_dictionary.daodb.config.DaoDbConfig.class })

// DaoDb implementations
@ComponentScan(basePackageClasses = { com.kirylshreyter.smart_dictionary.daodb.impl.UserDaoDbImpl.class,
		com.kirylshreyter.smart_dictionary.daodb.impl.WordDaoDbImpl.class,
		com.kirylshreyter.smart_dictionary.daodb.impl.TranslationDaoDbImpl.class })
public class ServiceConfig {

}
