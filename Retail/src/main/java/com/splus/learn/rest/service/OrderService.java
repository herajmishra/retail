package com.splus.learn.rest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.Order;
import com.splus.learn.rest.dao.OrderDao;
import com.splus.learn.rest.enums.Status;

/**
 * This is service class for Order
 * 
 * @author Rishabh.Goel
 *
 */
public class OrderService {
	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when finding by orderNumber
	 * 
	 * @param order
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse orderShow(Order order) throws SQLException {
		OrderDao orderDao = new OrderDao();
		Connection con = orderDao.connect();
		List<Order> orders = orderDao.orderShow(order, con);
		ApiResponse response = new ApiResponse();
		if (orders != null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		orderDao.closeConnection();
		response.setResult(orders);
		return response;
	}

	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when finding all order
	 * 
	 * @param order
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse orderById(Order order) throws SQLException {
		OrderDao orderDao = new OrderDao();
		Connection con = orderDao.connect();
		order = orderDao.orderById(order, con);
		ApiResponse response = new ApiResponse();
		if (order.getOrderNumber() > 0) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		orderDao.commitAndCloseConnection();
		response.setResult(order);
		return response;
	}

	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when inserting a order
	 * 
	 * @param order
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse saveOrder(Order order) throws SQLException {
		OrderDao orderDao = new OrderDao();
		Connection con = orderDao.connect();
		int rs = orderDao.saveOrder(order, con);
		ApiResponse response = new ApiResponse();
		if (rs == 1) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		orderDao.commitAndCloseConnection();
		response.setResult(order);
		return response;
	}

	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when updating a order
	 * 
	 * @param order
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse updateOrder(Order order) throws SQLException {
		OrderDao orderDao = new OrderDao();
		Connection con = orderDao.connect();
		int rs = orderDao.updateOrder(order, con);
		ApiResponse response = new ApiResponse();
		if (rs == 1) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		orderDao.commitAndCloseConnection();
		response.setResult(order);
		return response;
	}

	/**
	 * This method sets the ApiResponse according to success of failure of the query
	 * when deleting a order
	 * 
	 * @param order
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse deleteOrder(Order order) throws SQLException {
		OrderDao orderDao = new OrderDao();
		Connection con = orderDao.connect();
		int rs = orderDao.deleteOrder(order, con);
		ApiResponse response = new ApiResponse();
		if (rs == 1) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		orderDao.commitAndCloseConnection();
		response.setResult(order);
		return response;
	}

}
