package com.pratice.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleControllerForCssAndJS {
	
	@GetMapping("/example")
	public String example( ) {
		return "example";
	}

}
