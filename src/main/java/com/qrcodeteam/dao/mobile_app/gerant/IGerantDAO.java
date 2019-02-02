package com.qrcodeteam.dao.mobile_app.gerant;


import com.qrcodeteam.bom.CommerceGerant;

import java.sql.Connection;
import java.util.Map;

public interface IGerantDAO {

    CommerceGerant authentificationGerant(Connection con, String mailGerant, String mdpGerant);

    Map<String, Float> getLastMonthTransactions(String idCommerce);

    int checkStatutGerant(String idGerant);

    String changeMdpGerant(String idGerant, String newMdp);

    int validerPaiement(String numeroCode, float montant, String idCommercant);
}
