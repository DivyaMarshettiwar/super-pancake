package com.abm.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abm.dao.BankingDao;
import com.abm.entity.Account;
import com.abm.entity.Transaction;
import com.abm.exception.BankingException;

@Component
// @Service (recommended)
@Transactional
public class BankingService {

	@Autowired
	private BankingDao bankingDao;
	
	public int openAccount(Account account) throws BankingException {
		if(account.getBalance() >= 5000) {
			return bankingDao.add(account);
		}else {
			throw new BankingException("Cannot open Account ! ");
		}
	}
	
	
	public void transfer(int fromAcno, int toAcno, double amount) {
		Account fromAccount = bankingDao.fetch(fromAcno);
		Account toAccount = bankingDao.fetch(toAcno);
		
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);
		
		bankingDao.update(fromAccount);
		bankingDao.update(toAccount);
		
		Transaction t1 = new Transaction();
		t1.setAccount(fromAccount);
		t1.setType("DEBIT");
		t1.setDate(LocalDateTime.now());
		t1.setAmount(amount);
		
		Transaction t2 = new Transaction();
		t2.setAccount(toAccount);
		t2.setType("CREDIT");
		t2.setDate(LocalDateTime.now());
		t2.setAmount(amount);
		
		bankingDao.add(t1);
		bankingDao.add(t2);
	}


	public Account fetch(int acno) {
		Account acc = bankingDao.fetchDetails(acno);
		return acc;
	}
}
