package com.qrcodeteam.beans;

import org.joda.time.DateTime;

public class Achat {
	
		private float montantAchat;
		private DateTime dateAchat;
		private int StatusCompensation;
		private String idEmploye;
		private String idCommerce;
		private String idAchat;
		
		

		public Achat(float montantAchat, DateTime dateAchat, int StatusCompens, String idEmploye, String idCommerce) {
			
			this.montantAchat = montantAchat;
			this.dateAchat = dateAchat;
			this.StatusCompensation=StatusCompens;
			this.idEmploye = idEmploye;
			this.idCommerce = idCommerce;
		}
		
		public Achat(float montantAchat, DateTime dateAchat, int StatusCompens, String idEmploye, String idCommerce,String idAchat) {
			
			this.montantAchat = montantAchat;
			this.dateAchat = dateAchat;
			this.StatusCompensation=StatusCompens;
			this.idEmploye = idEmploye;
			this.idCommerce = idCommerce;
			this.idAchat=idAchat;
		}
		
		
		public Achat() {
	
		}

		
		public float getMontantAchat() {
			return montantAchat;
		}
		public void setMontantAchat(float montantAchat) {
			this.montantAchat = montantAchat;
		}
		
		public DateTime getDateAchat() {
			return dateAchat;
		}
		public void setDateAchat(DateTime dateAchat) {
			this.dateAchat = dateAchat;
		}
		
		
		public int getStatusCompensation() {
			return StatusCompensation;
		}


		public void setStatusCompensation(int statusCompensation) {
			StatusCompensation = statusCompensation;
		}


		public String getIdEmploye() {
			return idEmploye;
		}
		
		public void setIdEmploye(String idEmploye) {
			this.idEmploye = idEmploye;
		}
		
		public String getIdCommerce() {
			return idCommerce;
		}
		
		public void setIdCommerce(String idCommerce) {
			this.idCommerce = idCommerce;
		}


		public String getIdAchat() {
			return idAchat;
		}


		public void setIdAchat(String idAchat) {
			this.idAchat = idAchat;
		}
		
}