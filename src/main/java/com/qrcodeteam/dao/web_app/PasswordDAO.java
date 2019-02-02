package com.qrcodeteam.dao.web_app;

import com.qrcodeteam.bom.Mdp;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PasswordDAO {

	
	
	public  static void changePasswordEntreprise(Connection con, String idUser,Mdp mdp) {
		
		String req="UPDATE ENTREPRISE SET mdpEntreprise = ? WHERE idEntreprise= ?";
	
		try {
			PreparedStatement pstmt=con.prepareStatement(req);
			
			pstmt.setString(1,DigestUtils.md5Hex(mdp.getMdp()));
			pstmt.setString(2, idUser);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	
public  static void changePasswordGerant(Connection con, String idUser,Mdp mdp) {
		
		String req="UPDATE GERANT SET mdpGerant = ? WHERE idGerant= ?";
	
		
		
		try {
			PreparedStatement pstmt=con.prepareStatement(req);
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(mdp.getMdp().getBytes());
			pstmt.setString(1,new String(messageDigest.digest()));
			pstmt.setString(2, idUser);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
}
}
