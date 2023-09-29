package com.pratice.serverValidation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pratice.serverValidation.models.LoginData;

import jakarta.validation.Valid;

@Controller
public class MyController {

	@GetMapping("/form")
	public String openForm(Model m) {
		System.out.println("Form is opening");
		m.addAttribute("loginData", new LoginData());
		return "Loginform";
	}

	// Handler for processing Form
	@PostMapping("/process")
	// we use validation
	public String handleForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "Loginform";
		}
		//data processing
		System.out.println(loginData);
		return "success";
	}

}
