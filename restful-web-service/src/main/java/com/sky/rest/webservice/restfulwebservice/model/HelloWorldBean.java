package com.sky.rest.webservice.restfulwebservice.model;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldBean {
	
	String message;

	public String getMessage() {
		return message;
	}
	@Value(value = "helloWorld")
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	

}
