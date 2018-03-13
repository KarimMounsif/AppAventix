package com.qrcodeteam.beans;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qrcodeteam.utilitaire.DateTimeSerializer;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({ "ddnEmploye", "dateCreationCompteEmploye" })
public class Employe {

	private String idEmploye; 
	private String nomEmploye;
	private String prenomEmploye;
	private String civiliteEmploye;
	@JsonSerialize(using = DateTimeSerializer.class)
	private DateTime ddnEmploye;
	private int typeEmploye; 
	private String telEmploye;
	private String mailEmploye;
	private float soldeEmploye;
	//private float depensesDuJour;                  // 07/03 Karim : Ajout de cet attribut  | Constructeur modifié | ajout get et set | ajout colonne correspondante dans la BD
	private String mdpEmploye;
	private int statusCompteEmploye;
	@JsonSerialize(using = DateTimeSerializer.class)
	private DateTime dateCreationCompteEmploye;
	@JsonSerialize(using = DateTimeSerializer.class)
	private DateTime dateDerniereConnexionEmploye;
	private String idEntreprise;
	
	
	// Constructeur(s)
	
	public Employe() {
			
		}
	
	
	public Employe(String idEmploye, String nomEmploye, String prenomEmploye, String civiliteEmploye,
			DateTime ddnEmploye, int typeEmploye, String telEmploye, String mailEmploye, float soldeEmploye, /*float depensesDuJour,*/
			 String mdpEmploye, int statusCompteEmploye, DateTime dateCreationCompteEmploye,
			DateTime dateDerniereConnexionEmploye, String idEntreprise) {
	
		this.idEmploye = idEmploye;
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.civiliteEmploye = civiliteEmploye;
		this.ddnEmploye = ddnEmploye;
		this.typeEmploye = typeEmploye;
		this.telEmploye = telEmploye;
		this.mailEmploye = mailEmploye;
		this.soldeEmploye = soldeEmploye;
		//this.depensesDuJour = depensesDuJour;
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

	public DateTime getDdnEmploye() {
		return ddnEmploye;
	}

	public void setDdnEmploye(String ddnEmploye) {
		this.ddnEmploye = new DateTime(ddnEmploye);
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

	public void setDateCreationCompteEmploye(String dateCreationCompteEmploye) {      // Karim // Modification du setter 
		this.dateCreationCompteEmploye = new DateTime(dateCreationCompteEmploye);
	}

	public DateTime getDateDerniereConnexionEmploye() {
		return dateDerniereConnexionEmploye;
	}

	public void setDateDerniereConnexionEmploye(String dateDerniereConnexionEmploye) {   // Karim // Modification du setter
		this.dateDerniereConnexionEmploye = new DateTime(dateDerniereConnexionEmploye);
	}

	public String getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(String idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	/*
	public float getDepensesDuJour() {
		return depensesDuJour;
	}


	public void setDepensesDuJour(float depensesDuJour) {
		this.depensesDuJour = depensesDuJour;
	}
	*/
	
	
	
	
	
}
