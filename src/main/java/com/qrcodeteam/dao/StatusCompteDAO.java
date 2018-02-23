package com.qrcodeteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatusCompteDAO {

	// Init -> status(0)"
	// Activer -> status (1)
	// Desactiver -> status(-2)
	
	
	
	public static void initCompteGerant(Connection con,String idUser) {
		String req="UPDATE GERANT SET STATUSCOMPTEGERANT=? WHERE idGerant=? ";
		try {
			PreparedStatement pstmt=con.prepareStatement(req);
			pstmt.setInt(1, 0);
			pstmt.setString(2,idUser);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initCompteEntreprise(Connection con,String idUser) {
		String req="UPDATE ENTREPRISE SET STATUSCOMPTEENTREPRISE=? WHERE idEntreprise=? ";
		try {
			PreparedStatement pstmt=con.prepareStatement(req);
			pstmt.setInt(1, 0);
			pstmt.setString(2,idUser);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void activerCompteGerant(Connection con,String idUser) {
		String req="UPDATE GERANT SET STATUSCOMPTEGERANT=? WHERE idGerant=? ";
		try {
			PreparedStatement pstmt=con.prepareStatement(req);
			pstmt.setInt(1, 1);
			pstmt.setString(2,idUser);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void activerCompteEntreprise(Connection con,String idUser) {
		String req="UPDATE ENTREPRISE SET STATUSCOMPTEENTREPRISE=? WHERE idEntreprise=? ";
		try {
			PreparedStatement pstmt=con.prepareStatement(req);
			pstmt.setInt(1, 1);
			pstmt.setString(2,idUser);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void desactiverCompteGerant(Connection con,String idUser) {
		String req="UPDATE GERANT SET STATUSCOMPTEGERANT=? WHERE idGerant=? ";
		try {
			PreparedStatement pstmt=con.prepareStatement(req);
			pstmt.setInt(1, -2);
			pstmt.setString(2,idUser);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void desactiverCompteEntreprise(Connection con,String idUser) {
		String req="UPDATE ENTREPRISE SET STATUSCOMPTEENTREPRISE=? WHERE idEntreprise=? ";
		try {
			PreparedStatement pstmt=con.prepareStatement(req);
			pstmt.setInt(1, -2);
			pstmt.setString(2,idUser);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
