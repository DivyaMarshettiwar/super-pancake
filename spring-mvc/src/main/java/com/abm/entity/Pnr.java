package com.abm.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Pnr {

	private int pnrNo;
	private int trainNo;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate travelDate;
	
	private List<Passenger> passengers;

	public int getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(int pnrNo) {
		this.pnrNo = pnrNo;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	
}
