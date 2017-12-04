package com.splus.learn.rest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.Product;
import com.splus.learn.rest.dao.ProductDao;
import com.splus.learn.rest.enums.Status;

public class ProductService {
	public ApiResponse productByCode(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		Connection con = productDao.connect();
		product = productDao.productByCode(product,con);
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

	public ApiResponse productShow(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		Connection con = productDao.connect();
		List<Product> products =  productDao.productShow(product, con);
		ApiResponse response = new ApiResponse();
		if(products!=null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		}else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		productDao.closeConnection();
		response.setResult(products);
		return response;
	}
}
