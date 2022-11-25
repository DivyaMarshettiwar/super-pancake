package com.abm.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String sayHello(Map model) {
		model.put("message", "Welcome to Spring MVC");
		return "hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public ModelAndView sayHello2() {
		ModelAndView mav =new ModelAndView();
		mav.addObject("message", "Welcome to Spring MVC 2");
		mav.setViewName("hello.jsp");
		return mav;
	}

}
