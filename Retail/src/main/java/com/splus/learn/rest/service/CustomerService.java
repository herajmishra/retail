package com.splus.learn.rest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.Customer;
import com.splus.learn.rest.dao.CustomerDao;
import com.splus.learn.rest.enums.Status;

/**
 * This is service class for Customer
 * 
 * @author Rishabh Goel
 *
 */
public class CustomerService {
	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when finding by customerNumber
	 * 
	 * @param customer
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse customerById(Customer customer) throws SQLException {
		CustomerDao customerDao = new CustomerDao();
		Connection con = customerDao.connect();
		customer = customerDao.customerById(customer, con);
		ApiResponse response = new ApiResponse();
		if (customer.getCustomerNumber() > 0) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		customerDao.commitAndCloseConnection();
		response.setResult(customer);
		return response;
	}

	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when finding all customers
	 * 
	 * @param customer
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse customerShow(Customer customer) throws SQLException {
		CustomerDao customerDao = new CustomerDao();
		Connection con = customerDao.connect();
		List<Customer> customers = customerDao.customerShow(customer, con);
		ApiResponse response = new ApiResponse();
		if (customers != null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		customerDao.closeConnection();
		response.setResult(customers);
		return response;
	}
}
