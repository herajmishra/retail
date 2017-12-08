package com.splus.learn.rest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.Payment;
import com.splus.learn.rest.dao.PaymentDao;
import com.splus.learn.rest.enums.Status;

/**
 * This is the class for Payment Service
 * 
 * @author Nazish.Khatoon
 *
 */
public class PaymentService {
	/**
	 * This method returns the status and description based on the passed PaymentId.
	 * 
	 * @param payment
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse paymentId(Payment payment) throws SQLException {
		PaymentDao paymentDao = new PaymentDao();
		Connection con = paymentDao.connect();
		payment = paymentDao.paymentById(payment, con);
		ApiResponse response = new ApiResponse();
		if (payment.getPaymentId() > 0) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		paymentDao.commitAndCloseConnection();
		response.setResult(payment);
		return response;
	}

	/**
	 * This method returns the status and description based on the passed
	 * PaymentRefNo.
	 * 
	 * @param payment
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse paymentRefNo(Payment payment) throws SQLException {
		PaymentDao paymentDao = new PaymentDao();
		Connection con = paymentDao.connect();
		payment = paymentDao.paymentByRefNo(payment, con);
		ApiResponse response = new ApiResponse();
		if (payment.getPaymentRefNo() != null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		paymentDao.commitAndCloseConnection();
		response.setResult(payment);
		return response;
	}

	/**
	 * This method returns the status and description based on the passed
	 * customerNumber.
	 * 
	 * @param payment
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse paymentCustomerNumber(Payment payment) throws SQLException {
		PaymentDao paymentDao = new PaymentDao();
		Connection con = paymentDao.connect();
		List<Payment> payments = paymentDao.paymentByCustomerNumber(payment, con);
		ApiResponse response = new ApiResponse();
		if (payments != null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		paymentDao.commitAndCloseConnection();
		response.setResult(payments);
		return response;
	}
}
