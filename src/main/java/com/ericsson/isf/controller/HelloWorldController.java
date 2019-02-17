package com.ericsson.isf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("message","APIs are up. Please! go to the specified Handlers.");
		return "welcome";
	}
	
	@RequestMapping(value = "/hello/{user}/{gender}",method = RequestMethod.GET)
	public String helloUser(@PathVariable("user") String user,@PathVariable("gender") char gender,ModelMap model) {
		if(gender == 'M'||gender == 'm')
			model.addAttribute("message","Welcome again from Spring MVC <br>Mr. "+user);
		else
			model.addAttribute("message","Welcome again from Spring MVC <br>Miss "+user);
		return "welcome";
	}
}