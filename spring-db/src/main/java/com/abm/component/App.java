package com.abm.component;

public class App {

	public static void main(String[] args) {
		
		CarPart cp = new CarPart();
		cp.setPartNo(4);
		
		CarPartInventory c = new CarPartInventoryImpl1();
		c.addNewPart(cp);

	}

}
