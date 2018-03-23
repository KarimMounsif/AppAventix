package com.qrcodeteam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;

import com.qrcodeteam.beans.Employe;
import com.qrcodeteam.beans.EmployeQR;
import com.qrcodeteam.utilitaire.FluxHandler;
import com.qrcodeteam.utilitaire.IdentifiantGenerateur;

public class EmployeDAO {
	static DateTime dt= new DateTime();
	static DateTimeFormatter dtf=DateTimeFormat.forPattern("yyyy-MM-dd");
	
	
	public static List<Employe> getLastTenEmploye(Connection con, String idEntreprise){
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		
		List<Employe> listEmploye = new ArrayList<Employe>();
		String req="SELECT * FROM EMPLOYE WHERE IDENTREPRISE=? ORDER BY DATECREATIONCOMPTEEMPLOYE DESC LIMIT 10";
		String req2="SELECT COUNT(*) FROM QRCODE WHERE IDEMPLOYE=?";
		
		try {
			pstmt=con.prepareStatement(req);
			pstmt.setString(1, idEntreprise);
			System.out.println("N° Entreprise : "+idEntreprise);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Employe e= new Employe();
				e.setDateCreationCompteEmploye(new DateTime(rs.getString("dateCreationCompteEmploye").replace(" ", "T")));
				e.setNomEmploye(rs.getString("nomEmploye"));
				e.setPrenomEmploye(rs.getString("prenomEmploye"));
				e.setMailEmploye(rs.getString("mailEmploye"));
				e.setTelEmploye(rs.getString("telEmploye"));
				System.out.println("N° Entreprise :"+idEntreprise);
				
				pstmt2=con.prepareStatement(req2);
				pstmt2.setString(1, rs.getString("idEmploye"));
				rs2=pstmt2.executeQuery();
				if(rs2.next() && rs2.getInt(1)>0) {
					 e.setStatusCompteEmploye(1);// user le champ status pour savoir si employe assigne ou non;
					 
					 System.out.println("N° Ligne :"+rs2.getInt(1));
				}else {
					 e.setStatusCompteEmploye(0); // non assigné
					 System.out.println("N° Ligne 2 :"+rs2.getInt(1));
				}
				
				listEmploye.add(e);
			}
			
			return listEmploye;
			
		}catch(SQLException sql) {
			sql.getMessage();
			return listEmploye;
		}
	}
	
	public static void insertEmploye(Connection con, EmployeQR e,String idEntreprise) {
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		String req="INSERT INTO EMPLOYE(idEmploye,nomEmploye,prenomEmploye,ddnEmploye,typeEmploye,telEmploye,mailEmploye,soldeEmploye,mdpEmploye"
				+",statusCompteEmploye,dateCreationCompteEmploye,dateDerniereConnexionEmploye,idEntreprise) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		String req2="UPDATE QRCODE SET idEmploye = ? WHERE idEntreprise = ? AND idEmploye is null LIMIT 1";
		//Stocker mdp fichier local
		//TODO Envoyer par mail
		String password = IdentifiantGenerateur.generatorPassword(16);
		
		FluxHandler fh= new FluxHandler("Password");
		String contenu="User :"+e.getE().getNomEmploye()+"_"+e.getE().getIdEmploye()+" Password :"+password;
		fh.ecrireFichier("password_users", contenu+" _mdpHash_ :"+DigestUtils.md5Hex(password));
		
		
		password=DigestUtils.md5Hex(password);
		

		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(req);
			pstmt.setString(1, e.getE().getIdEmploye());
			pstmt.setString(2, e.getE().getNomEmploye());
			pstmt.setString(3, e.getE().getPrenomEmploye());
			//TODO pstmt.setString(4, g.getDdnGerant().toString(dtf));
			pstmt.setString(4, new DateTime().toString(dtf));
			pstmt.setInt(5, 0);
			pstmt.setString(6, e.getE().getTelEmploye());
			pstmt.setString(7, e.getE().getMailEmploye());
			pstmt.setFloat(8, 0);
			pstmt.setString(9, password);
			pstmt.setInt(10, 0);
			pstmt.setString(11, new DateTime().toString(dtf));
			pstmt.setString(12, new DateTime().toString(dtf));
			pstmt.setString(13,idEntreprise);
			
			pstmt.executeUpdate();
			
			if(e.isAssignQR()==true) {
				pstmt2 = con.prepareStatement(req2);
				pstmt2.setString(1, e.getE().getIdEmploye());
				pstmt2.setString(2, idEntreprise);
				pstmt2.executeUpdate();
			}
			con.commit();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			try {
			con.rollback();
			} catch (SQLException exc) {
				exc.printStackTrace();
				System.out.println(ex.getMessage());
			}
			} finally {
			try {
			pstmt.close();
			if(e.isAssignQR()==true) {
			pstmt2.close();
			}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			} finally {
				DBConnexion.closeConnection(con);
			}
		}
	}
	
	public static void assignerQRCODE(Connection con, EmployeQR e,String idEntreprise) {
		PreparedStatement pstmt2=null;
		String req2="UPDATE QRCODE SET idEmploye = ? WHERE idEntreprise = ? AND idEmploye is null LIMIT 1";
		try {
			pstmt2 = con.prepareStatement(req2);
			pstmt2.setString(1, e.getE().getIdEmploye());
			pstmt2.setString(2, idEntreprise);
			pstmt2.executeUpdate();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		} finally {
		try {
			pstmt2.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			} finally {
				DBConnexion.closeConnection(con);
			}
		}
	}
	
	public static List<Employe> ListerEmployeSansQR(Connection con, String idEntreprise) {
		List <Employe> liste = new ArrayList<Employe>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String req="SELECT * FROM employe WHERE idEntreprise = ? AND statusCompteEmploye !=2 AND" +
		"(idEmploye NOT IN (SELECT idemploye FROM qrcode WHERE idemploye is not null))";
		try {
			pstmt = con.prepareStatement(req);
			pstmt.setString(1, idEntreprise);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Employe emp = new Employe(rs.getString("idEmploye"),rs.getString("nomEmploye"),rs.getString("prenomEmploye"),
						rs.getString("CiviliteEmploye"),new DateTime(rs.getTimestamp("ddnEmploye")),rs.getInt("typeEmploye"),
						rs.getString("telEmploye"), rs.getString("mailEmploye"),rs.getFloat("soldeEmploye"),rs.getString("mdpEmploye"),
						rs.getInt("statusCompteEmploye"), new DateTime(rs.getTimestamp("dateCreationCompteEmploye")),
						new DateTime(rs.getTimestamp("dateDerniereConnexionEmploye")),rs.getString("idEntreprise"));
				liste.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			} finally {
				DBConnexion.closeConnection(con);
			}
		}
		return liste;
	}
	
	public static List<Employe> ListerEmployeAvecQR(Connection con, String idEntreprise) {
		List <Employe> liste = new ArrayList<Employe>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String req="SELECT * FROM employe WHERE idEntreprise = ? AND statusCompteEmploye !=2 AND " +
		"(idEmploye IN (SELECT idemploye FROM qrcode WHERE idemploye is not null))";
		try {
			pstmt = con.prepareStatement(req);
			pstmt.setString(1, idEntreprise);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Employe emp = new Employe(rs.getString("idEmploye"),rs.getString("nomEmploye"),rs.getString("prenomEmploye"),
						rs.getString("CiviliteEmploye"),new DateTime(rs.getTimestamp("ddnEmploye")),rs.getInt("typeEmploye"),
						rs.getString("telEmploye"), rs.getString("mailEmploye"),rs.getFloat("soldeEmploye"),rs.getString("mdpEmploye"),
						rs.getInt("statusCompteEmploye"), new DateTime(rs.getTimestamp("dateCreationCompteEmploye")),
						new DateTime(rs.getTimestamp("dateDerniereConnexionEmploye")),rs.getString("idEntreprise"));
				liste.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			} finally {
				DBConnexion.closeConnection(con);
			}
		}
		return liste;
	}
	public static Employe getEmploye(Connection con, String idEmploye, String idEntreprise) {
		Employe emp = new Employe();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String req="SELECT * FROM employe WHERE idEntreprise = ? AND" +
		"(idEmploye = ?)";
		try {
			pstmt = con.prepareStatement(req);
			pstmt.setString(1, idEntreprise);
			pstmt.setString(2, idEmploye);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				emp = new Employe(rs.getString("idEmploye"),rs.getString("nomEmploye"),rs.getString("prenomEmploye"),
						rs.getString("CiviliteEmploye"),new DateTime(rs.getTimestamp("ddnEmploye")),rs.getInt("typeEmploye"),
						rs.getString("telEmploye"), rs.getString("mailEmploye"),rs.getFloat("soldeEmploye"),rs.getString("mdpEmploye"),
						rs.getInt("statusCompteEmploye"), new DateTime(rs.getTimestamp("dateCreationCompteEmploye")),
						new DateTime(rs.getTimestamp("dateDerniereConnexionEmploye")),rs.getString("idEntreprise"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			} finally {
				DBConnexion.closeConnection(con);
			}
		}
		return emp;
	}
	
	public static void UpdateEmploye(Connection con, Employe e, String idEntreprise) {
		PreparedStatement pstmt=null;
		String req="UPDATE employe SET nomEmploye=?, prenomEmploye=?, civiliteEmploye=?, ddnEmploye=?, telEmploye=? WHERE (idEmploye=? AND idEntreprise = ?)";
		try {
			pstmt=con.prepareStatement(req);
			pstmt.setString(1, e.getNomEmploye());
			pstmt.setString(2, e.getPrenomEmploye());
			pstmt.setString(3, e.getCiviliteEmploye());
			pstmt.setString(4,  new DateTime().toString(dtf));
			pstmt.setString(5, e.getTelEmploye());
			pstmt.setString(6, e.getIdEmploye());
			pstmt.setString(7, idEntreprise);
			pstmt.executeUpdate();
			System.out.println("Employ� Modifi� avec les infos suivantes : " + e.getNomEmploye() + " et entreprise = " + idEntreprise + " et idemp = " + e.getIdEmploye());
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			} finally {
				DBConnexion.closeConnection(con);
			}
		}
	}
	
	public static void SupprimerEmploye(Connection con, String idEmploye, String idEntreprise) {
		PreparedStatement pstmt=null;
		String req="UPDATE employe SET statusCompteEmploye=? WHERE (idEmploye=? AND idEntreprise = ?)";
		try {
			pstmt=con.prepareStatement(req);
			pstmt.setInt(1, 2);
			pstmt.setString(2, idEmploye);
			pstmt.setString(3, idEntreprise);
			pstmt.executeUpdate();
			//System.out.println("Employ� supprim� avec les infos suivantes : entreprise = " + idEntreprise + " et idemp = " + idEmploye);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			} finally {
				DBConnexion.closeConnection(con);
			}
		}
	}
	
	public static void RechargerEmploye(Connection con, String idEmploye, String idEntreprise, float prix) {
		PreparedStatement pstmt=null;
		String req="UPDATE employe SET soldeEmploye = soldeEmploye + ? WHERE (idEmploye=? AND idEntreprise = ?)";
		try {
			pstmt=con.prepareStatement(req);
			pstmt.setFloat(1, prix);
			pstmt.setString(2, idEmploye);
			pstmt.setString(3, idEntreprise);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			} finally {
				DBConnexion.closeConnection(con);
			}
		}
	}
	public static int CheckDoublon(Connection con, String mailEmploye) {
		PreparedStatement pstmt = null;
		String req = "SELECT idEmploye FROM employe WHERE mailEmploye=?";
		ResultSet res = null;
		int i=0;
		try {
			pstmt=con.prepareStatement(req);
			pstmt.setString(1, mailEmploye);
			res=pstmt.executeQuery();
			if(res.next()) {
				i=1;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			i=1;
		} finally {
			try {
				pstmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			} finally {
				DBConnexion.closeConnection(con);
			}
		}
		return i;
	}
}