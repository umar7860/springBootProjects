package com.pratice.serverValidation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {
	
	@GetMapping("/form")
	public String openForm() {
		return "Loginform";
	}

}
