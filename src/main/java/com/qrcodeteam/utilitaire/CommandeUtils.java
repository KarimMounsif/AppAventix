package com.qrcodeteam.utilitaire;

public class CommandeUtils {
	
	
	public static float calculPrixCommande(float prixInitial, int qte) {
		int reduction=0;
		// Set Reduction variable
		if(qte>10 && qte <50) reduction=10;
		else if(qte>=51 && qte<100 ) reduction=20;
		else if(qte >100) reduction=30;
		
		
		return ((prixInitial*qte) - ((prixInitial*qte*reduction)/100));
	}

}
