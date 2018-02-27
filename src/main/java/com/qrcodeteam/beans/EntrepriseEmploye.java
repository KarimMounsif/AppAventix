package com.qrcodeteam.beans;

public class EntrepriseEmploye {

	
	Entreprise en;
	Employe em;
	
	
	
	public EntrepriseEmploye(Entreprise en, Employe em) {
		this.en=en;
		this.em=em;
	}
	
	
	public EntrepriseEmploye() {
		
	}


	public Entreprise getEn() {
		return en;
	}


	public void setEn(Entreprise en) {
		this.en = en;
	}


	public Employe getEm() {
		return em;
	}


	public void setEm(Employe em) {
		this.em = em;
	}
	
	
}
