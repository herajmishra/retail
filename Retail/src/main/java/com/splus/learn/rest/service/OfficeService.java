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

	public ApiResponse officeShow(Office office) throws SQLException {
		OfficeDao officeDao = new OfficeDao();
		Connection con = officeDao.connect();
		List<Office> offices = officeDao.officeShow(office,con);
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
}
