package com.qrcodeteam.beans;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qrcodeteam.utilitaire.DateTimeSerializer;

public class Commerce {

	private String idCommerce;
	private String siretCommerce;
	private String nomCommerce;
	private String adresseCommerce;
	private String codePostalCommerce;
	private String villeCommerce;
	private String telCommerce;
	private String mailCommerce;
	private String ribCommerce;
	private String descriptionCommerce;
	private String idGerant;
	private String typeCommerce;
	private int statusCompteCommerce;
	private int capitalSocialCommerce;
	private int effectifCommerce;
	@JsonSerialize(using = DateTimeSerializer.class)
	private DateTime dateImmatriculationCommerce;
	
	
	
	public Commerce() {
		
	}



	public Commerce(String idCommerce, String siretCommerce, String nomCommerce, String adresseCommerce,
			String codePostalCommerce, String villeCommerce, String telCommerce, String mailCommerce,
			String ribCommerce, String descriptionCommerce, String idGerant, String typeCommerce, int statusCompteCommerce,
			int capitalSocialCommerce, int effectifCommerce, DateTime dateImmatriculationCommerce) {
		this.idCommerce = idCommerce;
		this.siretCommerce = siretCommerce;
		this.nomCommerce = nomCommerce;
		this.adresseCommerce = adresseCommerce;
		this.codePostalCommerce = codePostalCommerce;
		this.villeCommerce = villeCommerce;
		this.telCommerce = telCommerce;
		this.mailCommerce = mailCommerce;
		this.ribCommerce = ribCommerce;
		this.descriptionCommerce = descriptionCommerce;
		this.idGerant = idGerant;
		this.typeCommerce = typeCommerce;
		this.statusCompteCommerce = statusCompteCommerce;
		this.capitalSocialCommerce = capitalSocialCommerce;
		this.effectifCommerce = effectifCommerce;
		this.dateImmatriculationCommerce = dateImmatriculationCommerce;
	}



	public String getIdCommerce() {
		return idCommerce;
	}



	public void setIdCommerce(String idCommerce) {
		this.idCommerce = idCommerce;
	}



	public String getSiretCommerce() {
		return siretCommerce;
	}



	public void setSiretCommerce(String siretCommerce) {
		this.siretCommerce = siretCommerce;
	}



	public String getNomCommerce() {
		return nomCommerce;
	}



	public void setNomCommerce(String nomCommerce) {
		this.nomCommerce = nomCommerce;
	}



	public String getAdresseCommerce() {
		return adresseCommerce;
	}



	public void setAdresseCommerce(String adresseCommerce) {
		this.adresseCommerce = adresseCommerce;
	}



	public String getCodePostalCommerce() {
		return codePostalCommerce;
	}



	public void setCodePostalCommerce(String codePostalCommerce) {
		this.codePostalCommerce = codePostalCommerce;
	}



	public String getVilleCommerce() {
		return villeCommerce;
	}



	public void setVilleCommerce(String villeCommerce) {
		this.villeCommerce = villeCommerce;
	}



	public String getTelCommerce() {
		return telCommerce;
	}



	public void setTelCommerce(String telCommerce) {
		this.telCommerce = telCommerce;
	}



	public String getMailCommerce() {
		return mailCommerce;
	}



	public void setMailCommerce(String mailCommerce) {
		this.mailCommerce = mailCommerce;
	}



	public String getRibCommerce() {
		return ribCommerce;
	}



	public void setRibCommerce(String ribCommerce) {
		this.ribCommerce = ribCommerce;
	}



	public String getDescriptionCommerce() {
		return descriptionCommerce;
	}



	public void setDescriptionCommerce(String descriptionCommerce) {
		this.descriptionCommerce = descriptionCommerce;
	}



	public String getIdGerant() {
		return idGerant;
	}



	public void setIdGerant(String idGerant) {
		this.idGerant = idGerant;
	}



	public String getTypeCommerce() {
		return typeCommerce;
	}



	public void setTypeCommerce(String typeCommerce) {
		this.typeCommerce = typeCommerce;
	}



	public int getStatusCompteCommerce() {
		return statusCompteCommerce;
	}



	public void setStatusCompteCommerce(int statusCompteCommerce) {
		this.statusCompteCommerce = statusCompteCommerce;
	}



	public int getCapitalSocialCommerce() {
		return capitalSocialCommerce;
	}



	public void setCapitalSocialCommerce(int capitalSocialCommerce) {
		this.capitalSocialCommerce = capitalSocialCommerce;
	}



	public int getEffectifCommerce() {
		return effectifCommerce;
	}



	public void setEffectifCommerce(int effectifCommerce) {
		this.effectifCommerce = effectifCommerce;
	}



	public DateTime getDateImmatriculationCommerce() {
		return dateImmatriculationCommerce;
	}



	public void setDateImmatriculationCommerce(String dateImmatriculationCommerce) {
		this.dateImmatriculationCommerce = new DateTime(dateImmatriculationCommerce);
	}
	
	
	
	
	
}


