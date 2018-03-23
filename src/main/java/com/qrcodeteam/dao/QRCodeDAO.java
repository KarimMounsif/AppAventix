package com.qrcodeteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QRCodeDAO {
	public static int getAvailableQR(Connection con, String idEntreprise) {
		String req="SELECT COUNT(idQrCode) FROM QRCODE WHERE idEntreprise=? AND idEmploye is null";
		ResultSet rs;
		PreparedStatement pstmt = null;
		try {
		    pstmt = con.prepareStatement(req);
			pstmt.setString(1, idEntreprise);
			rs=pstmt.executeQuery();
			System.out.println("Connexion OK");
			if(rs.next()) {
				System.out.println(rs.getInt(1));
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}finally {
			if (pstmt != null) {
				DBConnexion.closePreparedStatement(pstmt);
			}

			if (con != null) {
				DBConnexion.closeConnection(con);
			}
		}
		return 1;
	}
	
	
	public static int getQrEntreprise(Connection con, String idEntreprise) {
		String req="SELECT COUNT(idQrCode) FROM QRCODE WHERE idEntreprise=?";
		ResultSet rs;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(req);
			pstmt.setString(1, idEntreprise);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getInt(1));
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}finally {
			if (pstmt != null) {
				DBConnexion.closePreparedStatement(pstmt);
			}

			if (con != null) {
				DBConnexion.closeConnection(con);
			}
		}
		return 1;
	}
}