package com.pratice.thymeleaf.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	@RequestMapping(value = "/about",method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("Inside about handler");
		
		//putting data in model
		
		model.addAttribute("name","Umar");
		model.addAttribute("currentDate",String.valueOf(new Date()));
		
		//return the name of html page
		return "about";
	}

}
