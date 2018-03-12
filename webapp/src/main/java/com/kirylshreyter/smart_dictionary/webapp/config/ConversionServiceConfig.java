package com.kirylshreyter.smart_dictionary.webapp.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.kirylshreyter.smart_dictionary.webapp.converters.UserModelToUserConverter;
import com.kirylshreyter.smart_dictionary.webapp.converters.UserToUserModelConverter;
import com.kirylshreyter.smart_dictionary.webapp.converters.WordModelToWordConverter;
import com.kirylshreyter.smart_dictionary.webapp.converters.WordToWordModelConverter;

@Configuration
public class ConversionServiceConfig {

	@Bean(name = "conversionService")
	public ConversionService getConversionService() {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
		bean.setConverters(getConverters());
		bean.afterPropertiesSet();
		ConversionService object = bean.getObject();
		return object;
	}

	@SuppressWarnings("rawtypes")
	private Set<Converter> getConverters() {
		Set<Converter> converters = new HashSet<Converter>();
		converters.add(new UserToUserModelConverter());
		converters.add(new UserModelToUserConverter());
		converters.add(new WordToWordModelConverter());
		converters.add(new WordModelToWordConverter());
		return converters;
	}

}
