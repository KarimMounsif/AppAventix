package com.qrcodeteam.services;

import com.mysql.jdbc.Connection;
import com.qrcodeteam.utilitaire.JsonResponse;

public interface IEmployeService {
	public JsonResponse authentificationEmploye(Connection con, String mailEmploye, String mdpEmploye);
	public JsonResponse getQrCode(String idEmploye);
	public JsonResponse changeMdpEmploye(String idEmploye, String newMdp);
	public JsonResponse getSoldeTotalEtJournalier(String idEmploye);
	public JsonResponse getLastMonthAchats(String idEmploye);
	public JsonResponse getCommerces();
}
