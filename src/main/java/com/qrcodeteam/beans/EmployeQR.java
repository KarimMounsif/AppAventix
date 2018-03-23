package com.qrcodeteam.beans;
public class EmployeQR {
	private Employe e;
	private boolean assignQR=false;
	
	public EmployeQR() {
		e= new Employe();
		assignQR = false;		
	}
	public Employe getE() {
		return e;
	}
	public void setE(Employe e) {
		this.e = e;
	}
	public boolean isAssignQR() {
		return assignQR;
	}
	public void setAssignQR(boolean assignQR) {
		this.assignQR = assignQR;
	}
}