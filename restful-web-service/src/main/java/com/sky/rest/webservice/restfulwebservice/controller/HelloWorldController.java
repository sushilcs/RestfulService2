package com.sky.rest.webservice.restfulwebservice.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.rest.webservice.restfulwebservice.model.HelloWorldBean;;
@Controller
public class HelloWorldController {
	@Autowired
	HelloWorldBean bean;
	@Autowired
	MessageSource messageSource;
	
	@GetMapping("/hello-world")
	@ResponseBody
	public String helloWorld() {

		return "hello world";

	}
	@GetMapping("/hello-world-bean")
	@ResponseBody
	public HelloWorldBean helloWorldBean() {

		return bean;

	}
	@GetMapping(value="/hello-world-bean/{name}")
	@ResponseBody
	public String helloWorlwihtPath(@PathVariable("name")String name) {

		return bean.toString()+name;

	}
	@GetMapping("/hello-world/international")
	@ResponseBody
	 // this method requires locale to be passed in method param if use SeesionLocaleResolver
	//public String helloWorlInternationalized(@RequestHeader(name="Accept-Language",required=false) Locale locale)
	     public String helloWorlInternationalized(){
     
		return messageSource.getMessage("good.morning.message",null,LocaleContextHolder.getLocale());

	}

}

