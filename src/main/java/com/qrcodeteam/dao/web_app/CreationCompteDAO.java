package com.qrcodeteam.dao.web_app;

import com.qrcodeteam.bom.Commerce;
import com.qrcodeteam.bom.Employe;
import com.qrcodeteam.bom.Entreprise;
import com.qrcodeteam.bom.Gerant;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreationCompteDAO {
	
	static DateTime dt= new DateTime();
	private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");
	
	public static void insertGerant(Connection con, Gerant g) {
		String req="INSERT INTO GERANT(idGerant,nomGerant,prenomGerant,ddnGerant,mailGerant,telGerant,adresseGerant,codePostalGerant,villeGerant"
				+ ",civiliteGerant,statusCompteGerant) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(req);
			pstmt.setString(1, g.getIdGerant());
			pstmt.setString(2, g.getNomGerant());
			pstmt.setString(3, g.getPrenomGerant());
			//pstmt.setString(4, g.getDdnGerant().toString(dateTimeFormatter));
			pstmt.setString(4, new DateTime().toString(dateTimeFormatter));
			pstmt.setString(5, g.getMailGerant());
			pstmt.setString(6, g.getTelGerant());
			pstmt.setString(7, g.getAdresseGerant());
			pstmt.setString(8, g.getCodePostalGerant());
			pstmt.setString(9, g.getVilleGerant());
			pstmt.setString(10, g.getCiviliteGerant());
			pstmt.setInt(11, -1);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	

	public static void insertCommerce(Connection con,Commerce c) {
		String req="INSERT INTO COMMERCE(idCommerce,nomCommerce,typeCommerce,adresseCommerce,codePostalCommerce,villeCommerce,telCommerce,siretCommerce,"
				+ "ribCommerce,mailCommerce,descriptionCommerce,idGerant,capitalSocialCommerce,effectifCommerce,statusCompteCommerce,dateImmatriculationCommerce) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(req);
			pstmt.setString(1, c.getIdCommerce());
			pstmt.setString(2, c.getNomCommerce());
			pstmt.setString(3, c.getTypeCommerce());
			pstmt.setString(4,c.getAdresseCommerce());
			
			pstmt.setString(5, c.getCodePostalCommerce());
			pstmt.setString(6, c.getVilleCommerce());
			pstmt.setString(7, c.getTelCommerce());
			pstmt.setString(8, c.getSiretCommerce());
			pstmt.setString(9, c.getRibCommerce());
			pstmt.setString(10, c.getMailCommerce());
			pstmt.setString(11,c.getDescriptionCommerce());
			pstmt.setString(12,c.getIdGerant());
			
			pstmt.setInt(13, c.getCapitalSocialCommerce());
			pstmt.setInt(14,c.getEffectifCommerce());
			pstmt.setInt(15, -1);
			//pstmt.setString(16, c.getDateImmatriculationCommerce().toString(dateTimeFormatter));
			pstmt.setString(16, new DateTime().toString(dateTimeFormatter));
			
			pstmt.executeUpdate();
		} catch (SQLException e  ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception ex) {
			System.out.println("We have a real probleme here Son !!!");
			System.out.println("==>"+ex.getMessage());
		}
		
		
	}
	
	public static void insertEntreprise(Connection con, Entreprise e) {
		String req="INSERT INTO ENTREPRISE(idEntreprise,nomEntreprise,nomService,"
				+ "codePostalEntreprise,villeEntreprise,siretEntreprise,capitalSocialEntreprise,"
				+ "effectifEntreprise,adresseEntreprise,mailEntreprise,"
				+ "telEntreprise, statusCompteEntreprise,ribEntreprise,"
				+ "dateImmatriculationEntreprise,idEmploye) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(req);
			pstmt.setString(1, e.getIdEntreprise());
			pstmt.setString(2, e.getNomEntreprise());
			pstmt.setString(3, e.getNomService());
			pstmt.setString(4,e.getCodePostalEntreprise());
			pstmt.setString(5, e.getVilleEntreprise());
			pstmt.setString(6, e.getSiretEntreprise());
			pstmt.setInt(7, e.getCapitalSocialEntreprise());
			pstmt.setInt(8, e.getEffectifEntreprise());
			pstmt.setString(9, e.getAdresseEntreprise());
			pstmt.setString(10, e.getMailEntreprise());
			pstmt.setString(11,e.getTelEntreprise());
			pstmt.setInt(12,-1);
			pstmt.setString(13, e.getRibEntreprise());
			pstmt.setString(14, new DateTime().toString(dateTimeFormatter));
			//pstmt.setString(14, c.getDateImmatriculationCommerce().toString(dateTimeFormatter));
			
			pstmt.setString(15,e.getIdEmploye());
			
			
			pstmt.executeUpdate();
		} catch (SQLException ex  ) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println("We have a real probleme here Son !!!");
			System.out.println("==>"+ex.getMessage());
		}
		
	}
	
	public static void insertEmployeur(Connection con, Employe e) {
		// pas mdp; pas date derniereconnexion , pas dateCréationCompte
		String req="INSERT INTO EMPLOYE(idEmploye,nomEmploye,prenomEmploye,ddnEmploye,typeEmploye,telEmploye,"
				+ "mailEmploye,soldeEmploye,civiliteEmploye,statusCompteEmploye,idEntreprise) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(req);
			pstmt.setString(1, e.getIdEmploye());
			pstmt.setString(2, e.getNomEmploye());
			pstmt.setString(3, e.getPrenomEmploye());
			//pstmt.setString(4, e.getDdnEmploye().toString(dateTimeFormatter));
			pstmt.setString(4, new DateTime().toString(dateTimeFormatter));
			//System.out.println(c.getIdCommerce());
			pstmt.setInt(5, 1); // type Employeur: 1, Employe : 0;
			pstmt.setString(6, e.getTelEmploye());
			pstmt.setString(7, e.getMailEmploye());
			pstmt.setFloat(8, e.getSoldeEmploye());
			pstmt.setString(9, e.getCiviliteEmploye());
			pstmt.setInt(10, 0); // création d'un employeur
			pstmt.setString(11,e.getIdEntreprise());
			pstmt.executeUpdate();
			
		} catch (SQLException ex ) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println("We have a real probleme here Son !!!");
			System.out.println("==>"+ex.getMessage());
		}
		
		
	}
}
