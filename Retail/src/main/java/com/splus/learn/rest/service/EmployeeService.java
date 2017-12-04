package com.splus.learn.rest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.Employee;
import com.splus.learn.rest.dao.EmployeeDao;
import com.splus.learn.rest.enums.Status;

/**
 * This is service class for Employee
 * 
 * @author Rishabh Goel
 *
 */
public class EmployeeService {
	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when finding by employeeNumber
	 * 
	 * @param office
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse employeeById(Employee employee) throws SQLException {
		EmployeeDao employeeDao = new EmployeeDao();
		Connection con = employeeDao.connect();
		employee = employeeDao.employeeById(employee, con);
		ApiResponse response = new ApiResponse();
		if (employee.getEmployeeNumber() > 0) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		employeeDao.commitAndCloseConnection();
		response.setResult(employee);
		return response;
	}

	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when finding all employees
	 * 
	 * @param office
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse employeeShow(Employee employee) throws SQLException {
		EmployeeDao employeeDao = new EmployeeDao();
		Connection con = employeeDao.connect();
		List<Employee> employees = employeeDao.employeeShow(employee, con);

		ApiResponse response = new ApiResponse();
		if (employees != null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		employeeDao.closeConnection();
		response.setResult(employees);
		return response;
	}
}
