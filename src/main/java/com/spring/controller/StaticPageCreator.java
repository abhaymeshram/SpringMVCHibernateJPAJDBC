package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticPageCreator {
	
	@RequestMapping(value= "/static/{id}", method = RequestMethod.GET)
	public String addPerson(@PathVariable("id") int id, Model model){
		model.addAttribute("url", "www.eclaveengineering.com");
		model.addAttribute("description","UPSC Example");
		model.addAttribute("id",id);
		return "static";
		
	}

}
