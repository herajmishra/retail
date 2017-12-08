package com.splus.learn.rest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.User;
import com.splus.learn.rest.dao.UserDao;
import com.splus.learn.rest.enums.Status;

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

	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when inserting a user
	 * 
	 * @param user
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse saveUser(User user) throws SQLException {
		UserDao userDao = new UserDao();
		Connection con = userDao.connect();
		int rs = userDao.saveUser(user, con);
		ApiResponse response = new ApiResponse();
		if (rs == 1) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		userDao.commitAndCloseConnection();
		response.setResult(user);
		return response;
	}

	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when updating a user
	 * 
	 * @param user
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse updateUser(User user) throws SQLException {
		UserDao userDao = new UserDao();
		Connection con = userDao.connect();
		int rs = userDao.updateUser(user, con);
		ApiResponse response = new ApiResponse();
		if (rs == 1) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		userDao.commitAndCloseConnection();
		response.setResult(user);
		return response;
	}

	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when deleting a user
	 * 
	 * @param user
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse deleteUser(User user) throws SQLException {
		UserDao userDao = new UserDao();
		Connection con = userDao.connect();
		int rs = userDao.deleteUser(user, con);
		ApiResponse response = new ApiResponse();
		if (rs == 1) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		userDao.commitAndCloseConnection();
		response.setResult(user);
		return response;
	}
}
