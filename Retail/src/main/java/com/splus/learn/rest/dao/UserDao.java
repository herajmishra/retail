package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.splus.learn.rest.beans.User;

public class UserDao extends AbstractDao {
		public User login(User user,Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		String uName = user.getUserName();
		String password = user.getPassword();
		String query = "select user_id,f_name,l_name,u_name from user where u_name= '" + uName + "'AND password= '"
				+ password + "'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			user.setId(rs.getInt("user_id"));
			user.setfName(rs.getString("f_name"));
			user.setlName(rs.getString("l_name"));
			user.setUserName(rs.getString("u_name"));
		}
		

		return user;
	}

	public int setToken(String token, int id) throws SQLException {
		Connection con = connect();
		Statement stmt = con.createStatement();
		String query = "update user set token= '" + token + "', tokengenerated_at= NOW() where user_id='"
				+ id + "'";
		int rs = stmt.executeUpdate(query);
		return rs;
		
	}
}