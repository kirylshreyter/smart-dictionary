package com.kirylshreyter.smart_dictionary.webapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kirylshreyter.smart_dictionary.webapp.converters.StringToAuthHeaderConverter;

@Configuration
@EnableWebMvc

// Conversion service configuration
@ComponentScan(basePackageClasses = { com.kirylshreyter.smart_dictionary.webapp.config.ConversionServiceConfig.class })

// Another configuration
@ComponentScan(basePackageClasses = { com.kirylshreyter.smart_dictionary.services.config.ServiceConfig.class })

// Services
@ComponentScan(basePackageClasses = { com.kirylshreyter.smart_dictionary.services.impl.UserServiceImpl.class,
		com.kirylshreyter.smart_dictionary.services.impl.AuthenticationServiceImpl.class,
		com.kirylshreyter.smart_dictionary.services.impl.WordServiceImpl.class,
		com.kirylshreyter.smart_dictionary.services.impl.TranslationServiceImpl.class })

// Controllers
@ComponentScan(basePackageClasses = { com.kirylshreyter.smart_dictionary.webapp.controllers.api.v1.UserController.class,
		com.kirylshreyter.smart_dictionary.webapp.controllers.AuthenticationController.class,
		com.kirylshreyter.smart_dictionary.webapp.controllers.api.v1.WordController.class })
public class WebappConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToAuthHeaderConverter());
	}

}
