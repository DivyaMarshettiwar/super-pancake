package com.abm.dto;

public class RegistrationStatus {

	private String statusMessage;
	private boolean status;
	private int registeredCustomerId;
	
	
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getRegisteredCustomerId() {
		return registeredCustomerId;
	}
	public void setRegisteredCustomerId(int registeredCustomerId) {
		this.registeredCustomerId = registeredCustomerId;
	}
	
	
}
