package com.splus.learn.rest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.splus.learn.rest.beans.ApiResponse;

import com.splus.learn.rest.beans.ProductLine;

import com.splus.learn.rest.dao.ProductLineDao;
import com.splus.learn.rest.enums.Status;
/**
 * This is the class for ProductLineService Service
 * @author Nazish.Khatoon
 *
 */
public class ProductLineService {
	/**
	 * This method returns the status and description based on the passed Product Line
	 * @param productLine
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse productLineById(ProductLine productLine) throws SQLException {
		ProductLineDao productLineDao = new ProductLineDao();
		Connection con = productLineDao.connect();
		productLine = productLineDao.productLineById(productLine, con);
		ApiResponse response = new ApiResponse();
		if (productLine.getProductLine() != null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		productLineDao.commitAndCloseConnection();
		response.setResult(productLine);
		return response;
	}

	/**
	 * This method returns the status and description for all the fields of the
	 * table in the database.
	 * 
	 * @param productLine
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse productLineShow(ProductLine productLine) throws SQLException {
		ProductLineDao productLineDao = new ProductLineDao();

		Connection con = productLineDao.connect();
		List<ProductLine> productLines = productLineDao.productLineShow(productLine, con);
		ApiResponse response = new ApiResponse();
		if (productLines != null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		productLineDao.closeConnection();
		response.setResult(productLines);
		return response;
	}
	/**
	 * This method returns the status and description whether the product is
	 * successfully inserted or not.
	 * @param productLine
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse save(ProductLine productLine) throws SQLException {
		ProductLineDao productLineDao = new ProductLineDao();
		Connection con = productLineDao.connect();
		productLine = productLineDao.productLineInsert(productLine, con);
		ApiResponse response = new ApiResponse();
		if (productLine.getProductLine() != null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		productLineDao.commitAndCloseConnection();
		response.setResult(productLine);
		return response;
	}
	/**
	 *  This method returns the Api response for the product where passed productLine
	 * matches with the product_line and record_status is greater than 0.
	 * @param productLine
	 * @return response
	 * @throws SQLException
	 */
	
	public ApiResponse delete(ProductLine productLine) throws SQLException {
		ProductLineDao productLineDao = new ProductLineDao();
		Connection con = productLineDao.connect();
		int i= productLineDao.delete(productLine, con);
		ApiResponse response = new ApiResponse();
		if (i==1) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		productLineDao.commitAndCloseConnection();
		response.setResult(productLine);
		return response;
	}
	/**
	 * his method returns the Api response for the updated ProductLine where passed
	 * productLine matches with the product_line in the table and record_status is
	 * greater than 0.
	 * @param productLine
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse update(ProductLine productLine) throws SQLException {
		ProductLineDao productLineDao = new ProductLineDao();
		Connection con = productLineDao.connect();
		int i= productLineDao.update(productLine, con);
		ApiResponse response = new ApiResponse();
		if (i==1) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		productLineDao.commitAndCloseConnection();
		response.setResult(productLine);
		return response;
	}
}
