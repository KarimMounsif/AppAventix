package com.qrcodeteam.beans;

public class EmployeQrcodeRest {

	Employe e;
	Qrcode qr;
	
	public EmployeQrcodeRest(Employe e) {
		this.e = e;
	}
	public EmployeQrcodeRest(Qrcode qr) {
		this.qr = qr;
	}
	public EmployeQrcodeRest(Employe e, Qrcode qr) {
		this.e = e;
		this.qr = qr;
	}
	
	
	public Employe getE() {
		return e;
	}
	public void setE(Employe e) {
		this.e = e;
	}
	public Qrcode getQr() {
		return qr;
	}
	public void setQr(Qrcode qr) {
		this.qr = qr;
	}
	
	
	
}
