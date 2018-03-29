package com.qrcodeteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.qrcodeteam.beans.Achat;
import com.qrcodeteam.beans.Commerce;
import com.qrcodeteam.beans.Entreprise;
import com.qrcodeteam.beans.Transaction;

public class TransactionsDAO {
	public static List<Transaction> ListerTransactions(Connection con, String idEntreprise) {
		List<Transaction> listeTransacs = new ArrayList<Transaction>();
		//String req = "SELECT achat.idCommerce, achat.montantAchat, achat.dateAchat, achat.statusCompensation FROM achat WHERE achat.idEmploye IN (SELECT idEmploye FROM employe WHERE idEntreprise = ?)";
		String req2 = "SELECT * FROM achat, commerce where achat.idCommerce=commerce.idCommerce and achat.idEmploye IN (SELECT idEmploye FROM employe WHERE idEntreprise = ?)";
		PreparedStatement pstmt=null;
		ResultSet res = null;
		
		try {
			pstmt = con.prepareStatement(req2);
			pstmt.setString(1,idEntreprise);
			res=pstmt.executeQuery();
			while(res.next()) {
				Entreprise e1= new Entreprise();
				e1.setIdEntreprise(idEntreprise);
				Commerce c1= new Commerce();
				c1.setNomCommerce(res.getString("nomCommerce"));
				Achat a1= new Achat();
			
				a1.setDateAchat(new DateTime(res.getDate("DateAchat")));
				a1.setMontantAchat(res.getFloat("montant"));
				a1.setStatusCompensation(res.getInt("statusCompensation"));
				Transaction t1= new Transaction(c1,e1,a1);
				
				//Achat a1 = new Achat(res.getFloat("montantAchat"), new DateTime(res.getTimestamp("dateAchat")),res.getInt("statusCompensation"),"","");
				//a1.setIdCommerce(a1.getDateAchat().toString().substring(0,10));
				
				listeTransacs.add(t1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		return listeTransacs;
	}
	
	
	public static float getEncoursMontant(Connection con, String idEntreprise) {
		String req = "SELECT SUM(montantAchat) FROM achat, commerce where achat.idCommerce=commerce.idCommerce and achat.statusCompensation=0 and achat.idEmploye IN (SELECT idEmploye FROM employe WHERE idEntreprise = ?)";
		PreparedStatement pstmt=null;
		ResultSet res = null;
		float montant=(float) 0.0;
		try {
			pstmt=con.prepareStatement(req);
			pstmt.setString(1, idEntreprise);
			res=pstmt.executeQuery();
			
			if(res.next()) {
				montant=res.getFloat(1);
			}
			
		}catch(SQLException sqle) {
			sqle.getMessage();
		}finally {
			if (pstmt != null) {
				DBConnexion.closePreparedStatement(pstmt);
			}
			
			if (con != null) {
				DBConnexion.closeConnection(con);
			}
			
		}
		return montant;
	}
}