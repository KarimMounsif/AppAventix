package com.qrcodeteam.dao.mobile_app.employe;

import com.qrcodeteam.bom.*;
import com.qrcodeteam.dao.DBConnexion;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplemEmployeDAO implements IEmployeDAO {

    private static final float PLAFOND_JOURNALIER = 19;
    private static final Logger LOGGER = LoggerFactory.getLogger(ImplemEmployeDAO.class);

    /***********************************************************************************************
     authentification, Service DAO pour realiser l'authentification d'un employe
     ************************************************************************************************/
    @Override
    public EmployeQrCodeRest authentificationEmploye(Connection con, String mailEmploye, String mdpEmploye) {

        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;

        String req1 = "SELECT COUNT(*) FROM employe WHERE mailEmploye=? AND mdpEmploye=?"; // erreur AND au lieu de OR
        String req2 = "SELECT * FROM employe WHERE mailEmploye=? AND mdpEmploye=?";        // pareil
        String req3 = "SELECT * FROM qrcode WHERE idEmploye=?"; //erreur numeroQr au lieu de *

        EmployeQrCodeRest employeQrCodeRest = null;
        Employe e;
        Qrcode qr;

        try {

            pstmt = con.prepareStatement(req1);
            pstmt.setString(1, mailEmploye);
            pstmt.setString(2, DigestUtils.md5Hex(mdpEmploye));


            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                int nbLigne = resultSet.getInt(1);
                //User trouvé
                if (nbLigne > 0) {
                    pstmt2 = con.prepareStatement(req2);
                    pstmt2.setString(1, mailEmploye);
                    pstmt2.setString(2, DigestUtils.md5Hex(mdpEmploye));
                    resultSet = pstmt2.executeQuery();

                    if (resultSet.next()) {
                        // initialiser un employé

                        e = new Employe();
                        e.setIdEmploye(resultSet.getString("idEmploye"));
                        e.setNomEmploye(resultSet.getString("nomEmploye"));
                        e.setPrenomEmploye(resultSet.getString("PrenomEmploye"));
                        e.setCiviliteEmploye(resultSet.getString("civiliteEmploye"));
                        e.setDdnEmploye(resultSet.getString("ddnEmploye"));
                        e.setTypeEmploye(resultSet.getInt("typeEmploye"));
                        e.setTelEmploye(resultSet.getString("telEmploye"));
                        e.setMailEmploye(resultSet.getString("mailEmploye"));
                        e.setSoldeEmploye(resultSet.getFloat("soldeEmploye"));
                        e.setMdpEmploye(resultSet.getString("mdpEmploye"));
                        e.setDateCreationCompteEmploye(resultSet.getString("dateCreationCompteEmploye").substring(0, 10));
                        e.setDateDerniereConnexionEmploye(resultSet.getString("dateDerniereConnexionEmploye").substring(0, 10));
                        e.setIdEntreprise(resultSet.getString("idEntreprise"));
                        e.setStatusCompteEmploye(resultSet.getInt("statusCompteEmploye"));
                        //Recuperer son QrCode

                        pstmt3 = con.prepareStatement(req3);
                        LOGGER.debug(e.getIdEmploye());
                        pstmt3.setString(1, e.getIdEmploye());
                        resultSet = pstmt3.executeQuery();
                        //Qrcode qr =null;

                        if (resultSet.next()) {
                            //System.out.println("Initialisation Qr debut");
                            qr = new Qrcode();
                            qr.setIdQrcode(resultSet.getString("idQrcode"));
                            qr.setNumeroCode(resultSet.getString("numeroCode"));
                            qr.setPrixQrCode(resultSet.getFloat("prixQrCode"));
                            qr.setIdEntreprise(resultSet.getString("idEntreprise"));
                            qr.setIdEmploye(resultSet.getString("idEmploye"));
                            qr.setIdCommande(resultSet.getString("idCommande"));
                            qr.setStatusQrCode(resultSet.getInt("statusQrCode"));

                            //new DateTime (resultSet.getString("dateCreationQrCode"))
                            //System.out.println("Initialisation QR fin");
                        } else {
                            qr = new Qrcode();
                            qr.setNumeroCode("Non assigne");
                        }

                        employeQrCodeRest = new EmployeQrCodeRest(e, qr);
                    }
                }
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }

            if (pstmt2 != null) {
                try {
                    pstmt2.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }

            if (pstmt3 != null) {
                try {
                    pstmt3.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        }

        LOGGER.debug("return");
        return employeQrCodeRest;
    }


    /***********************************************************************************************
     getQrCode, Service DAO pour obtenir le QR code a la demande
     ***********************************************************************************************/
    @Override
    public Map<String, String> getQrCode(Connection con, String idEmploye) {
        PreparedStatement pstmt = null;
        ResultSet rs;

        String requete = "SELECT * FROM qrcode WHERE idEmploye=?";

        HashMap<String, String> code = null;

        try {
            pstmt = con.prepareStatement(requete);
            pstmt.setString(1, idEmploye);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                code = new HashMap<>();
                code.put("QrCode", rs.getString("numeroCode"));
            }
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                }
            }

            if (DBConnexion.getConnection() != null) {
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
     Service DAO pour Changer Mdp Employe � la premi�re connexion
     ***********************************************************************************************/
    @Override
    public String changeMdpEmploye(String idEmploye, String newMdp) {
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs;
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
            if (rs.next()) {
                int nbLignes = rs.getInt(1);
                System.out.print(nbLignes);
                if (nbLignes > 0) {
                    pstmt2 = con.prepareStatement(req2);
                    pstmt2.setString(1, DigestUtils.md5Hex(newMdp));
                    pstmt2.setInt(2, 1);
                    pstmt2.setString(3, idEmploye);
                    pstmt2.executeUpdate();
                    retour = DigestUtils.md5Hex(newMdp);
                }
            }

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {
            if (pstmt1 != null) {
                try {
                    pstmt1.close();
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                }
            }

            if (pstmt2 != null) {
                try {
                    pstmt2.close();
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                }
            }

            if (con != null) {
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
     CheckStatutEmploye : Service DAO pour obtenir le statut d'un employ�
     - statusCompteEmploye = 0 (Jamais connect�) ==> Changement mot de passe par d�faut
     - statusCompteEmploye = 1 (D�ja connect� et compte actif)
     - statusCompteEmploye = 2 (Compte employ� d�sactiv�)
     **********************************************************************************************/
    @Override
    public int checkStatutEmploye(String idEmploye) {

        PreparedStatement pstmt = null;
        ResultSet rs;
        Connection con = null;

        String requete = "SELECT statusCompteEmploye FROM employe WHERE idEmploye=?";
        int statut = 2;

        try {
            con = DBConnexion.getConnection();
            pstmt = con.prepareStatement(requete);
            pstmt.setString(1, idEmploye);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                statut = rs.getInt(1);
            }
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                }
            }

            if (con != null) {
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
     Service DAO pour pour obtenir le solde total et journalier
     **********************************************************************************************/
    @Override
    public Map<String, Float> getSoldeTotalEtJournalier(String idEmploye) {

        PreparedStatement pstmt = null;
        ResultSet rs;
        Connection con = null;

        String req = "SELECT soldeEmploye, depensesDuJour FROM employe WHERE idEmploye=?";
        HashMap<String, Float> soldeTotalEtJournalier = null;
        try {
            con = DBConnexion.getConnection();
            pstmt = con.prepareStatement(req);
            pstmt.setString(1, idEmploye);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                soldeTotalEtJournalier = new HashMap<>();
                soldeTotalEtJournalier.put("Solde Journalier", (PLAFOND_JOURNALIER - rs.getFloat(2)));
                soldeTotalEtJournalier.put("Solde total", rs.getFloat(1));
            }

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                }
            }

            if (con != null) {
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
     Service DAO pour pour obtenir les commerces � proximit�
     *********************************************************************************************/
    public List<Commerce> getCommercesDAO() {
        PreparedStatement pstmt = null;
        ResultSet rs;
        Connection con = null;
        List<Commerce> listeDeCommerces = null;

        String req = "SELECT nomCommerce, adresseCommerce, codePostalCommerce, villeCommerce, telCommerce FROM commerce";
        try {
            con = DBConnexion.getConnection();
            pstmt = con.prepareStatement(req);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listeDeCommerces = new ArrayList<>();
                Commerce comSerialized;
                do {
                    comSerialized = new Commerce();
                    comSerialized.setNomCommerce(rs.getString("nomCommerce"));
                    comSerialized.setAdresseCommerce(rs.getString("adresseCommerce") + " " + rs.getString("codePostalCommerce")
                            + " " + rs.getString("villeCommerce"));
                    comSerialized.setTelCommerce(rs.getString("telCommerce"));
                    listeDeCommerces.add(comSerialized);
                } while (rs.next());
            }

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                }
            }
        }
        return listeDeCommerces;
    }


    /********************************************************************************************
     Service DAO pour pour obtenir les achats des 30 derniers jours
     *********************************************************************************************/
    public List<Achat> getLastMonthAchats(String idCommerce) {
        PreparedStatement pstmt = null;
        ResultSet rs;
        Connection con = null;

        String req = "SELECT achat.dateAchat, achat.montant, commerce.nomCommerce FROM achat, commerce WHERE achat.idCommerce=commerce.idCommerce AND achat.idEmploye=? AND (dateAchat >= DATE_SUB(CURRENT_DATE, INTERVAL 1 MONTH)) ORDER BY achat.dateAchat DESC";

        List<Achat> achats = null;
        try {
            con = DBConnexion.getConnection();
            pstmt = con.prepareStatement(req);
            pstmt.setString(1, idCommerce);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                achats = new ArrayList<>();
                do {
                    System.out.println(rs.getFloat(2));
                    System.out.println(rs.getString(1).substring(0, 19));
                    System.out.println(rs.getString("nomCommerce"));
                    achats.add(new Achat(rs.getFloat(2), rs.getString(1).substring(0, 19), rs.getString("nomCommerce")));
                } while (rs.next());
            }

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                }
            }
        }

        return achats;
    }


}
