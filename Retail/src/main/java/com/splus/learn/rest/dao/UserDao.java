package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.splus.learn.rest.beans.User;
/**
 * This class is for User Dao
 * 
 * @author Nazish.Khatoon
 *
 */

public class UserDao extends AbstractDao {
	/**
	 * This method is for selecting all the details from the database where passed
	 * user name matches with the u_name and password with the password in the table
	 * 
	 * @param user
	 * @param con
	 * @return user
	 * @throws SQLException
	 */
	public User login(User user, Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		String uName = user.getUserName();
		String password = user.getPassword();
		String query = "select user_id,f_name,l_name,u_name from user where u_name= '" + uName + "'AND password= '"
				+ password + "'AND record_status>0";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			user.setId(rs.getInt("user_id"));
			user.setfName(rs.getString("f_name"));
			user.setlName(rs.getString("l_name"));
			user.setUserName(rs.getString("u_name"));
		}

		return user;
	}

	/**
	 * This method update the token and timestamp in the user table where passed id
	 * matches with user_id
	 * 
	 * @param token
	 * @param id
	 * @return rs
	 * @throws SQLException
	 */
	public int setToken(String token, int id) throws SQLException {
		Connection con = connect();
		Statement stmt = con.createStatement();
		String query = "update user set token= '" + token + "', tokengenerated_at= NOW() where user_id='" + id
				+ "'AND record_status>0";
		int rs = stmt.executeUpdate(query);
		return rs;

	}

	/**
	 * This method inserts the data of user into database
	 * 
	 * @param user
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public int saveUser(User user, Connection con) throws SQLException {

		String query = "insert into user(user_id,f_name,l_name,u_name,password,created_by,created_at,record_status) "
				+ "values(?,?,?,?,?,?,NOW(),1)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, user.getId());
		ps.setString(2, user.getfName());
		ps.setString(3, user.getlName());
		ps.setString(4, user.getUserName());
		ps.setString(5, user.getPassword());
		ps.setString(6, user.getfName());
		int rs = ps.executeUpdate();
		return rs;
	}

	/**
	 * This method updates the data in the database for user
	 * 
	 * @param user
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public int updateUser(User user, Connection con) throws SQLException {

		String query = "update user set f_name=?,l_name=?,u_name=?,password=?,lastmodified_by=?,lastmodified_at=NOW() where user_id=? AND record_status>0";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, user.getfName());
		ps.setString(2, user.getlName());
		ps.setString(3, user.getUserName());
		ps.setString(4, user.getPassword());
		ps.setString(5, user.getfName());
		ps.setInt(6, user.getId());
		int rs = ps.executeUpdate();
		return rs;
	}

	/**
	 * This method logically deletes the data of a order by setting its record
	 * status as 0
	 * 
	 * @param user
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public int deleteUser(User user, Connection con) throws SQLException {
		String query = "update user set lastmodified_by=?,lastmodified_at=NOW(),record_status=0 where user_id=? AND record_status>0";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, user.getfName());
		ps.setInt(2, user.getId());
		int rs = ps.executeUpdate();
		return rs;
	}

}
