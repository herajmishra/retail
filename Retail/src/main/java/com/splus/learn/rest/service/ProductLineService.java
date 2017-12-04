package com.splus.learn.rest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.ProductLine;
import com.splus.learn.rest.dao.ProductLineDao;
import com.splus.learn.rest.enums.Status;

public class ProductLineService {
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
}
