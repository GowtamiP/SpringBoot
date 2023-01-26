package com.selfLearn.springboot.rest.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping(path="v1/person")
	public Person1 getFirstVersionOfPerson() {
		return new Person1("Gowtami Patibandla");
	}
	
	@GetMapping(path="v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		
		return new PersonV2(new Name("Gowtami","Patibandla"));
	}
	
	@GetMapping(path="/person", params="version=1")
	public Person1 getFirstVersionOfPersonRequestParam() {
		
		return new Person1("Gowtami Patibandla");
	}
	
	@GetMapping(path="/person", params="version=2")
	public PersonV2 getSecondVersionOfPersonRequestParam() {
		
		return new PersonV2(new Name("Gowtami","Patibandla"));
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=1")
	public Person1 getFirstVersionOfPersonRequestHeader() {
		
		return new Person1("Gowtami Patibandla");
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		
		return new PersonV2(new Name("Gowtami","Patibandla"));
	}
	
	@GetMapping(path="/person/acceptheader", produces="application/vnd.company.app-v1+json")
	public Person1 getFirstVersionOfPersonAcceptHeader() {
		
		return new Person1("Gowtami Patibandla");
	}
	
	@GetMapping(path="/person/acceptheader", produces="application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		
		return new PersonV2(new Name("Gowtami","Patibandla"));
	}

}
