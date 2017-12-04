package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This is dao class for Connection
 * 
 * @author Rishabh Goel
 *
 */
public class AbstractDao {
	private Connection con = null;

	/**
	 * This method is for making a JDBC connection
	 * 
	 * @return Connection
	 */
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

	/**
	 * This method closes the connection
	 * 
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		con.close();
	}

	/**
	 * This method commits the transactions
	 * 
	 * @throws SQLException
	 */
	public void commit() throws SQLException {
		con.commit();
	}

	/**
	 * This method closes the connection and commits the transaction
	 * 
	 * @throws SQLException
	 */
	public void commitAndCloseConnection() throws SQLException {
		con.commit();
		con.close();
	}

	/**
	 * This method rollback the transactions
	 * 
	 * @throws SQLException
	 */
	public void rollback() throws SQLException {
		con.rollback();
	}

	/**
	 * This method closes the connection and rollback the transaction
	 * 
	 * @throws SQLException
	 */
	public void rollbackAndCloseConnectiion() throws SQLException {
		con.rollback();
		con.close();
	}
}
