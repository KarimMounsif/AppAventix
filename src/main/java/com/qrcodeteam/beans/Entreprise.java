package com.qrcodeteam.beans;

import org.joda.time.DateTime;

public class Entreprise {
	
	private String idEntreprise;
	private String nomEntreprise;
	private String nomService;
	private String codePostalEntreprise;
	private String villeEntreprise;
	private String adresseEntreprise;
	private String mailEntreprise;
	private String telEntreprise;
	private String mdpEntreprise;
	private int statusCompteEntreprise;
	private DateTime dateCreationCompteEntrprise;
	private DateTime dateDerniereConnexionEntreprise;

	private String siretEntreprise;
	private DateTime dateImmatriculationEntreprise;
	private int capitalSocialEntreprise;
	private int effectifEntreprise;
	
	private String idEmploye;
	
	
	
	public Entreprise() {
		
	}
	
	

	public Entreprise(String idEntreprise, String nomEntreprise, String nomService, String codePostalEntreprise,
			String villeEntreprise, String adresseEntreprise, String mailEntreprise, String telEntreprise,
			String mdpEntreprise, int statusCompteEntreprise, DateTime dateCreationCompteEntrprise,
			DateTime dateDerniereConnexionEntreprise, String idEmploye, String siretEntreprise, DateTime dateImmatriculationEntreprise,int capitalSocialEntreprise, int effectifEntreprise) {
		super();
		this.idEntreprise = idEntreprise;
		this.nomEntreprise = nomEntreprise;
		this.nomService = nomService;
		this.codePostalEntreprise = codePostalEntreprise;
		this.villeEntreprise = villeEntreprise;
		this.adresseEntreprise = adresseEntreprise;
		this.mailEntreprise = mailEntreprise;
		this.telEntreprise = telEntreprise;
		this.mdpEntreprise = mdpEntreprise;
		this.statusCompteEntreprise = statusCompteEntreprise;
		this.dateCreationCompteEntrprise = dateCreationCompteEntrprise;
		this.dateDerniereConnexionEntreprise = dateDerniereConnexionEntreprise;
		this.idEmploye = idEmploye;
		this.siretEntreprise=siretEntreprise;
		this.dateImmatriculationEntreprise=dateImmatriculationEntreprise;
		this.capitalSocialEntreprise=capitalSocialEntreprise;
		this.effectifEntreprise=effectifEntreprise;
	}



	public String getIdEntreprise() {
		return idEntreprise;
	}



	public void setIdEntreprise(String idEntreprise) {
		this.idEntreprise = idEntreprise;
	}



	public String getNomEntreprise() {
		return nomEntreprise;
	}



	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}



	public String getNomService() {
		return nomService;
	}



	public void setNomService(String nomService) {
		this.nomService = nomService;
	}



	public String getCodePostalEntreprise() {
		return codePostalEntreprise;
	}



	public void setCodePostalEntreprise(String codePostalEntreprise) {
		this.codePostalEntreprise = codePostalEntreprise;
	}



	public String getVilleEntreprise() {
		return villeEntreprise;
	}



	public void setVilleEntreprise(String villeEntreprise) {
		this.villeEntreprise = villeEntreprise;
	}



	public String getAdresseEntreprise() {
		return adresseEntreprise;
	}



	public void setAdresseEntreprise(String adresseEntreprise) {
		this.adresseEntreprise = adresseEntreprise;
	}



	public String getMailEntreprise() {
		return mailEntreprise;
	}



	public void setMailEntreprise(String mailEntreprise) {
		this.mailEntreprise = mailEntreprise;
	}



	public String getTelEntreprise() {
		return telEntreprise;
	}



	public void setTelEntreprise(String telEntreprise) {
		this.telEntreprise = telEntreprise;
	}



	public String getMdpEntreprise() {
		return mdpEntreprise;
	}



	public void setMdpEntreprise(String mdpEntreprise) {
		this.mdpEntreprise = mdpEntreprise;
	}



	public int getStatusCompteEntreprise() {
		return statusCompteEntreprise;
	}



	public void setStatusCompteEntreprise(int statusCompteEntreprise) {
		this.statusCompteEntreprise = statusCompteEntreprise;
	}



	public DateTime getDateCreationCompteEntrprise() {
		return dateCreationCompteEntrprise;
	}



	public void setDateCreationCompteEntrprise(DateTime dateCreationCompteEntrprise) {
		this.dateCreationCompteEntrprise = dateCreationCompteEntrprise;
	}



	public DateTime getDateDerniereConnexionEntreprise() {
		return dateDerniereConnexionEntreprise;
	}



	public void setDateDerniereConnexionEntreprise(DateTime dateDerniereConnexionEntreprise) {
		this.dateDerniereConnexionEntreprise = dateDerniereConnexionEntreprise;
	}



	public String getIdEmploye() {
		return idEmploye;
	}



	public void setIdEmploye(String idEmploye) {
		this.idEmploye = idEmploye;
	}



	public String getSiretEntreprise() {
		return siretEntreprise;
	}



	public void setSiretEntreprise(String siretEntreprise) {
		this.siretEntreprise = siretEntreprise;
	}



	public DateTime getDateImmatriculationEntreprise() {
		return dateImmatriculationEntreprise;
	}



	public void setDateImmatriculationEntreprise(DateTime dateImmatriculationEntreprise) {
		this.dateImmatriculationEntreprise = dateImmatriculationEntreprise;
	}



	public int getCapitalSocialEntreprise() {
		return capitalSocialEntreprise;
	}



	public void setCapitalSocialEntreprise(int capitalSocialEntreprise) {
		this.capitalSocialEntreprise = capitalSocialEntreprise;
	}



	public int getEffectifEntreprise() {
		return effectifEntreprise;
	}



	public void setEffectifEntreprise(int effectifEntreprise) {
		this.effectifEntreprise = effectifEntreprise;
	}
	
	
	
	


}
