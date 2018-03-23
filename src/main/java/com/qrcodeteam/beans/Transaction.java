package com.qrcodeteam.beans;

public class Transaction {

	Commerce c;
	Entreprise e;
	Achat a;
	
	public Transaction(Commerce c, Entreprise e, Achat a) {
		this.c = c;
		this.e = e;
		this.a=a;
	}

	public Commerce getC() {
		return c;
	}

	public void setC(Commerce c) {
		this.c = c;
	}

	public Entreprise getE() {
		return e;
	}

	public void setE(Entreprise e) {
		this.e = e;
	}

	public Achat getA() {
		return a;
	}

	public void setA(Achat a) {
		this.a = a;
	}
	
	
}
