package com.abm.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.entity.Account;
import com.abm.exception.BankingException;
import com.abm.service.BankingService;

@Controller
public class BankingController {
	
	@Autowired
	private BankingService bankingService;

	// Spring can automatically copy the data coming from the client in an Object of some class.
	// So no need to use the @RequestParam
	@RequestMapping("/openAccount")
	public String openAccount(Account account,Map<String, Object> model) {
		try {
			int acno = bankingService.openAccount(account);
			model.put("generatedAcno",acno);
			return "confirmation.jsp";
		}catch(BankingException e) {
			return "openAccount.jsp";
		}	
	}
	
	@RequestMapping("/transferMoney")
	public String transfer(@RequestParam("fromAcno") int fromAcno,
						   @RequestParam("toAcno") int toAcno,
						   @RequestParam("amount") double amount) {
		bankingService.transfer(fromAcno, toAcno, amount);
		return "transactionConfirmation.jsp";
	}
	
	
	@RequestMapping("/fetchDetails")
	public String fetchDetails(@RequestParam("acno") int acno,Map<String,Object> model) {
		Account account = bankingService.fetch(acno);
		model.put("account", account);
		return "fetchDeatils.jsp";
	}
	
}
