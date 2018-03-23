package com.qrcodeteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.qrcodeteam.beans.Commerce;
import com.qrcodeteam.beans.CommerceGerant;
import com.qrcodeteam.beans.Employe;
import com.qrcodeteam.beans.Entreprise;
import com.qrcodeteam.beans.EntrepriseEmploye;
import com.qrcodeteam.beans.Gerant;
import com.qrcodeteam.utilitaire.IdentifiantGenerateur;

public class AdminDAO {

	
	
	public static List<CommerceGerant> listerCommercePartenaire(Connection con){
		List<CommerceGerant> lc=new ArrayList<CommerceGerant>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String req1="SELECT * FROM COMMERCE,GERANT WHERE statusCompteGerant > -1 and commerce.idGerant=gerant.idGerant"; 
		
		try {
			pstmt=con.prepareStatement(req1);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				CommerceGerant gc=new CommerceGerant(new Commerce(), new Gerant());
				gc.getG().setNomGerant(rs.getString("nomGerant"));
				gc.getG().setPrenomGerant(rs.getString("prenomGerant"));
				gc.getG().setAdresseGerant(rs.getString("adresseGerant"));
				gc.getG().setCodePostalGerant(rs.getString("codePostalGerant"));
				gc.getG().setMailGerant(rs.getString("mailGerant"));
				gc.getG().setTelGerant(rs.getString("telGerant"));
				gc.getG().setVilleGerant(rs.getString("villeGerant"));
				
				gc.getC().setSiretCommerce(rs.getString("siretCommerce"));
				gc.getC().setNomCommerce(rs.getString("nomCommerce"));
				gc.getC().setAdresseCommerce(rs.getString("adresseCommerce"));
				gc.getC().setTelCommerce(rs.getString("telCommerce"));
				gc.getC().setCodePostalCommerce(rs.getString("codePostalCommerce"));
				gc.getC().setTypeCommerce(rs.getString("typeCommerce"));
				gc.getC().setVilleCommerce(rs.getString("villeCommerce"));
				gc.getC().setMailCommerce(rs.getString("mailCommerce"));
				
				lc.add(gc);
				
				
			}
		}catch(SQLException ex) {
			ex.getMessage();
			
		}finally{
			
			
			
			if (pstmt != null) {
				DBConnexion.closePreparedStatement(pstmt);
			}
			
			if (con != null) {
				DBConnexion.closeConnection(con);
			}
		}
		
		
		
		return lc;
	}
	
	
	
	public static List<EntrepriseEmploye> listerEntreprisePartenaire(Connection con){
		List<EntrepriseEmploye> le=new ArrayList<EntrepriseEmploye>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String req1="SELECT * FROM ENTREPRISE,EMPLOYE WHERE statusCompteEntreprise > -1 and entreprise.idEmploye=employe.idEmploye"; 
		
		try {
			pstmt=con.prepareStatement(req1);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				EntrepriseEmploye ee=new EntrepriseEmploye(new Entreprise(), new Employe());
				ee.getEm().setNomEmploye(rs.getString("nomEmploye"));
				ee.getEm().setPrenomEmploye(rs.getString("prenomEmploye"));
				ee.getEm().setMailEmploye(rs.getString("mailEmploye"));
				ee.getEm().setTelEmploye(rs.getString("telEmploye"));
			
				
				ee.getEn().setSiretEntreprise(rs.getString("siretEntreprise"));
				ee.getEn().setNomEntreprise(rs.getString("nomEntreprise"));
				ee.getEn().setNomService(rs.getString("nomService"));
				ee.getEn().setAdresseEntreprise(rs.getString("adresseEntreprise"));
				ee.getEn().setTelEntreprise(rs.getString("telEntreprise"));
				ee.getEn().setCodePostalEntreprise(rs.getString("codePostalEnteprise"));
				ee.getEn().setVilleEntreprise(rs.getString("villeEntreprise"));
				ee.getEn().setMailEntreprise(rs.getString("mailEntreprise"));
				
				le.add(ee);
				
				
			}
		}catch(SQLException ex) {
			ex.getMessage();
			
		}finally{
			
			
			
			if (pstmt != null) {
				DBConnexion.closePreparedStatement(pstmt);
			}
			
			if (con != null) {
				DBConnexion.closeConnection(con);
			}
		}
		
		
		return le;
	}
	
	
	
	public static List<CommerceGerant> listerCommerceDemande(Connection con){
		List<CommerceGerant> lc=new ArrayList<CommerceGerant>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String req1="SELECT * FROM COMMERCE,GERANT WHERE statusCompteCommerce=-1 and statusCompteGerant=-1 and commerce.idGerant=gerant.idGerant"; 
		
		try {
			pstmt=con.prepareStatement(req1);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				CommerceGerant gc=new CommerceGerant(new Commerce(), new Gerant());
				gc.getG().setNomGerant(rs.getString("nomGerant"));
				gc.getG().setPrenomGerant(rs.getString("prenomGerant"));
				gc.getG().setAdresseGerant(rs.getString("adresseGerant"));
				gc.getG().setCodePostalGerant(rs.getString("codePostalGerant"));
				gc.getG().setMailGerant(rs.getString("mailGerant"));
				gc.getG().setTelGerant(rs.getString("telGerant"));
				gc.getG().setVilleGerant(rs.getString("villeGerant"));
				
				gc.getC().setSiretCommerce(rs.getString("siretCommerce"));
				gc.getC().setNomCommerce(rs.getString("nomCommerce"));
				gc.getC().setAdresseCommerce(rs.getString("adresseCommerce"));
				gc.getC().setTelCommerce(rs.getString("telCommerce"));
				gc.getC().setCodePostalCommerce(rs.getString("codePostalCommerce"));
				gc.getC().setTypeCommerce(rs.getString("typeCommerce"));
				gc.getC().setVilleCommerce(rs.getString("villeCommerce"));
				gc.getC().setMailCommerce(rs.getString("mailCommerce"));
				
				lc.add(gc);
				
				
			}
		}catch(SQLException ex) {
			ex.getMessage();
			
		}finally{
			
			
			
			if (pstmt != null) {
				DBConnexion.closePreparedStatement(pstmt);
			}
			
			if (con != null) {
				DBConnexion.closeConnection(con);
			}
		}
		
		
		
		return lc;
	}
	
	
	
	public static List<EntrepriseEmploye> listerEntrepriseDemande(Connection con){
		List<EntrepriseEmploye> le=new ArrayList<EntrepriseEmploye>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String req1="SELECT * FROM ENTREPRISE,EMPLOYE WHERE statusCompteEntreprise=-1 and entreprise.idEmploye=employe.idEmploye"; 
		
		try {
			pstmt=con.prepareStatement(req1);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				EntrepriseEmploye ee=new EntrepriseEmploye(new Entreprise(), new Employe());
				ee.getEm().setNomEmploye(rs.getString("nomEmploye"));
				ee.getEm().setPrenomEmploye(rs.getString("prenomEmploye"));
				ee.getEm().setMailEmploye(rs.getString("mailEmploye"));
				ee.getEm().setTelEmploye(rs.getString("telEmploye"));
			
				
				ee.getEn().setSiretEntreprise(rs.getString("siretEntreprise"));
				ee.getEn().setNomEntreprise(rs.getString("nomEntreprise"));
				ee.getEn().setNomService(rs.getString("nomService"));
				ee.getEn().setAdresseEntreprise(rs.getString("adresseEntreprise"));
				ee.getEn().setTelEntreprise(rs.getString("telEntreprise"));
				ee.getEn().setCodePostalEntreprise(rs.getString("codePostalEnteprise"));
				ee.getEn().setVilleEntreprise(rs.getString("villeEntreprise"));
				ee.getEn().setMailEntreprise(rs.getString("mailEntreprise"));
				
				le.add(ee);
				
				
			}
		}catch(SQLException ex) {
			ex.getMessage();
			
		}finally{
			
			if (pstmt != null) {
				DBConnexion.closePreparedStatement(pstmt);
			}
			
			if (con != null) {
				DBConnexion.closeConnection(con);
			}
		}
		
		
		return le;
	}
	
	
	public static void initMdpGerant(Connection con, String idUserGerant) {
		String req="UPDATE GERANT SET mdpGerant=? WHERE idGerant=?";
		PreparedStatement pstmt=null;
		String mdpRandom=IdentifiantGenerateur.generatorPassword(16);
		try {
			pstmt=con.prepareStatement(req);
			pstmt.setString(1, DigestUtils.md5Hex(mdpRandom));
			pstmt.setString(2, idUserGerant);
			pstmt.executeQuery();
		}catch(SQLException sqle) {
			sqle.getMessage();
		}finally{
			
			if (pstmt != null) {
				DBConnexion.closePreparedStatement(pstmt);
			}
			
			if (con != null) {
				DBConnexion.closeConnection(con);
			}
		}
		
	}
	
	
	
	public static void initMdpEntreprise(Connection con, String idEntreprise) {
		String req="UPDATE ENTREPRISE SET mdpEntreprise=? WHERE idEntreprise=?";
		PreparedStatement pstmt=null;
		String mdpRandom=IdentifiantGenerateur.generatorPassword(16);
		try {
			pstmt=con.prepareStatement(req);
			pstmt.setString(1, DigestUtils.md5Hex(mdpRandom));
			pstmt.setString(2, idEntreprise);
			pstmt.executeQuery();
		}catch(SQLException sqle) {
			sqle.getMessage();
		}finally{
			
			if (pstmt != null) {
				DBConnexion.closePreparedStatement(pstmt);
			}
			
			if (con != null) {
				DBConnexion.closeConnection(con);
			}
		}
		
	}
	
	
	public static void initMdpEmploye(Connection con, String idEmploye) {
		String req="UPDATE EMPLOYE SET mdpEmploye=? WHERE idEmploye=?";
		PreparedStatement pstmt=null;
		String mdpRandom=IdentifiantGenerateur.generatorPassword(16);
		try {
			pstmt=con.prepareStatement(req);
			pstmt.setString(1, DigestUtils.md5Hex(mdpRandom));
			pstmt.setString(2, idEmploye);
			pstmt.executeQuery();
		}catch(SQLException sqle) {
			sqle.getMessage();
		}finally{
			
			if (pstmt != null) {
				DBConnexion.closePreparedStatement(pstmt);
			}
			
			if (con != null) {
				DBConnexion.closeConnection(con);
			}
		}
		
	}
}
