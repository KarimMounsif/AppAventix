package com.qrcodeteam.beans;

public class Facture {
	
	Entreprise e;
	Commande c;
	int reduction;
	
	public Facture(Entreprise e, Commande c) {
		this.e = e;
		this.c = c;
		if(c.getQuantiteCommande()>10 && c.getQuantiteCommande() <50) this.reduction=10;
		else if(c.getQuantiteCommande()>=51 && c.getQuantiteCommande()<100 ) this.reduction=20;
		else if(c.getQuantiteCommande() >100) this.reduction=30;;
	}

	public Entreprise getE() {
		return e;
	}

	public void setE(Entreprise e) {
		this.e = e;
	}

	public Commande getC() {
		return c;
	}

	public void setC(Commande c) {
		this.c = c;
	}

	public int getReduction() {
		return reduction;
	}

	public void setReduction(int reduction) {
		this.reduction = reduction;
	}

	@Override
	public String toString() {
		return "Facture [e=" + e.toString() + ", c=" + c.toString() + ", reduction=" + reduction + "]";
	}

	
	
	

}
