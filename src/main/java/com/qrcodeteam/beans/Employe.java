package com.qrcodeteam.beans;

import org.joda.time.DateTime;

public class Employe {

	private String idEmploye; 
	private String nomEmploye;
	private String prenomEmploye;
	private String civiliteEmploye;
	private DateTime dateDeNaissanceEmploye;
	private int typeEmploye; 
	private String telEmploye;
	private String mailEmploye;
	private  float soldeEmploye;
	private String loginEmploye;
	private String mdpEmploye;
	private int statusCompteEmploye;
	private DateTime dateCreationCompteEmploye;
	private DateTime dateDerniereConnexionEmploye;
	private String idEntreprise;
	
	// Constructeur(s)
	
	public Employe() {
			
		}
	
	
	public Employe(String idEmploye, String nomEmploye, String prenomEmploye, String civiliteEmploye,
			DateTime dateDeNaissanceEmploye, int typeEmploye, String telEmploye, String mailEmploye, float soldeEmploye,
			 String mdpEmploye, int statusCompteEmploye, DateTime dateCreationCompteEmploye,
			DateTime dateDerniereConnexionEmploye, String idEntreprise) {
	
		this.idEmploye = idEmploye;
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.civiliteEmploye = civiliteEmploye;
		this.dateDeNaissanceEmploye = dateDeNaissanceEmploye;
		this.typeEmploye = typeEmploye;
		this.telEmploye = telEmploye;
		this.mailEmploye = mailEmploye;
		this.soldeEmploye = soldeEmploye;
		this.loginEmploye = loginEmploye;
		this.mdpEmploye = mdpEmploye;
		this.statusCompteEmploye = statusCompteEmploye;
		this.dateCreationCompteEmploye = dateCreationCompteEmploye;
		this.dateDerniereConnexionEmploye = dateDerniereConnexionEmploye;
		this.idEntreprise = idEntreprise;
		
	}
	

	




	// Setters and Getters
	
	public String getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(String idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public String getPrenomEmploye() {
		return prenomEmploye;
	}

	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}

	public String getCiviliteEmploye() {
		return civiliteEmploye;
	}

	public void setCiviliteEmploye(String civiliteEmploye) {
		this.civiliteEmploye = civiliteEmploye;
	}

	public DateTime getDateDeNaissanceEmploye() {
		return dateDeNaissanceEmploye;
	}

	public void setDateDeNaissanceEmploye(DateTime dateDeNaissanceEmploye) {
		this.dateDeNaissanceEmploye = dateDeNaissanceEmploye;
	}

	public int getTypeEmploye() {
		return typeEmploye;
	}

	public void setTypeEmploye(int typeEmploye) {
		this.typeEmploye = typeEmploye;
	}

	public String getTelEmploye() {
		return telEmploye;
	}

	public void setTelEmploye(String telEmploye) {
		this.telEmploye = telEmploye;
	}

	public String getMailEmploye() {
		return mailEmploye;
	}

	public void setMailEmploye(String mailEmploye) {
		this.mailEmploye = mailEmploye;
	}

	public float getSoldeEmploye() {
		return soldeEmploye;
	}

	public void setSoldeEmploye(float soldeEmploye) {
		this.soldeEmploye = soldeEmploye;
	}

	public String getLoginEmploye() {
		return loginEmploye;
	}

	public void setLoginEmploye(String loginEmploye) {
		this.loginEmploye = loginEmploye;
	}

	public String getMdpEmploye() {
		return mdpEmploye;
	}

	public void setMdpEmploye(String mdpEmploye) {
		this.mdpEmploye = mdpEmploye;
	}

	public int getStatusCompteEmploye() {
		return statusCompteEmploye;
	}

	public void setStatusCompteEmploye(int statusCompteEmploye) {
		this.statusCompteEmploye = statusCompteEmploye;
	}

	public DateTime getDateCreationCompteEmploye() {
		return dateCreationCompteEmploye;
	}

	public void setDateCreationCompteEmploye(DateTime dateCreationCompteEmploye) {
		this.dateCreationCompteEmploye = dateCreationCompteEmploye;
	}

	public DateTime getDateDerniereConnexionEmploye() {
		return dateDerniereConnexionEmploye;
	}

	public void setDateDerniereConnexionEmploye(DateTime dateDerniereConnexionEmploye) {
		this.dateDerniereConnexionEmploye = dateDerniereConnexionEmploye;
	}

	public String getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(String idEntreprise) {
		this.idEntreprise = idEntreprise;
	}
	
	
	
	
	
	
}
