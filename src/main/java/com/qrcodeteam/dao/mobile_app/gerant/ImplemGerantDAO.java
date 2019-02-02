package com.qrcodeteam.dao.mobile_app.gerant;

import com.qrcodeteam.bom.Commerce;
import com.qrcodeteam.bom.CommerceGerant;
import com.qrcodeteam.bom.Gerant;
import com.qrcodeteam.dao.DBConnexion;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ImplemGerantDAO implements IGerantDAO {
    private static final float PLAFOND_JOURNALIER = 19;
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public ImplemGerantDAO() {

    }

    /***********************************************************************************************
     authentification, Service DAO pour r�aliser l'authentification d'un commercant
     ************************************************************************************************/
    public CommerceGerant authentificationGerant(Connection con, String mailGerant, String mdpGerant) {
        PreparedStatement pstmt1;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
        ResultSet rs;


        String req1 = "SELECT COUNT(*) FROM gerant WHERE mailGerant=? AND mdpGerant=?";
        String req2 = "SELECT * FROM gerant WHERE mailGerant=? AND mdpGerant=?";
        String req3 = "SELECT * FROM commerce WHERE idGerant=?";
        CommerceGerant comGerant = null;
        Gerant gerant = null;
        Commerce commerce = null;
        try {
            pstmt1 = con.prepareStatement(req1);
            pstmt1.setString(1, mailGerant);
            pstmt1.setString(2, DigestUtils.md5Hex(mdpGerant));
            rs = pstmt1.executeQuery();
            if (rs.next()) {

                int nblignesCount;
                nblignesCount = rs.getInt(1);
                System.out.println(nblignesCount);
                if (nblignesCount > 0) {

                    pstmt2 = con.prepareStatement(req2);
                    pstmt2.setString(1, mailGerant);
                    pstmt2.setString(2, DigestUtils.md5Hex(mdpGerant));
                    rs = pstmt2.executeQuery();
                    if (rs.next()) {
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

                        if (rs.next()) {
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
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {
            if (pstmt2 != null) {
                try {
                    pstmt2.close();
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

            if (pstmt3 != null) {
                try {
                    pstmt3.close();
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
        return comGerant;

    }


    /**********************************************************************************************
     Service DAO pour Changer Mdp Gerant � la premi�re connexion
     ***********************************************************************************************/
    public String changeMdpGerant(String idGerant, String newMdp) {
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs;
        Connection con = null;

        String req1 = "SELECT COUNT(*) FROM gerant WHERE idGerant=?";
        String req2 = "UPDATE gerant SET mdpGerant=? ,statusCompteGerant=? WHERE idGerant=?";
        String retour = null;
        try {
            con = DBConnexion.getConnection();
            pstmt1 = con.prepareStatement(req1);
            pstmt1.setString(1, idGerant);
            rs = pstmt1.executeQuery();
            if (rs.next()) {
                int nbLignes = rs.getInt(1);
                System.out.print(nbLignes);
                if (nbLignes > 0) {
                    pstmt2 = con.prepareStatement(req2);
                    pstmt2.setString(1, DigestUtils.md5Hex(newMdp));
                    pstmt2.setInt(2, 1);
                    pstmt2.setString(3, idGerant);
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


    /*********************************************************************************************
     Service DAO pour pour valider le paiement suite � un achat
     **********************************************************************************************/
    @Override
    public int validerPaiement(String numeroCode, float montant, String idCommercant) {
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3;
        PreparedStatement pstmt4;

        ResultSet rs;

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

            sortie:
            if (rs.next()) {        //Etiquette pour sortir sans rentrer dans tous les if au premier if qui n'est pas valid�
                String idEmploye = rs.getString(1);
                System.out.println(idEmploye);
                pstmt2 = con.prepareStatement(req2);
                pstmt2.setString(1, idEmploye);
                rs = pstmt2.executeQuery();

                float solde;
                float depensesDuJour;
                int statutEmploye;

                if (rs.next()) {

                    int jour = DateTime.now().getDayOfWeek();   // jour prend la valeur du jour de l'achat [ 1(Lundi) - 7(Dimanche) ]
                    System.out.println(jour);
                    solde = rs.getFloat(1);
                    depensesDuJour = rs.getFloat(2);
                    statutEmploye = rs.getInt(3);

                    if (jour == 6 || jour == 7) {               // v�rifie si on est pas en week-end [retour = 3]
                        retour = 4;
                        System.out.println("week-end");
                        break sortie;
                    }

                    if (statutEmploye == 2) {                  // v�rifie si l'employ� a encore un compte actif [retour = 2]
                        retour = 3;
                        System.out.println("compte d�sactiv�");
                        break sortie;
                    }

                    if (montant > solde) {                      // v�rifie si le montant et sup�rieur au solde [retour = 1]
                        retour = 2;
                        System.out.println("solde insuffisant");
                        break sortie;
                    }

                    if (montant <= solde) {
                        if ((depensesDuJour + montant) > PLAFOND_JOURNALIER) {      // v�rifie si le plafond journalier n'a pas �t� d�pass�
                            retour = 0;
                            System.out.println("solde journalier insuffisant");
                            break sortie;
                        } else {
                            con.setAutoCommit(false);
                            solde -= montant;
                            depensesDuJour += montant;
                            /*******Mise a jour du solde + depenses journalieres ********/
                            /************************************************************/
                            pstmt3 = con.prepareStatement(req3);
                            pstmt3.setFloat(1, solde);
                            pstmt3.setFloat(2, depensesDuJour);
                            pstmt3.setString(3, idEmploye);
                            pstmt3.executeUpdate();
                            /******Insertion des donn�es concernant l'achat dans la table achat ******/
                            /*************************************************************************/
                            pstmt4 = con.prepareStatement(req4);
                            pstmt4.setFloat(1, montant);
                            System.out.println(DateTime.now().toString(dateTimeFormatter));
                            pstmt4.setString(2, DateTime.now().toString(dateTimeFormatter));
                            pstmt4.setString(3, idEmploye);
                            pstmt4.setString(4, idCommercant);
                            pstmt4.executeUpdate();

                            con.commit();

                            retour = 1;
                        }
                    }
                }
            }

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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


    /********************************************************************************************
     Service DAO pour pour obtenir les transactions des 30 derniers jours
     *********************************************************************************************/
    @Override
    public Map<String, Float> getLastMonthTransactions(String idCommerce) {
        PreparedStatement pstmt = null;
        ResultSet rs;
        Connection con = null;

        String req = "SELECT dateAchat, montant FROM achat WHERE idCommerce=? AND (dateAchat >= DATE_SUB(CURRENT_DATE, INTERVAL 1 MONTH)) ORDER BY dateAchat DESC";
        LinkedHashMap<String, Float> transactions = null;
        try {
            con = DBConnexion.getConnection();
            pstmt = con.prepareStatement(req);
            pstmt.setString(1, idCommerce);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                transactions = new LinkedHashMap<>();
                do {
                    transactions.put(rs.getString(1).substring(0, 19), rs.getFloat(2));
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

        return transactions;
    }


    /**********************************************************************************************
     CheckStatusGerant : Service DAO pour obtenir le statut d'un g�rant
     - statusCompteGerant = 0 (Jamais connect�) ==> Changement mot de passe par d�faut
     - statusCompteGerant = 1 (D�ja connect� et compte actif)
     - statusCompteGerant = 2 (Compte gerant d�sactiv�)
     **********************************************************************************************/
    public int checkStatutGerant(String idGerant) {
        PreparedStatement pstmt = null;
        ResultSet rs;
        Connection con = null;

        String requete = "SELECT statusCompteGerant FROM gerant WHERE idGerant=?";
        int statut = 2;

        try {
            con = DBConnexion.getConnection();
            pstmt = con.prepareStatement(requete);
            pstmt.setString(1, idGerant);
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
}
