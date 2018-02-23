package com.qrcodeteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.qrcodeteam.beans.Commerce;
import com.qrcodeteam.beans.Gerant;

public class CreationCompteDAO {
	
	static DateTime dt= new DateTime();
	static DateTimeFormatter dtf=DateTimeFormat.forPattern("yyyy-MM-dd");
	
	public static void insertGerant(Connection con, Gerant g) {
		String req="INSERT INTO GERANT(idGerant,nomGerant,prenomGerant,ddnGerant,mailGerant,telGerant,adresseGerant,codePostalGerant,villeGerant"
				+ ",civiliteGerant,statusCompteGerant) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(req);
			pstmt.setString(1, g.getIdGerant());
			pstmt.setString(2, g.getNomGerant());
			pstmt.setString(3, g.getPrenomGerant());
			//pstmt.setString(4, g.getDdnGerant().toString(dtf));
			pstmt.setString(4, new DateTime().toString(dtf));
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
			System.out.println(c.getIdCommerce());
			pstmt.setString(5, c.getCodePostalCommerce());
			pstmt.setString(6, c.getVilleCommerce());
			pstmt.setString(7, c.getTelCommerce());
			pstmt.setString(8, c.getSiretCommerce());
			pstmt.setString(9, c.getRibCommerce());
			pstmt.setString(10, c.getMailCommerce());
			pstmt.setString(11,c.getDescriptionCommerce());
			pstmt.setString(12,c.getIdGerant());
			System.out.println(c.getIdGerant());
			pstmt.setInt(13, c.getCapitalSocialCommerce());
			pstmt.setInt(14,c.getEffectifCommerce());
			pstmt.setInt(15, -1);
			//pstmt.setString(16, c.getDateImmatriculationCommerce().toString(dtf));
			pstmt.setString(16, new DateTime().toString(dtf));
			
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
}
