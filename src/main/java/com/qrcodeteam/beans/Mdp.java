package com.qrcodeteam.beans;

public class Mdp {
	
	private String mdp;
	private String idUser;
	
	public Mdp(String mdp, String idUser) {
		this.mdp = mdp;
		this.idUser = idUser;
	}

	public Mdp() {
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	
	
}
