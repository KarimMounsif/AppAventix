package com.qrcodeteam.dao;

import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class DBConnexion {
	private static String url="jdbc:mysql://localhost:8889/ProjetTransversal";
	private static String username="root";
	private static String password="root";
	private static Connection con=null;
	private static final Logger log = LoggerFactory.getLogger(DBConnexion.class);
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection(url,username,password);
			System.out.println("OK");
			
		}catch(SQLException ex) {
			
			System.out.println("ici1");
			System.out.println(ex.getMessage());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(Connection con) {
		try {
			con.close();
		}catch(Exception ex) {
			ex.getMessage();
		}
	}
	
	
	
	public static void main (String []args) {
		
	}

}
