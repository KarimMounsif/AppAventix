package com.qrcodeteam.utilitaire;


import java.util.UUID;
import java.security.SecureRandom;



public class IdentifiantGenerateur {

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static final String AC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@#$&";
	static SecureRandom rnd = new SecureRandom();

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
	
	
    public static String generatorQR() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return "uuid = " + uuid;
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


