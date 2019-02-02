package com.qrcodeteam.dao.web_app;

import com.qrcodeteam.bom.Commande;
import com.qrcodeteam.bom.Qrcode;
import com.qrcodeteam.dao.DBConnexion;
import com.qrcodeteam.utils.JsonResponse;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CommandeDAO {

	private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	/**
	 * Transaction 
	 * 1- init commande (insert)
	 * 2- Generation QRcode et assocition a IdEntreprise
	 * 3- Finaliser commande (update)
	 *
	 */
	public static JsonResponse commanderQRcode(Connection con, Commande commande, List<Qrcode> listQrcode) {
		JsonResponse jsr=new JsonResponse();
	
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3;
		
		String req1="INSERT INTO COMMANDE (idCommande,statusLivraison,quantiteCommande,prixCommande,dateCommande,idEntreprise)"
				+ "VALUES(?,?,?,?,?,?)";
		
		String req2="INSERT INTO QRCODE(idQrcode, numeroCode, dateCreationQrCode,prixQrCode,idEntreprise, idCommande,statusQrCode)"
				+ "VALUES(?,?,?,?,?,?,?)";
		
		String req3="UPDATE COMMANDE SET dateLivraison=? ,statusLivraison=? WHERE idCommande=?";
		
		try {
			// desactiver autocommit
			con.setAutoCommit(false);
			// initier la commande
			pstmt=con.prepareStatement(req1);
			
			pstmt.setString(1, commande.getIdCommande());
			pstmt.setInt(2,commande.getStatusLivraison()); // Pas encore livré : 0, livré : 1
			pstmt.setInt(3, commande.getQuantiteCommande());
			pstmt.setFloat(4, commande.getPrixCommande());
			pstmt.setString(5, commande.getDateCommande().toString(dateTimeFormatter));
			pstmt.setString(6, commande.getIdEntreprise());
			
			pstmt.executeUpdate();
			
			
			pstmt2=con.prepareStatement(req2);
					
			// Livrer commande, association entrprise/QRCode
			for (Qrcode qrCode : listQrcode) {
				pstmt2.setString(1, qrCode.getIdQrcode());
				pstmt2.setString(2, qrCode.getNumeroCode());
				pstmt2.setString(3, qrCode.getDateCreationQrCode().toString(dateTimeFormatter));
				pstmt2.setFloat(4, qrCode.getPrixQrCode());
				pstmt2.setString(5, qrCode.getIdEntreprise());
				pstmt2.setString(6, qrCode.getIdCommande());
				pstmt2.setInt(7, 1); // Status QR code actif :1, desactivé :0 notion d'utilisation unique
				pstmt2.executeUpdate();
			}
			
			//Finalisation de la commande et changement de status de la commande : livraison terminé
			pstmt3=con.prepareStatement(req3);

			pstmt3.setString(1, new DateTime().toString(dateTimeFormatter));
			pstmt3.setInt(2, 1); // Code Livré
			pstmt3.setString(3,commande.getIdCommande());
			
			pstmt3.executeUpdate();
			

			jsr.setValidated(true);
			jsr.getSuccessMessages().put("msg","Votre commande n° "+commande.getIdCommande()+" de "+commande.getQuantiteCommande()+" QRCode(s) a été bien livrée");
			
			// Commit req1,req2, req3.
			con.commit();
			return jsr;
		}catch(SQLException esql) {
				esql.getMessage();
			System.out.println(esql.getMessage());
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage()+"Exception, Bad things happened in life Son...");
			jsr.setValidated(false);
			
			jsr.getErrorMessages().put("msg","Votre commande n°"+commande.getIdCommande()+"de "+commande.getQuantiteCommande()+"a echoue...");
			
			
			return jsr;
		}finally {

			if (pstmt != null) {
				DBConnexion.closePreparedStatement(pstmt);
			}

			if (pstmt2 != null) {
				DBConnexion.closePreparedStatement(pstmt2);
			}

			if (con != null) {
				DBConnexion.closeConnection(con);
			}

		}
		
		
		
		
		return jsr;
	}
	
	
	
	
}
