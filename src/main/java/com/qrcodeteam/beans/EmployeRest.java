package com.qrcodeteam.beans;

import org.joda.time.DateTime;

public class EmployeRest extends Employe{
	private float depensesDuJour;

	
	public EmployeRest() {
		super();
	}

		
	public EmployeRest(String idEmploye, String nomEmploye, String prenomEmploye, String civiliteEmploye,
			DateTime ddnEmploye, int typeEmploye, String telEmploye, String mailEmploye, float soldeEmploye,
			float depensesDuJour, String mdpEmploye, int statusCompteEmploye, DateTime dateCreationCompteEmploye,
			DateTime dateDerniereConnexionEmploye, String idEntreprise) {
		
		super(idEmploye, nomEmploye, prenomEmploye, civiliteEmploye, ddnEmploye, typeEmploye, telEmploye, mailEmploye,
				soldeEmploye, mdpEmploye, statusCompteEmploye, dateCreationCompteEmploye, dateDerniereConnexionEmploye,
				idEntreprise);
		this.depensesDuJour = depensesDuJour;
	}


	public float getDepensesDuJour() {
		return depensesDuJour;
	}

	public void setDepensesDuJour(float depensesDuJour) {
		this.depensesDuJour = depensesDuJour;
	}
	
	
}
