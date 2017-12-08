package com.splus.learn.rest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.Office;
import com.splus.learn.rest.dao.OfficeDao;
import com.splus.learn.rest.enums.Status;
/**
 * This is the class for Office Service
 * @author Nazish.Khatoon
 *
 */
public class OfficeService {
	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when finding by officeCode
	 * 
	 * @param office
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse officeByCode(Office office) throws SQLException {
		OfficeDao officeDao = new OfficeDao();
		Connection con = officeDao.connect();

		office = officeDao.officeByCode(office, con);
		ApiResponse response = new ApiResponse();
		if (office.getOfficeCode() != null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		officeDao.commitAndCloseConnection();
		response.setResult(office);
		return response;
	}

	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when finding all offices
	 * 
	 * @param office
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse officeShow(Office office) throws SQLException {
		OfficeDao officeDao = new OfficeDao();
		Connection con = officeDao.connect();
		List<Office> offices = officeDao.officeShow(office, con);
		ApiResponse response = new ApiResponse();
		if (offices != null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		officeDao.closeConnection();
		response.setResult(offices);
		return response;
	}

	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when inserting a office
	 * 
	 * @param office
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse saveOffice(Office office) throws SQLException {
		OfficeDao officeDao = new OfficeDao();
		Connection con = officeDao.connect();
		int rs = officeDao.saveOffice(office, con);
		ApiResponse response = new ApiResponse();
		if (rs == 1) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		officeDao.commitAndCloseConnection();
		response.setResult(office);
		return response;
	}

	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when updating a office
	 * 
	 * @param office
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse updateOffice(Office office) throws SQLException {
		OfficeDao officeDao = new OfficeDao();
		Connection con = officeDao.connect();
		int rs = officeDao.updateOffice(office, con);
		ApiResponse response = new ApiResponse();
		if (rs == 1) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		officeDao.commitAndCloseConnection();
		response.setResult(office);
		return response;
	}

	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when deleting a office
	 * 
	 * @param office
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse deleteOffice(Office office) throws SQLException {
		OfficeDao officeDao = new OfficeDao();
		Connection con = officeDao.connect();
		int rs = officeDao.deleteOffice(office, con);
		ApiResponse response = new ApiResponse();
		if (rs == 1) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		officeDao.commitAndCloseConnection();
		response.setResult(office);
		return response;
	}
}
