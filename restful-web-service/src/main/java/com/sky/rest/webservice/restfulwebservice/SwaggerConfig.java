package com.sky.rest.webservice.restfulwebservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	 public static final Contact DEFAULT_CONTACT
     = new Contact(
     "sushil kumar yadav",
     "EMIDS TECHNOLOGIES BANGLORE,INDIA",
     "sushilk@emids.com");
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
		 new HashSet<>(Arrays.asList("application/xml","application/json"));

	@Bean
	public Docket api() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2);
		return docket.apiInfo(getInfo()).produces(DEFAULT_PRODUCES_AND_CONSUMES).consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}

	@Bean 
	public ApiInfo getInfo() {
		return new ApiInfo("Restful micro service in java", "Documentation for the client", "1.0",
				"you need to be my friend to use this api.", DEFAULT_CONTACT, "Apache 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
	}

}
