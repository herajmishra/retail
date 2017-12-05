package com.splus.learn.rest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.Product;
import com.splus.learn.rest.dao.ProductDao;
import com.splus.learn.rest.enums.Status;

/**
 * This is the class for Product Service
 * 
 * @author Nazish.Khatoon
 *
 */
public class ProductService {
	/**
	 * This method returns the status and description based on the passed Product
	 * Code
	 * 
	 * @param product
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse productByCode(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		Connection con = productDao.connect();
		product = productDao.productByCode(product, con);
		ApiResponse response = new ApiResponse();
		if (product.getProductCode() != null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		productDao.commitAndCloseConnection();
		response.setResult(product);
		return response;
	}

	/**
	 * This method returns the status and description for all the fields of the
	 * table in the database.
	 * 
	 * @param product
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse productShow(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		Connection con = productDao.connect();
		List<Product> products = productDao.productShow(product, con);
		ApiResponse response = new ApiResponse();
		if (products != null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		productDao.closeConnection();
		response.setResult(products);
		return response;
	}
}
