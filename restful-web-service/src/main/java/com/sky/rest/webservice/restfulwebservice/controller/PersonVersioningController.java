package com.sky.rest.webservice.restfulwebservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sky.rest.webservice.restfulwebservice.versioning.Name;
import com.sky.rest.webservice.restfulwebservice.versioning.PersonV1;
import com.sky.rest.webservice.restfulwebservice.versioning.PersonV2;

@RestController
public class PersonVersioningController {
	/*//@GetMapping("/version1")versioning by different uri
	//@GetMapping(value="version/param",params="version=1")versioning with request param
	public PersonV1 getPersonV1() {
		return new PersonV1("sushil kumar");
	}
	//@GetMapping("/version2")versioning by different uri
	//@GetMapping(value="version/param",params="version=2")versioning with request param
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("sushil","kumar"));
	}*/
	
	//headering versioning OR CONTENT NEGOTIATION OR ACCEPT VERSIONING
	
	@GetMapping(value="version/header",headers="X-API-VERSION=1")
	public PersonV1 getPersonV1() {
		return new PersonV1("sushil kumar");
	}
	@GetMapping(value="version/header",headers="X-API-VERSION=2")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("sushil","kumar"));
	}
	//mime type versioning
	@GetMapping(value="version/produces",produces="application/vnd.company.app-v1+json")
	public PersonV1 producesVesioning1() {
		return new PersonV1("sushil kumar");
	}
	@GetMapping(value="version/produces",produces="application/vnd.company.app-v2+json")
	public PersonV2 producesVesioning12() {
		return new PersonV2(new Name("sushil","kumar"));
	}
	
	

}
