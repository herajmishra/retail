package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDao {
	private Connection con = null;

	public Connection connect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/retails", "root", "root");
			con.setAutoCommit(false);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public void closeConnection() throws SQLException {
		con.close();
	}

	public void commit() throws SQLException {
		con.commit();
	}
	
	public void commitAndCloseConnection() throws SQLException {
		con.commit();
		con.close();
	}
	
	public void rollback() throws SQLException {
		con.rollback();
	}
	
	public void rollbackAndCloseConnectiion() throws SQLException {
		con.rollback();
		con.close();
	}
}
