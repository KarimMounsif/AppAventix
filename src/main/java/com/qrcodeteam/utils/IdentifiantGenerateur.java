package com.qrcodeteam.utils;


import com.qrcodeteam.bom.Commande;
import com.qrcodeteam.bom.Entreprise;
import com.qrcodeteam.bom.Qrcode;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class IdentifiantGenerateur {

    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String AC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@#$&";
    private static SecureRandom rnd = new SecureRandom();
	static DateTimeFormatter dtfc=DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

	public static String generatorIdentifiant( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
	public static String generatorPassword( int len ){
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( AC.charAt( rnd.nextInt(AC.length()) ) );
		   return sb.toString();
		}


    private static String generatorQR() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    

    public static List<Qrcode> generatorListQR(int qte, Entreprise e, float prixUnitaireQrcode,Commande commande){

        List<Qrcode> lqr = new ArrayList<>();
    	for(int i=0; i<qte; i++) {
    		Qrcode qrc=new Qrcode(generatorIdentifiant(8),1,generatorQR(),prixUnitaireQrcode,e.getIdEntreprise(),commande.getIdCommande(),new DateTime());
    		lqr.add(qrc);
    	}
		return lqr;
    	
    }
    
    /*
    public static void main(String[] args) {
        System.out.println(generatorQR());
        System.out.println("----------------------------");
        System.out.println(generatorIdentifiant(8));
        System.out.println("----------------------------");
        System.out.println(generatorPassword(8));
    }
    */
}


