package com.pratice.thymeleaf.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	//this is for handling loops
	@GetMapping("/example-loop")
	public String iterateHandler(Model m) {
		//Create a List,set collection... 
		//Every object that extends from iterable class
		
		List<String> names = List.of("Umar","Ali","Momina","Faiz");
		m.addAttribute("names",names);
		
		return "iterate";
	}
	
	//This is for conditional statements
	@GetMapping("/condition")
	public String conditionHandler(Model m) {
		System.out.println("Conditional Handler Executed");
		m.addAttribute("isActive",false);
		m.addAttribute("gender",'M');
		
		List<Integer> list = List.of(12,34,55);
		m.addAttribute("mylist",list);
		return "condition";
	}
	
	//This is a handler for including thymeleaf fragment
	
	@GetMapping("/service")
	public String servicesHandler(Model m) {
		return "service";
	}

}
