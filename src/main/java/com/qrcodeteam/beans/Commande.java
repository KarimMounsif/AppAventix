package com.qrcodeteam.beans;

import org.joda.time.DateTime;

public class Commande {

	private String idCommande;
	private int quantiteCommande;
	private float prixCommande;
	private DateTime dateLivraisonCommande;
	private DateTime dateCommande;
	private int statusLivraison;
	private String idEntreprise;
	
	
	public Commande(String idCommande, int quantiteCommande, float prixCommande, DateTime dateLivraisonCommande,
			DateTime dateCommande, int statusLivraison, String idEntreprise) {
		this.idCommande = idCommande;
		this.quantiteCommande = quantiteCommande;
		this.prixCommande = prixCommande;
		this.dateLivraisonCommande = dateLivraisonCommande;
		this.dateCommande = dateCommande;
		this.statusLivraison = statusLivraison;
		this.idEntreprise = idEntreprise;
	}
	
	public Commande(){
		
	}

	public String getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(String idCommande) {
		this.idCommande = idCommande;
	}

	public int getQuantiteCommande() {
		return quantiteCommande;
	}

	public void setQuantiteCommande(int quantiteCommande) {
		this.quantiteCommande = quantiteCommande;
	}

	public float getPrixCommande() {
		return prixCommande;
	}

	public void setPrixCommande(float prixCommande) {
		this.prixCommande = prixCommande;
	}

	public DateTime getDateLivraisonCommande() {
		return dateLivraisonCommande;
	}

	public void setDateLivraisonCommande(DateTime dateLivraisonCommande) {
		this.dateLivraisonCommande = dateLivraisonCommande;
	}

	public DateTime getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(DateTime dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getStatusLivraison() {
		return statusLivraison;
	}

	public void setStatusLivraison(int statusLivraison) {
		this.statusLivraison = statusLivraison;
	}

	public String getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(String idEntreprise) {
		this.idEntreprise = idEntreprise;
	}
	
	
	
	
	
	
	
}
