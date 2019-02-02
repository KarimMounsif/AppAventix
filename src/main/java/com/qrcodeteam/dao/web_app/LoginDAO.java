package com.qrcodeteam.dao.web_app;

import com.qrcodeteam.bom.Entreprise;
import com.qrcodeteam.bom.Gerant;
import com.qrcodeteam.bom.Login;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	DateTime dt= new DateTime();
	DateTimeFormatter dtf=DateTimeFormat.forPattern("dd/MM/yyyy");
	
public static Entreprise getLoginEntreprise(Connection con, Login x){
		
		Entreprise entreprise=null;
	ResultSet rs;
		String req="Select * FROM ENTREPRISE WHERE mailEntreprise=? and mdpEntreprise=?";
		try {
		PreparedStatement pstmt = con.prepareStatement(req);
		pstmt.setString(1, x.getLogin());
		pstmt.setString(2,  DigestUtils.md5Hex(x.getMdp()));
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			// Zone critique 
			// Constructeur de Entreprise : attention à l'ordre des paramètres.
			
			entreprise=new Entreprise(rs.getString("idEntreprise"),rs.getString("nomEntreprise"),rs.getString("nomService"),rs.getString("codePostalEntreprise"),
					rs.getString("villeEntreprise"), rs.getString("adresseEntreprise"), rs.getString("mailEntreprise"), rs.getString("telEntreprise"),rs.getString("ribEntreprise"), rs.getString("mdpEntreprise"), rs.getInt("statusCompteEntreprise"),
				new DateTime(rs.getString("dateCreationCompteEntreprise")), new DateTime(rs.getString("dateDerniereConnexionEntreprise")),rs.getString("idEmploye"),rs.getString("siretEntreprise"),new DateTime(rs.getString("dateImmatriculationEntreprise")),rs.getInt("capitalSocialEntreprise"),rs.getInt("effectifEntreprise"));
		
			System.out.println("User trouve");
		}else {
			System.out.println("User non trouve");
		}
		}catch(Exception ex) {
			System.out.println("Erreur :"+ex.getMessage());
		}
		
		return entreprise;
}


	public static Gerant getLoginCommercant(Connection con, Login x) {
		Gerant commercant=null;
		ResultSet rs;
		String req="Select * FROM GERANT WHERE mailGerant=? and mdpGerant=?";
		try {
		PreparedStatement pstmt = con.prepareStatement(req);
		pstmt.setString(1, x.getLogin());
		pstmt.setString(2,  DigestUtils.md5Hex(x.getMdp()));
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			commercant=new Gerant(rs.getString("idGerant"),rs.getString("nomGerant"),rs.getString("prenomGerant"),rs.getString("mailGerant"),
				rs.getString("telGerant"),rs.getString("adresseGerant"), rs.getString("codePostalGerant"),rs.getString("villeGerant"),rs.getString("civiliteGerant"),rs.getString("mdpGerant"),new DateTime(rs.getString("dateCreationCompteGerant")), new DateTime(rs.getString("dateDerniereConnexionEmploye")),new DateTime(rs.getString("ddnGerant")),rs.getInt("statusCompteGerant"));
		
			System.out.println("User trouve");
		}else {
			System.out.println("User non trouve");
		}
		}catch(Exception ex) {
			System.out.println("Erreur :"+ex.getMessage());
		}
		
		return commercant;
	}
	
}
