package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.splus.learn.rest.beans.Customer;

/**
 * This is Dao class for Customer
 * 
 * @author Rishabh Goel
 *
 */
public class CustomerDao extends AbstractDao {
	/**
	 * This method is for selecting all the details from the database where passed
	 * customerNumber matches with the customer_number in the table
	 * 
	 * @param customer
	 * @param con
	 * @return Customer
	 * @throws SQLException
	 */
	public Customer customerById(Customer customer, Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		int customerNumber = customer.getCustomerNumber();
		String query = "select customer_number,customer_name,contact_lastname,contact_firstname,phone,address_line1,address_line2,city,state,postal_code,country,sales_repemployeenumber,credit_limit "
				+ "from customers where customer_number= '" + customerNumber + "'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			customer.setCustomerNumber(rs.getInt("customer_number"));
			customer.setCustomerName(rs.getString("customer_name"));
			customer.setContactLastName(rs.getString("contact_lastname"));
			customer.setContactFirstName(rs.getString("contact_firstname"));
			customer.setPhone(rs.getString("phone"));
			customer.setAddressLine1(rs.getString("address_line1"));
			customer.setAddressLine2(rs.getString("address_line2"));
			customer.setCity(rs.getString("city"));
			customer.setState(rs.getString("state"));
			customer.setPostalCode(rs.getString("postal_code"));
			customer.setCountry(rs.getString("country"));
			customer.setSalesRepEmployeeNumber(rs.getInt("sales_repemployeenumber"));
			customer.setCreditLimit(rs.getDouble("credit_limit"));
		}

		return customer;
	}

	/**
	 * This method selects all the data in the table customers
	 * 
	 * @param customer1
	 * @param con
	 * @return List<Customer>
	 * @throws SQLException
	 */
	public List<Customer> customerShow(Customer customer1, Connection con) throws SQLException {

		Statement stmt = con.createStatement();
		String query = "select customer_number,customer_name,contact_lastname,contact_firstname,phone,address_line1,address_line2,city,state,postal_code,country,sales_repemployeenumber,credit_limit from customers";
		List<Customer> customers = new ArrayList<Customer>();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Customer customer = new Customer();
			customer.setCustomerNumber(rs.getInt("customer_number"));
			customer.setCustomerName(rs.getString("customer_name"));
			customer.setContactLastName(rs.getString("contact_lastname"));
			customer.setContactFirstName(rs.getString("contact_firstname"));
			customer.setPhone(rs.getString("phone"));
			customer.setAddressLine1(rs.getString("address_line1"));
			customer.setAddressLine2(rs.getString("address_line2"));
			customer.setCity(rs.getString("city"));
			customer.setState(rs.getString("state"));
			customer.setPostalCode(rs.getString("postal_code"));
			customer.setCountry(rs.getString("country"));
			customer.setSalesRepEmployeeNumber(rs.getInt("sales_repemployeenumber"));
			customer.setCreditLimit(rs.getDouble("credit_limit"));
			customers.add(customer);
		}
		return customers;
	}
}