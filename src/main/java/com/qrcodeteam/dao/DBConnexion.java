package com.qrcodeteam.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DBConnexion {
	private static final Logger LOGGER = LoggerFactory.getLogger(DBConnexion.class);
	private static String url = "jdbc:mysql://localhost:3306/projettransversal";
	private static String username = "root";
	private static String password = "";
	private static Connection connection = null;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, username, password);
			LOGGER.info("Connection OK");

		} catch (SQLException sqlException) {
			LOGGER.debug("!!! SQl Exception: " + sqlException.getMessage() +
					"\n" + "Error code: " + sqlException.getErrorCode());
		} catch (InstantiationException e) {
			LOGGER.debug("!!! Instantiation Exception: " + e.getMessage());
		} catch (IllegalAccessException e) {
			LOGGER.debug("!!! Illegal Access Exception: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			LOGGER.debug("!!! Class Not Found Exception " + e.getMessage());
		}

		return connection;
	}
	
	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
	}

	public static void closePreparedStatement(PreparedStatement preparedStatement) {
		try {
			preparedStatement.close();
		} catch (Exception e) {
			LOGGER.debug("Instantiation Exception:" + e.getMessage());
		}
	}


}
