package com.qrcodeteam.bom;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"e", "qr"})
public class EmployeQrCodeRest {
	
	public Employe e;
    private Qrcode qr;
	
	public EmployeQrCodeRest(Employe e) {
		this.e = e;
	}
	public EmployeQrCodeRest(Qrcode qr) {
		this.qr = qr;
	}
	public EmployeQrCodeRest(Employe e, Qrcode qr) {
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


