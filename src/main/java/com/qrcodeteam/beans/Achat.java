package com.qrcodeteam.beans;

public class Achat {
		private float montantAchat;
		private String dateAchat;
		private String nomCommerce;
		
		
		public Achat(float montantAchat, String dateAchat, String nomCommerce) {
			super();
			this.montantAchat = montantAchat;
			this.dateAchat = dateAchat;
			this.nomCommerce = nomCommerce;
		}
		
		public float getMontantAchat() {
			return montantAchat;
		}
		public void setMontantAchat(float montantAchat) {
			this.montantAchat = montantAchat;
		}
		public String getDateAchat() {
			return dateAchat;
		}
		public void setDateAchat(String dateAchat) {
			this.dateAchat = dateAchat;
		}
		public String getNomCommerce() {
			return nomCommerce;
		}
		public void setNomCommerce(String nomCommerce) {
			this.nomCommerce = nomCommerce;
		}
		
		

		
}
