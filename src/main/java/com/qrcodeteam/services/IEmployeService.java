package com.qrcodeteam.services;

import com.mysql.jdbc.Connection;
import com.qrcodeteam.utilitaire.JsonResponse;

public interface IEmployeService {
	public JsonResponse authentificationEmploye(Connection con, String mailEmploye, String mdpEmploye);
	public JsonResponse authentificationGerant(Connection con, String mailGerant, String mdpGerant);
	public JsonResponse getQrCode(String idEmploye);
	public JsonResponse changeMdpEmploye(String idEmploye, String newMdp);
	public JsonResponse paiement(String numeroCode, float montant, String idCommercant);
	public JsonResponse getSoldeTotalEtJournalier(String idEmploye);
	public JsonResponse getLastMonthTransactions(String idCommerce);
}
