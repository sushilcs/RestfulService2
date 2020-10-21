package com.sky.rest.webservice.restfulwebservice;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServiceApplication.class, args);
	}
	@Bean
	public LocaleResolver localeResolver() {
		// SessionLocalResolver requires locale value to be passed in service param
		//SessionLocaleResolver localResolver=new SessionLocaleResolver();
		AcceptHeaderLocaleResolver resolver=new AcceptHeaderLocaleResolver();
		resolver.setDefaultLocale(Locale.US);
		return resolver;
		
	}
	/*@Bean // this can be set in application.properties
	 * THE BASE LOCATION NEED TO BE CONFIGURED RESOURCEBUNDLEMESSAGESOURCE.JAVA
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
*/}
