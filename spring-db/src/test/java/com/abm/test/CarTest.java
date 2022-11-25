package com.abm.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abm.component.CarPart;
import com.abm.component.CarPartInventory;
import com.abm.component.CarPartInventoryImpl1;
import com.abm.component.CarPartInventoryImpl2;
import com.abm.component.CarPartInventoryImpl3;
import com.abm.component.CarPartInventoryImpl4;
import com.abm.component.CarPartInventoryImpl5;

public class CarTest {

	@Test
	public void test_adding_CarPart() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		// CarPartInventory cpInv = ctx.getBean(CarPartInventoryImpl1.class);
		// CarPartInventory cpInv = ctx.getBean(CarPartInventoryImpl2.class);
		// CarPartInventory cpInv = ctx.getBean(CarPartInventoryImpl3.class);
		// CarPartInventory cpInv = ctx.getBean(CarPartInventoryImpl4.class);
		CarPartInventory cpInv = (CarPartInventory) ctx.getBean("carPartInv5");
		
		CarPart cp = new CarPart();
		cp.setPartName("Mirror");
		cp.setCarModel("Ferrari");
		cp.setPrice(400);
		cp.setQuantity(50);
		
		cpInv.addNewPart(cp);
	}
	
	@Test
	public void fetch_carPart(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		// CarPartInventory cpInv = ctx.getBean(CarPartInventoryImpl1.class);
		// CarPartInventory cpInv = ctx.getBean(CarPartInventoryImpl2.class);
		// CarPartInventory cpInv = ctx.getBean(CarPartInventoryImpl3.class);
		// CarPartInventory cpInv = ctx.getBean(CarPartInventoryImpl4.class);
		CarPartInventory cpInv = (CarPartInventory) ctx.getBean("carPartInv5");
		
		List<CarPart> list =cpInv.getAvailableParts();
		for (CarPart cp : list) {
			System.out.println("Car Part No. : " + cp.getPartNo());
			System.out.println("Car Part Name : " + cp.getPartName());
			System.out.println("Car Model : " + cp.getCarModel());
			System.out.println("Car Price : " + cp.getPrice());
			System.out.println("Car Quantity : " + cp.getQuantity());
			System.out.println("*****************************");
		}
		
	}
}
