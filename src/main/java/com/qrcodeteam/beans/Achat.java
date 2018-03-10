package com.qrcodeteam.beans;

import org.joda.time.DateTime;

public class Achat {
	
		private int idAchat;
		private float montantAchat;
		private DateTime dateAchat;
		private String idEmploye;
		private String idCommerce;
		
		

		public Achat(int idAchat, float montantAchat, DateTime dateAchat, String idEmploye, String idCommerce) {
			
			this.idAchat = idAchat;
			this.montantAchat = montantAchat;
			this.dateAchat = dateAchat;
			this.idEmploye = idEmploye;
			this.idCommerce = idCommerce;
		}
		
		
		public Achat() {
	
		}


		public int getIdAchat() {
			return idAchat;
		}
		public void setIdAchat(int idAchat) {
			this.idAchat = idAchat;
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
		
		
}
