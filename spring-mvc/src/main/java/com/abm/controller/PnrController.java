package com.abm.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.entity.Passenger;
import com.abm.entity.Passenger.Gender;
import com.abm.entity.Passenger.Status;
import com.abm.entity.Pnr;

// assumption : we are working for IRCTC
@RestController
public class PnrController {

	@RequestMapping("/pnr-status")
	public Pnr checkPnrStatus(@RequestParam("pnrNo") int pnrNo){
		Pnr pnr = new Pnr();
		pnr.setPnrNo(pnrNo);
		pnr.setTrainNo(12345);
		pnr.setTravelDate(LocalDate.of(2022, 11, 30));
		
		List<Passenger> passengers = new ArrayList<>();
		
		Passenger p1 = new Passenger();
		p1.setName("Ram");
		p1.setGender(Gender.MALE);
		p1.setStatus(Status.RAC);
		
		Passenger p2 = new Passenger();
		p2.setName("Shyam");
		p2.setGender(Gender.MALE);
		p2.setStatus(Status.CONFIRMED);
		
		passengers.add(p1);
		passengers.add(p2);
		
		pnr.setPassengers(passengers);
		
		return pnr;
	}
}
