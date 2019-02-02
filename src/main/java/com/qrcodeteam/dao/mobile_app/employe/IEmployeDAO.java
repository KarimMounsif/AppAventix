package com.qrcodeteam.dao.mobile_app.employe;

import com.qrcodeteam.bom.Achat;
import com.qrcodeteam.bom.Commerce;
import com.qrcodeteam.bom.EmployeQrCodeRest;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface IEmployeDAO {

    EmployeQrCodeRest authentificationEmploye(Connection con, String mailEmploye, String mdpEmploye);

    Map<String, String> getQrCode(Connection con, String idEmploye);

    String changeMdpEmploye(String idEmploye, String newMdp);

    int checkStatutEmploye(String idEmploye);

    Map<String, Float> getSoldeTotalEtJournalier(String idEmploye);

    List<Achat> getLastMonthAchats(String idCommerce);

    List<Commerce> getCommercesDAO();
}
