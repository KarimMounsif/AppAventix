package com.qrcodeteam.bom;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"g", "c"})
public class CommerceGerant {

	private Commerce c;
	private Gerant g;
	
	public CommerceGerant() {
		
	}
	
	public CommerceGerant(Commerce c, Gerant g) {
		this.c = c;
		this.g = g;
	}

	public Commerce getC() {
		return c;
	}

	public void setC(Commerce c) {
		this.c = c;
	}

	public Gerant getG() {
		return g;
	}

	public void setG(Gerant g) {
		this.g = g;
	}
	
	
	
	
	
}
