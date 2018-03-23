package com.qrcodeteam.dao;


import java.sql.Connection;

import com.qrcodeteam.beans.EmployeQrcodeRest;

public interface InterfaceServiceDAO {
	
	public EmployeQrcodeRest authentification(Connection con, String mailEmploye, String mdpEmploye);
	public String getQrCode(Connection con, String idEmploye);
	

}
