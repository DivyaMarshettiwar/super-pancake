package com.abm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.entity.Account;
import com.abm.service.BankingService;

@RestController
public class BankingRestController {

	@Autowired
	private BankingService bankingService;

	
	@RequestMapping("/fetchDetailsRest")
	public Account fetchDetails(@RequestParam("acno") int acno) {
		return bankingService.fetch(acno);
		
	}
}
