package com.abm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.abm.entity.Account;
import com.abm.entity.Transaction;

@Component
public class BankingDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public int add(Account account) {
		// entityManager.persist(account);
		Account updatedAccount = (Account) entityManager.merge(account);
		return updatedAccount.getAcno();
	}
	
	public void update(Account account) {
		entityManager.merge(account);
	}
	
	public Account fetch(int acno) {
		return entityManager.find(Account.class, acno);
	}
	
	public void add(Transaction transaction) {
		entityManager.merge(transaction);
	}

	public Account fetchDetails(int acno) {
		return (Account) entityManager.createQuery("select distinct a from Account a join fetch a.transactions t where a.acno = :acno")
					 .setParameter("acno", acno)
					 .getSingleResult();
		
	}

	
}
