package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.splus.learn.rest.beans.Payment;

/**
 * This class is for payment Dao
 * 
 * @author Nazish.Khatoon
 *
 */

public class PaymentDao extends AbstractDao {
	/**
	 * This method is for selecting all the details from the database where passed
	 * paymentId matches with the payment_id in the table
	 * 
	 * @param payment
	 * @param con
	 * @return payment
	 * @throws SQLException
	 */
	public Payment paymentById(Payment payment, Connection con) throws SQLException {

		Statement stmt = con.createStatement();
		int paymentId = payment.getPaymentId();
		String query = "select payment_id,payment_refno,bank,ifsc_code,customer_number,check_number,payment_date,amount "
				+ "from payments where payment_id='" + paymentId + "'AND record_status>0";

		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			payment.setPaymentId(rs.getInt("payment_id"));
			payment.setPaymentRefNo(rs.getString("payment_refno"));
			payment.setBank(rs.getString("bank"));
			payment.setIfscCode(rs.getString("ifsc_code"));
			payment.setCustomerNumber(rs.getInt("customer_number"));
			payment.setCheckNumber(rs.getString("check_number"));
			payment.setPaymentDate(rs.getInt("payment_date"));
			payment.setAmount(rs.getDouble("amount"));
		}

		return payment;
	}

	/**
	 * This method is for selecting all the details from the database where passed
	 * paymentRefNo matches with the payment_refno in the table
	 * 
	 * @param payment
	 * @param con
	 * @return payment
	 * @throws SQLException
	 */
	public Payment paymentByRefNo(Payment payment, Connection con) throws SQLException {

		Statement stmt = con.createStatement();
		String paymentRefNo = payment.getPaymentRefNo();
		String query = "select payment_id,payment_refno,bank,ifsc_code,customer_number,check_number,payment_date,amount "
				+ "from payments where payment_refno='" + paymentRefNo + "'AND record_status>0";

		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			payment.setPaymentId(rs.getInt("payment_id"));
			payment.setPaymentRefNo(rs.getString("payment_refno"));
			payment.setBank(rs.getString("bank"));
			payment.setIfscCode(rs.getString("ifsc_code"));
			payment.setCustomerNumber(rs.getInt("customer_number"));
			payment.setCheckNumber(rs.getString("check_number"));
			payment.setPaymentDate(rs.getInt("payment_date"));
			payment.setAmount(rs.getDouble("amount"));
		}

		return payment;
	}

	/**
	 * This method is for selecting all the details from the database where passed
	 * customerNumber matches with the customer_number in the table
	 * 
	 * @param payment1
	 * @param con
	 * @return List<Payment>
	 * @throws SQLException
	 */
	public List<Payment> paymentByCustomerNumber(Payment payment1, Connection con) throws SQLException {

		Statement stmt = con.createStatement();
		int paymentCustomerNumber = payment1.getCustomerNumber();
		String query = "select payment_id,payment_refno,bank,ifsc_code,customer_number,check_number,payment_date,amount "
				+ "from payments where customer_number='" + paymentCustomerNumber + "'AND record_status>0";
		List<Payment> payments = new ArrayList<Payment>();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Payment payment = new Payment();
			payment.setPaymentId(rs.getInt("payment_id"));
			payment.setPaymentRefNo(rs.getString("payment_refno"));
			payment.setBank(rs.getString("bank"));
			payment.setIfscCode(rs.getString("ifsc_code"));
			payment.setCustomerNumber(rs.getInt("customer_number"));
			payment.setCheckNumber(rs.getString("check_number"));
			payment.setPaymentDate(rs.getInt("payment_date"));
			payment.setAmount(rs.getDouble("amount"));
			payments.add(payment);
		}

		return payments;
	}

}
