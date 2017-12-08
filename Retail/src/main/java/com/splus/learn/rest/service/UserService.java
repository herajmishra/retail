package com.splus.learn.rest.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.User;
import com.splus.learn.rest.dao.UserDao;
import com.splus.learn.rest.enums.Status;
import java.util.UUID;

/**
 * This is the class for User Service
 * 
 * @author Nazish.Khatoon
 *
 */
public class UserService {
	/**
	 * This method generate a random string and returns the status and description
	 * based on the passed user id
	 * 
	 * @param user
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse login(User user) throws SQLException {
		UserDao userDao = new UserDao();
		Connection con = userDao.connect();
		user = userDao.login(user, con);
		ApiResponse response = new ApiResponse();
		if (user.getId() > 0) {
			String token = UUID.randomUUID().toString();
			token = token.replace("-", "");
			int rowsAffected = userDao.setToken(token, user.getId());
			if (rowsAffected == 1) {
				response.setCode(Status.SUCCESS.status());
				response.setMessage(Status.SUCCESS.description());
				user.setToken(token);
			}

		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		userDao.commitAndCloseConnection();
		response.setResult(user);
		return response;
	}
}
