package com.qrcodeteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.qrcodeteam.beans.Achat;
import com.qrcodeteam.beans.Commerce;
import com.qrcodeteam.beans.CommerceGerant;
import com.qrcodeteam.beans.CommerceSerialized;
import com.qrcodeteam.beans.Employe;
import com.qrcodeteam.beans.EmployeQrCodeRest;
import com.qrcodeteam.beans.Gerant;
import com.qrcodeteam.beans.Qrcode;

public class ImpServiceDAO implements InterfaceServiceDAO{
	static DateTimeFormatter dtfc = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	static DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
	static final float PLAFOND_JOURNALIER = 19;
	
	public ImpServiceDAO() {
		
	}
	
	/***********************************************************************************************
	authentification, Service DAO pour réaliser l'authentification d'un employé
	************************************************************************************************/
	@Override
	public EmployeQrCodeRest authentificationEmploye(Connection con, String mailEmploye, String mdpEmploye) {
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		
		String req1= "SELECT COUNT(*) FROM employe WHERE mailEmploye=? AND mdpEmploye=?"; // erreur AND au lieu de OR
		String req2= "SELECT * FROM employe WHERE mailEmploye=? AND mdpEmploye=?";        // pareil
		String req3= "SELECT * FROM qrcode WHERE idEmploye=?"; //erreur numeroQr au lieu de *
		
		EmployeQrCodeRest eqr = null;
		Employe e = null;
		Qrcode qr = null;
		
		try {

			pstmt=con.prepareStatement(req1);
			pstmt.setString(1, mailEmploye);
			pstmt.setString(2, DigestUtils.md5Hex(mdpEmploye));
			System.out.println(mdpEmploye);
			System.out.println(DigestUtils.md5Hex(mdpEmploye));
			//System.out.println(DigestUtils.md5Hex(mdpEmploye));
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				int nbLigne = rs.getInt(1);
				//User trouvÃ©
				if(nbLigne > 0) {
					pstmt2 = con.prepareStatement(req2);
					pstmt2.setString(1,mailEmploye);
					pstmt2.setString(2, DigestUtils.md5Hex(mdpEmploye));
					rs = pstmt2.executeQuery();
					
					if(rs.next()) { 
						// initialiser un employÃ©
						
						e = new Employe();
						e.setIdEmploye(rs.getString("idEmploye")); 
						e.setNomEmploye(rs.getString("nomEmploye")); 
						e.setPrenomEmploye(rs.getString("PrenomEmploye"));
						e.setCiviliteEmploye(rs.getString("civiliteEmploye"));
						e.setDdnEmploye(rs.getString("ddnEmploye"));
						e.setTypeEmploye(rs.getInt("typeEmploye"));
						e.setTelEmploye(rs.getString("telEmploye"));
						e.setMailEmploye(rs.getString("mailEmploye"));
						e.setSoldeEmploye(rs.getFloat("soldeEmploye"));
						e.setMdpEmploye(rs.getString("mdpEmploye"));
						e.setDateCreationCompteEmploye(rs.getString("dateCreationCompteEmploye").substring(0, 10));
						e.setDateDerniereConnexionEmploye(rs.getString("dateDerniereConnexionEmploye").substring(0, 10)); 
						e.setIdEntreprise(rs.getString("idEntreprise"));
						e.setStatusCompteEmploye(rs.getInt("statusCompteEmploye"));
						//Recuperer son QrCode
						
						pstmt3 = con.prepareStatement(req3);
						System.out.println(e.getIdEmploye());
						pstmt3.setString(1,e.getIdEmploye());
						rs = pstmt3.executeQuery();
						//Qrcode qr =null;
						 
						if(rs.next()) {
							 //System.out.println("Initialisation Qr debut"); 
							 qr = new Qrcode();
							 qr.setIdQrcode(rs.getString("idQrcode"));
							 qr.setNumeroCode(rs.getString("numeroCode"));		
							 qr.setPrixQrCode(rs.getFloat("prixQrCode"));
							 qr.setIdEntreprise(rs.getString("idEntreprise")); 
							 qr.setIdEmploye(rs.getString("idEmploye"));
							 qr.setIdCommande(rs.getString("idCommande"));
							 qr.setStatusQrCode(rs.getInt("statusQrCode"));
							 
							 //new DateTime (rs.getString("dateCreationQrCode"))
							 //System.out.println("Initialisation QR fin");
						}
						else {
							qr = new Qrcode();
							qr.setNumeroCode("Non assigné");
						}
						
						eqr=new EmployeQrCodeRest(e,qr);
					}
				}
			}
			
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(pstmt3 != null) {
				try {
					pstmt3.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
		}

		System.out.println("return");
		return eqr;
	}
	
	
	/***********************************************************************************************
	authentification, Service DAO pour réaliser l'authentification d'un commercant
	************************************************************************************************/
	public CommerceGerant authentificationGerant(Connection con, String mailGerant, String mdpGerant) {
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		
		
		String req1= "SELECT COUNT(*) FROM gerant WHERE mailGerant=? AND mdpGerant=?"; 
		String req2= "SELECT * FROM gerant WHERE mailGerant=? AND mdpGerant=?";       
		String req3= "SELECT * FROM commerce WHERE idGerant=?"; 
		CommerceGerant comGerant = null;
		Gerant gerant = null;
		Commerce commerce = null;
		try {
				pstmt1 = con.prepareStatement(req1);
				pstmt1.setString(1, mailGerant);
				pstmt1.setString(2, DigestUtils.md5Hex(mdpGerant));
				rs = pstmt1.executeQuery();	
		if(rs.next()) {
			
				int nblignesCount = 0;
				nblignesCount = rs.getInt(1);
				System.out.println(nblignesCount);
				if(nblignesCount > 0) {
					
					pstmt2 = con.prepareStatement(req2);
					pstmt2.setString(1, mailGerant);
					pstmt2.setString(2, DigestUtils.md5Hex(mdpGerant));
					rs = pstmt2.executeQuery();
					if(rs.next()) {
						gerant = new Gerant();
						gerant.setIdGerant(rs.getString("idGerant"));
						gerant.setNomGerant(rs.getString("nomGerant"));
						gerant.setPrenomGerant(rs.getString("prenomGerant"));
						gerant.setMailGerant(rs.getString("mailGerant"));
						gerant.setTelGerant(rs.getString("telGerant"));
						gerant.setAdresseGerant(rs.getString("adresseGerant"));
						gerant.setCodePostalGerant(rs.getString("codePostalGerant"));
						gerant.setVilleGerant(rs.getString("villeGerant"));
						gerant.setCiviliteGerant(rs.getString("civiliteGerant"));
						gerant.setMdpGerant(rs.getString("mdpGerant"));
						gerant.setDateCreationCompteGerant(rs.getString("dateCreationCompteGerant"));
						gerant.setDateDerniereConnexionGerant(rs.getString("dateDerniereConnexionGerant"));
						gerant.setDdnGerant(rs.getString("ddnGerant"));
						gerant.setStatusCompteGerant(rs.getInt("statusCompteGerant"));
						
						pstmt3 = con.prepareStatement(req3);
						pstmt3.setString(1, gerant.getIdGerant());
						rs = pstmt3.executeQuery();
						
						if(rs.next()) {
							commerce = new Commerce();
							commerce.setIdCommerce(rs.getString("idCommerce"));
							commerce.setNomCommerce(rs.getString("nomCommerce"));
							commerce.setSiretCommerce(rs.getString("siretCommerce"));
							commerce.setAdresseCommerce(rs.getString("adresseCommerce"));
							commerce.setCodePostalCommerce(rs.getString("codePostalCommerce"));
							commerce.setVilleCommerce(rs.getString("villeCommerce"));
							commerce.setTelCommerce(rs.getString("telCommerce"));
							commerce.setMailCommerce(rs.getString("mailCommerce"));
							commerce.setRibCommerce(rs.getString("ribCommerce"));
							commerce.setDescriptionCommerce(rs.getString("descriptionCommerce"));
							commerce.setTypeCommerce(rs.getString("typeCommerce"));
							commerce.setStatusCompteCommerce(rs.getInt("statusCompteCommerce"));
							commerce.setCapitalSocialCommerce(rs.getInt("capitalSocialCommerce"));
							commerce.setEffectifCommerce(rs.getInt("effectifCommerce"));
							commerce.setDateImmatriculationCommerce(rs.getString("dateImmatriculationCommerce"));
						}
					}
					comGerant = new CommerceGerant(commerce, gerant);
			}
			
		}
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(pstmt3 != null) {
				try {
					pstmt3.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
		}
		return comGerant;
		
	}
	
	/***********************************************************************************************
	getQrCode, Service DAO pour obtenir le QR code à la demande
	***********************************************************************************************/
	@Override
 	public Map <String, String> getQrCode(Connection con, String idEmploye) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String requete = "SELECT * FROM qrcode WHERE idEmploye=?";
		
		HashMap<String, String> code = null;
		
		try {
			pstmt=con.prepareStatement(requete);
			pstmt.setString(1,idEmploye);
			rs=pstmt.executeQuery();
			if(rs.next()) {
					code = new HashMap<String, String>();
					code.put("QrCode", rs.getString("numeroCode"));
			}
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(DBConnexion.getConnection() != null) {
				try {
					DBConnexion.getConnection().close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
		}
		
		return code;
	}
	
	
	
	/**********************************************************************************************
	Service DAO pour Changer Mdp Employe à la première connexion
	***********************************************************************************************/
	@Override
	public String changeMdpEmploye(String idEmploye, String newMdp) {
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		Connection con = null;

		String req1 = "SELECT COUNT(*) FROM employe WHERE idEmploye=?";
		String req2 = "UPDATE employe SET mdpEmploye=? ,statusCompteEmploye=? WHERE idEmploye=?";
		String retour = null;
		try {
			con = DBConnexion.getConnection();
			pstmt1 = con.prepareStatement(req1);
			pstmt1.setString(1, idEmploye);
			System.out.println(pstmt1.toString());
			rs = pstmt1.executeQuery();
			if(rs.next()) {
				int nbLignes = rs.getInt(1);
				System.out.print(nbLignes);
				if(nbLignes > 0) {
					pstmt2 = con.prepareStatement(req2);
					pstmt2.setString(1, DigestUtils.md5Hex(newMdp));
					pstmt2.setInt(2, 1);
					pstmt2.setString(3, idEmploye);
					pstmt2.executeUpdate();
					retour = DigestUtils.md5Hex(newMdp); 
				}
			}
			
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
		}
		
		return retour;
	}
	
	
	/**********************************************************************************************
	Service DAO pour Changer Mdp Gerant à la première connexion
	***********************************************************************************************/
	public String changeMdpGerant(String idGerant, String newMdp) {
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		Connection con = null;

		String req1 = "SELECT COUNT(*) FROM gerant WHERE idGerant=?";
		String req2 = "UPDATE gerant SET mdpGerant=? ,statusCompteGerant=? WHERE idGerant=?";
		String retour = null;
		try {
			con = DBConnexion.getConnection();
			pstmt1 = con.prepareStatement(req1);
			pstmt1.setString(1, idGerant);
			rs = pstmt1.executeQuery();
			if(rs.next()) {
				int nbLignes = rs.getInt(1);
				System.out.print(nbLignes);
				if(nbLignes > 0) {
					pstmt2 = con.prepareStatement(req2);
					pstmt2.setString(1, DigestUtils.md5Hex(newMdp));
					pstmt2.setInt(2, 1);
					pstmt2.setString(3, idGerant);
					pstmt2.executeUpdate();
					retour = DigestUtils.md5Hex(newMdp); 
				}
			}
			
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
		}
		
		return retour;
	}
	
	/**********************************************************************************************
	CheckStatutEmploye : Service DAO pour obtenir le statut d'un employé
	- statusCompteEmploye = 0 (Jamais connecté) ==> Changement mot de passe par défaut
	- statusCompteEmploye = 1 (Déja connecté et compte actif)
	- statusCompteEmploye = 2 (Compte employé désactivé)
	**********************************************************************************************/
	@Override
	public int checkStatutEmploye(String idEmploye) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		
		String requete = "SELECT statusCompteEmploye FROM employe WHERE idEmploye=?";
		int statut = 2;
		
		try {
			con = DBConnexion.getConnection();
			pstmt = con.prepareStatement(requete);
			pstmt.setString(1, idEmploye);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				statut = rs.getInt(1);
			}
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
		}
		return statut;
	}

	
	/*********************************************************************************************
	Service DAO pour pour valider le paiement suite à un achat
	  
	**********************************************************************************************/
	@Override
	public int validerPaiement(String numeroCode, float montant, String idCommercant)  {
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		
		ResultSet rs = null;
		
		Connection con = null;
		
		String req1 = "SELECT idEmploye FROM Qrcode WHERE numeroCode=?";
		String req2 = "SELECT soldeEmploye, depensesDuJour, statusCompteEmploye FROM employe WHERE idEmploye=?";        
		String req3 = "UPDATE employe SET soldeEmploye=? , depensesDuJour=? WHERE idEmploye=?";
		String req4 = "INSERT INTO achat (montant, dateAchat, idEmploye, idCommerce) VALUES (?,?,?,?)";
		
		int retour = 5;
		
		try {
			con = DBConnexion.getConnection();
			pstmt1 = con.prepareStatement(req1);
			pstmt1.setString(1, numeroCode);
			rs = pstmt1.executeQuery();
		
			sortie : if(rs.next()) {        //Etiquette pour sortir sans rentrer dans tous les if au premier if qui n'est pas validé 
				String idEmploye = rs.getString(1);
				System.out.println(idEmploye);
				pstmt2 = con.prepareStatement(req2);
				pstmt2.setString(1, idEmploye);
				rs = pstmt2.executeQuery();
				
				float solde;
				float depensesDuJour;
				int statutEmploye;
				
				if(rs.next()) {
					
					int jour = DateTime.now().getDayOfWeek();   // jour prend la valeur du jour de l'achat [ 1(Lundi) - 7(Dimanche) ]
					System.out.println(jour);
					solde = rs.getFloat(1);
					depensesDuJour = rs.getFloat(2);
					statutEmploye = rs.getInt(3);
					
					if(jour == 6 || jour == 7) {               // vérifie si on est pas en week-end [retour = 3]
						retour = 4;
						System.out.println("week-end");
						break sortie; 
					}
					
					if(statutEmploye == 2) {                  // vérifie si l'employé a encore un compte actif [retour = 2]
						retour = 3;
						System.out.println("compte désactivé");
						break sortie;
					}
						
					if(montant > solde) {                      // vérifie si le montant et supérieur au solde [retour = 1]
						retour = 2;
						System.out.println("solde insuffisant");
						break sortie;
					}
					
					if(montant <= solde) {                    
						if((depensesDuJour + montant) > PLAFOND_JOURNALIER) {      // vérifie si le plafond journalier n'a pas été dépassé
							retour = 0;
							System.out.println("solde journalier insuffisant");
							break sortie;
						}
						else {
							con.setAutoCommit(false);
							solde -= montant;
							depensesDuJour += montant;
							/*******Mise à jour du solde + depenses journalières ********/
							/************************************************************/
							pstmt3 = con.prepareStatement(req3);
							pstmt3.setFloat(1, solde);
							pstmt3.setFloat(2, depensesDuJour);
							pstmt3.setString(3, idEmploye);
							pstmt3.executeUpdate();
							/******Insertion des données concernant l'achat dans la table achat ******/
							/*************************************************************************/
							pstmt4 = con.prepareStatement(req4);
							pstmt4.setFloat(1, montant);
							System.out.println(DateTime.now().toString(dtfc));
							pstmt4.setString(2, DateTime.now().toString(dtfc));
							pstmt4.setString(3, idEmploye);
							pstmt4.setString(4, idCommercant);
							pstmt4.executeUpdate();
							
							con.commit();
							
							retour = 1;
						}
					}	
				}
			}
		 
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}finally {
			if(pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
		}
		
		return retour;
	}

	
	/*********************************************************************************************
	Service DAO pour pour obtenir le solde total et journalier
	**********************************************************************************************/
	@Override
	public Map<String, Float> getSoldeTotalEtJournalier(String idEmploye) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		
		String req = "SELECT soldeEmploye, depensesDuJour FROM employe WHERE idEmploye=?";
		HashMap<String, Float> soldeTotalEtJournalier = null;
		try {
			con = DBConnexion.getConnection();
			pstmt = con.prepareStatement(req);
			pstmt.setString(1, idEmploye);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				soldeTotalEtJournalier = new HashMap<String, Float>();
				soldeTotalEtJournalier.put("Solde Journalier", ( PLAFOND_JOURNALIER - rs.getFloat(2) ));
				soldeTotalEtJournalier.put("Solde total", rs.getFloat(1));
			}

		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
		}
		
		return soldeTotalEtJournalier;
	}

	
	
	/********************************************************************************************
	Service DAO pour pour obtenir les transactions des 30 derniers jours
	*********************************************************************************************/
	@Override
	public Map<String, Float> getLastMonthTransactions(String idCommerce) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		
		String req = "SELECT dateAchat, montant FROM achat WHERE idCommerce=? AND (dateAchat >= DATE_SUB(CURRENT_DATE, INTERVAL 1 MONTH)) ORDER BY dateAchat DESC";
		LinkedHashMap<String,Float> transactions = null;
		try {
			con = DBConnexion.getConnection();
			pstmt = con.prepareStatement(req);
			pstmt.setString(1, idCommerce);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				transactions = new LinkedHashMap<String, Float>();
				do {
					transactions.put(rs.getString(1).substring(0, 19), rs.getFloat(2));
				}while(rs.next());
			}
			
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
		}
		
		return transactions;
	}

	
	/********************************************************************************************
	Service DAO pour pour obtenir les achats des 30 derniers jours
	*********************************************************************************************/
	public List<Achat> getLastMonthAchats(String idCommerce){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		
		String req = "SELECT achat.dateAchat, achat.montant, commerce.nomCommerce FROM achat, commerce WHERE achat.idCommerce=commerce.idCommerce AND achat.idEmploye=? AND (dateAchat >= DATE_SUB(CURRENT_DATE, INTERVAL 1 MONTH)) ORDER BY achat.dateAchat DESC";
		
		List<Achat> achats = null;
		try {
			con = DBConnexion.getConnection();
			pstmt = con.prepareStatement(req);
			pstmt.setString(1, idCommerce);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				achats = new ArrayList<>();
				do {
					System.out.println(rs.getFloat(2));
					System.out.println(rs.getString(1).substring(0, 19));
					System.out.println(rs.getString("nomCommerce"));
					achats.add(new Achat(rs.getFloat(2), rs.getString(1).substring(0, 19),rs.getString("nomCommerce")));
				}while(rs.next());
			}
			
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
		}
		
		return achats;
	}
	
	
	/********************************************************************************************
	Service DAO pour pour obtenir les commerces à proximité
	*********************************************************************************************/
	public List<CommerceSerialized> getCommercesDAO(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		List<CommerceSerialized> listeDeCommerces = null;
		
		String req = "SELECT nomCommerce, adresseCommerce, codePostalCommerce, villeCommerce, telCommerce FROM commerce";
		try {
			con = DBConnexion.getConnection();
			pstmt = con.prepareStatement(req);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listeDeCommerces = new ArrayList<>();
				CommerceSerialized comSerialized;
				do {
					comSerialized = new CommerceSerialized();
					comSerialized.setNomCommerce(rs.getString("nomCommerce"));
					comSerialized.setAdresseCommerce(rs.getString("adresseCommerce")+ " " + rs.getString("codePostalCommerce")
					+ " " + rs.getString("villeCommerce"));
					comSerialized.setTelCommerce(rs.getString("telCommerce"));
					listeDeCommerces.add(comSerialized);
				}while(rs.next());
			}
			
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
		}
		return listeDeCommerces;
	}
	
	
	/**********************************************************************************************
	CheckStatusGerant : Service DAO pour obtenir le statut d'un gérant
	- statusCompteGerant = 0 (Jamais connecté) ==> Changement mot de passe par défaut
	- statusCompteGerant = 1 (Déja connecté et compte actif)
	- statusCompteGerant = 2 (Compte gerant désactivé)
	**********************************************************************************************/
	public int checkStatutGerant(String idGerant) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		
		String requete = "SELECT statusCompteGerant FROM gerant WHERE idGerant=?";
		int statut = 2;
		
		try {
			con = DBConnexion.getConnection();
			pstmt = con.prepareStatement(requete);
			pstmt.setString(1, idGerant);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				statut = rs.getInt(1);
			}
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
		}
		return statut;
	}
}
