package com.abm.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {

	@RequestMapping("/result")
	public String calculate(@RequestParam("no1") int no1,
							@RequestParam("no2") int no2,
							Map model) {
		int result = no1 + no2;
		model.put("no1", no1);
		model.put("no2", no2);
		model.put("result", result);
		return "calc.jsp";
	}
}
