package com.qrcodeteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.qrcodeteam.beans.Employe;
import com.qrcodeteam.beans.EmployeQrcodeRest;
import com.qrcodeteam.beans.Qrcode;

public class ImpServiceDAO implements InterfaceServiceDAO{
	static DateTimeFormatter dtfc=DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	static DateTimeFormatter dtf=DateTimeFormat.forPattern("yyyy-MM-dd");
	
	@Override
	public EmployeQrcodeRest authentification(Connection con, String mailEmploye, String mdpEmploye) {
		// TODO Auto-generated method stub
		
		
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		ResultSet rs=null;
		EmployeQrcodeRest eqr=null;
		
		String req1= "SELECT COUNT(*) FROM EMPLOYE WHERE mailEmploye=? AND mdpEmploye=?";
		String req2= "SELECT * FROM EMPLOYE WHERE mailEmploye=? AND mdpEmploye=?";
		String req3= "SELECT numeroCode from QRCODE where idEmploye=?";
		try {

			pstmt=con.prepareStatement(req1);
			pstmt.setString(1, mailEmploye);
			pstmt.setString(2, mdpEmploye);
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				int nbLigne=rs.getInt(1);
				//User trouvé
				if(nbLigne>0) {
					pstmt2=con.prepareStatement(req2);
					pstmt2.setString(1,mailEmploye);
					pstmt2.setString(2, mdpEmploye);
					rs=pstmt2.executeQuery();
					
					if(rs.next()) {
						// initialiser un employé
						Employe e= new Employe(
								rs.getString("idEmploye"),
								rs.getString("nomEmploye"), 
								rs.getString("prenomEmploye"), 
								rs.getString("civiliteEmploye"),
								new DateTime(rs.getString("ddnEmploye")),
								rs.getInt("typeEmploye"), 
								rs.getString("telEmploye"),
								rs.getString("mailEmploye"),
								rs.getFloat("soldeEmploye"),
								rs.getString("mdpEmploye"),
								rs.getInt("statusCompteEmploye"),
								new DateTime(rs.getString("dateCreationCompteEmploye")),
								new DateTime(rs.getString("dateDerniereConnexionEmploye")),
								rs.getString("idEntreprise"));
						
						//Recuperer son QrCode
						
						pstmt3=con.prepareStatement(req3);
						pstmt3.setString(1,e.getIdEmploye());
						rs=pstmt3.executeQuery();
						Qrcode qr=null;
						if(rs.next()) {
							
							 qr= new Qrcode(rs.getString("idQrcode"),
									rs.getInt("statusQrCode"), 
									rs.getString("numeroCode"), 
									rs.getFloat("prixQrCode"),
									rs.getString("idEntreprise"),
									rs.getString("idEmploye"), 
									rs.getString("idCommande"), 
									new DateTime (rs.getString("dateCreationQrCode"))
									);
						}
						
						// Initialiser EmployeQrcode
						eqr=new EmployeQrcodeRest(e,qr);
						
					}
						
					
				}else {
				//User non trouvé
				}
				System.out.println("numberOfRows= " + nbLigne);
			}else {
				System.out.println("error: can't get nobody");
			}
			
			
			
			
		}catch(SQLException sqlex) {
			sqlex.getMessage();
		}catch(Exception ex) {
			ex.getMessage();
		}finally {
			
		}
		
		
		
		
		return eqr;
	}
	

	@Override
	public String getQrCode(Connection con,String idEmploye) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

}
