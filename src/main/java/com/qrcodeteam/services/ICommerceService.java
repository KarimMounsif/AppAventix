package com.qrcodeteam.services;

import com.mysql.jdbc.Connection;
import com.qrcodeteam.utilitaire.JsonResponse;

public interface ICommerceService {
	public JsonResponse authentificationGerant(Connection con, String mailGerant, String mdpGerant);
	public JsonResponse paiement(String numeroCode, float montant, String idCommercant);
	public JsonResponse getLastMonthTransactions(String idCommerce);
	public JsonResponse changeMdpGerant(String idGerant, String newMdp);
}
