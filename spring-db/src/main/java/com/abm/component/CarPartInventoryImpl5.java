package com.abm.component;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("carPartInv5")
public class CarPartInventoryImpl5 implements CarPartInventory{
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void addNewPart(CarPart carPart) {
		em.persist(carPart);
	}

	public List<CarPart> getAvailableParts() {
		Query q = em.createQuery("select c from CarPart c");
		List<CarPart> list = q.getResultList();
		return list;
	}

}
