package com.qrcodeteam.bom;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qrcodeteam.utils.DateTimeSerializer;
import org.joda.time.DateTime;

public class Gerant {

	private String idGerant;
	private String nomGerant;
	private String prenomGerant;
	private String mailGerant;
	private String telGerant;
	private String adresseGerant;
	private String codePostalGerant;
	private String villeGerant;
	private String civiliteGerant;
	private String mdpGerant;
	@JsonSerialize(using = DateTimeSerializer.class)
	private DateTime dateCreationCompteGerant;
	@JsonSerialize(using = DateTimeSerializer.class)
	private DateTime dateDerniereConnexionGerant;
	@JsonSerialize(using = DateTimeSerializer.class)
	private DateTime ddnGerant;
	private int statusCompteGerant;
	
	// Constructeur(s)
	public Gerant () {
		
	}
	
	public Gerant(String idGerant, String nomGerant, String prenomGerant, String mailGerant, String telGerant,
			String adresseGerant, String codePostalGerant, String villeGerant, String civiliteGerant, String mdpGerant,
			DateTime dateCreationCompteGerant, DateTime dateDerniereConnexionGerant,DateTime ddnGerant,int statusCompteGerant) {
		super();
		this.idGerant = idGerant;
		this.nomGerant = nomGerant;
		this.prenomGerant = prenomGerant;
		this.mailGerant = mailGerant;
		this.telGerant = telGerant;
		this.adresseGerant = adresseGerant;
		this.codePostalGerant = codePostalGerant;
		this.villeGerant = villeGerant;
		this.civiliteGerant = civiliteGerant;
		this.mdpGerant = mdpGerant;
		this.dateCreationCompteGerant = dateCreationCompteGerant;
		this.dateDerniereConnexionGerant = dateDerniereConnexionGerant;
		this.ddnGerant=ddnGerant;
		this.statusCompteGerant=statusCompteGerant;
	}

	
	
	public String getIdGerant() {
		return idGerant;
	}

	public void setIdGerant(String idGerant) {
		this.idGerant = idGerant;
	}

	public String getNomGerant() {
		return nomGerant;
	}

	public void setNomGerant(String nomGerant) {
		this.nomGerant = nomGerant;
	}

	public String getPrenomGerant() {
		return prenomGerant;
	}

	public void setPrenomGerant(String prenomGerant) {
		this.prenomGerant = prenomGerant;
	}

	public String getMailGerant() {
		return mailGerant;
	}

	public void setMailGerant(String mailGerant) {
		this.mailGerant = mailGerant;
	}

	public String getTelGerant() {
		return telGerant;
	}

	public void setTelGerant(String telGerant) {
		this.telGerant = telGerant;
	}

	public String getAdresseGerant() {
		return adresseGerant;
	}

	public void setAdresseGerant(String adresseGerant) {
		this.adresseGerant = adresseGerant;
	}

	public String getCodePostalGerant() {
		return codePostalGerant;
	}

	public void setCodePostalGerant(String codePostalGerant) {
		this.codePostalGerant = codePostalGerant;
	}

	public String getVilleGerant() {
		return villeGerant;
	}

	public void setVilleGerant(String villeGerant) {
		this.villeGerant = villeGerant;
	}

	public String getCiviliteGerant() {
		return civiliteGerant;
	}

	public void setCiviliteGerant(String civiliteGerant) {
		this.civiliteGerant = civiliteGerant;
	}

	public String getMdpGerant() {
		return mdpGerant;
	}

	public void setMdpGerant(String mdpGerant) {
		this.mdpGerant = mdpGerant;
	}

	public DateTime getDateCreationCompteGerant() {
		return dateCreationCompteGerant;
	}

	public void setDateCreationCompteGerant(String dateCreationCompteGerant) {
		this.dateCreationCompteGerant = new DateTime(dateCreationCompteGerant);
	}

	public DateTime getDateDerniereConnexionGerant() {
		return dateDerniereConnexionGerant;
	}

	public void setDateDerniereConnexionGerant(String dateDerniereConnexionGerant) {
		this.dateDerniereConnexionGerant = new DateTime(dateDerniereConnexionGerant);
	}

	public int getStatusCompteGerant() {
		return statusCompteGerant;
	}

	public void setStatusCompteEmploye(int statusCompteGerant) {
		this.statusCompteGerant = statusCompteGerant;
	}

	public DateTime getDdnGerant() {
		return ddnGerant;
	}

	public void setDdnGerant(String ddnGerant) {
		this.ddnGerant = new DateTime(ddnGerant);
	}

	public void setStatusCompteGerant(int statusCompteGerant) {
		this.statusCompteGerant = statusCompteGerant;
	}
	
	
	
	
}
