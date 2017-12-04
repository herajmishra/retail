package com.splus.learn.rest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.Customer;
import com.splus.learn.rest.dao.CustomerDao;
import com.splus.learn.rest.enums.Status;

public class CustomerService {
	public ApiResponse customerById(Customer customer) throws SQLException {
		CustomerDao customerDao = new CustomerDao();
		Connection con = customerDao.connect();
		customer = customerDao.customerById(customer,con);
		ApiResponse response = new ApiResponse();
		if(customer.getCustomerNumber()>0) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		}else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		 customerDao.commitAndCloseConnection();
		response.setResult(customer);
		return response;
	}
	public ApiResponse customerShow(Customer customer) throws SQLException {
		CustomerDao customerDao = new CustomerDao();
		Connection con = customerDao.connect();
		List<Customer> customers = customerDao.customerShow(customer,con);
		ApiResponse response = new ApiResponse();
		if(customers!=null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		}else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		customerDao.closeConnection();
		response.setResult(customers);
		return response;
	}
}
