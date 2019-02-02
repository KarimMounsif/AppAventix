package com.qrcodeteam.bom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

public class Qrcode {

	@JsonIgnore
	private String idQrcode;
	private int statusQrCode;
	private String numeroCode;
	@JsonIgnore
	private float prixQrCode;
	@JsonIgnore
	private String idEntreprise;
	private String idEmploye;
	@JsonIgnore
	private String idCommande;
	@JsonIgnore
	private DateTime dateCreationQrCode;
	
	// constructeur no init id Employe
	public Qrcode(String idQrcode, int statusQrCode, String numeroCode, float prixQrCode, String idEntreprise,
			String idCommande, DateTime dateCreationQrCode) {
		this.idQrcode = idQrcode;
		this.statusQrCode = statusQrCode;
		this.numeroCode = numeroCode;
		this.prixQrCode = prixQrCode;
		this.idEntreprise = idEntreprise;
		this.idCommande = idCommande;
		this.dateCreationQrCode = dateCreationQrCode;
	}

	// Constructeur par defaut

	public Qrcode() {
		
	}

	// constructeur general init tous les champs
	
	public Qrcode(String idQrcode, int statusQrCode, String numeroCode, float prixQrCode, String idEntreprise,
			String idEmploye, String idCommande, DateTime dateCreationQrCode) {
		this.idQrcode = idQrcode;
		this.statusQrCode = statusQrCode;
		this.numeroCode = numeroCode;
		this.prixQrCode = prixQrCode;
		this.idEntreprise = idEntreprise;
		this.idEmploye = idEmploye;
		this.idCommande = idCommande;
		this.dateCreationQrCode = dateCreationQrCode;
	}
	
	
	

	public String getIdQrcode() {
		return idQrcode;
	}

	public void setIdQrcode(String idQrcode) {
		this.idQrcode = idQrcode;
	}

	public int getStatusQrCode() {
		return statusQrCode;
	}

	public void setStatusQrCode(int statusQrCode) {
		this.statusQrCode = statusQrCode;
	}

	public String getNumeroCode() {
		return numeroCode;
	}

	public void setNumeroCode(String numeroCode) {
		this.numeroCode = numeroCode;
	}

	public float getPrixQrCode() {
		return prixQrCode;
	}

	public void setPrixQrCode(float prixQrCode) {
		this.prixQrCode = prixQrCode;
	}

	public String getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(String idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public String getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(String idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(String idCommande) {
		this.idCommande = idCommande;
	}

	public DateTime getDateCreationQrCode() {
		return dateCreationQrCode;
	}

	public void setDateCreationQrCode(DateTime dateCreationQrCode) {
		this.dateCreationQrCode = dateCreationQrCode;
	}

	
	
	
	
}
