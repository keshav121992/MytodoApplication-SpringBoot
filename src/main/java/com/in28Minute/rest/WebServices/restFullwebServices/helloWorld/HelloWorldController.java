package com.in28Minute.rest.WebServices.restFullwebServices.helloWorld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/helloWorld")
	public String  helloWorld(){
		return "Hello World";
	}
	
	@GetMapping(path = "/helloWorldBean")
	public HelloWorldBean helloBean(){
		 //throw new RuntimeException("Some Error Has happened! Contact Admin Support!");
		return new HelloWorldBean("Hello World  KESHAV");
	}
	
	@GetMapping(path = "/helloWord/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
		return new HelloWorldBean (String.format("Hello Spring World, %s", name));
	}

}
