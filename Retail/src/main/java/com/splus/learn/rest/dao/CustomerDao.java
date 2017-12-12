package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				+ "from customers where customer_number= '" + customerNumber + "'AND record_status>0";
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
		String query = "select customer_number,customer_name,contact_lastname,contact_firstname,phone,address_line1,address_line2,city,state,postal_code,country,sales_repemployeenumber,credit_limit from customers where record_status>0";
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

	/**
	 * This method inserts the data of customer into database
	 * 
	 * @param customer
	 * @param con
	 * @return rs
	 * @throws SQLException
	 */
	public int saveCustomer(Customer customer, Connection con) throws SQLException {
		String query = "insert into customers(customer_number,customer_name,contact_lastname,contact_firstname,phone,address_line1,address_line2,city,state,postal_code,country,sales_repemployeenumber,credit_limit,created_by,created_at,record_status)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),1)";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, customer.getCustomerNumber());
		stmt.setString(2, customer.getCustomerName());
		stmt.setString(3, customer.getContactLastName());
		stmt.setString(4, customer.getContactFirstName());
		stmt.setString(5, customer.getPhone());
		stmt.setString(6, customer.getAddressLine1());
		stmt.setString(7, customer.getAddressLine2());
		stmt.setString(8, customer.getCity());
		stmt.setString(9, customer.getState());
		stmt.setString(10, customer.getPostalCode());
		stmt.setString(11, customer.getCountry());
		stmt.setInt(12, customer.getSalesRepEmployeeNumber());
		stmt.setDouble(13, customer.getCreditLimit());
		stmt.setString(14, customer.getCustomerName());
		int rs = stmt.executeUpdate();
		return rs;
	}

	/**
	 * This method updates the data in the database for customer
	 * 
	 * @param customer
	 * @param con
	 * @return rs
	 * @throws SQLException
	 */
	public int updateCustomer(Customer customer, Connection con) throws SQLException {
		String query = "update customers set customer_name= ? ,contact_lastname= ?,contact_firstname= ?,phone= ?,address_line1= ?,address_line2= ?,city= ?,state= ?,postal_code= ?,country= ?,sales_repemployeenumber= ?,credit_limit= ?,lastmodified_by= ?,lastmodified_at=NOW() where customer_number= ? AND record_status>0";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, customer.getCustomerName());
		stmt.setString(2, customer.getContactLastName());
		stmt.setString(3, customer.getContactFirstName());
		stmt.setString(4, customer.getPhone());
		stmt.setString(5, customer.getAddressLine1());
		stmt.setString(6, customer.getAddressLine2());
		stmt.setString(7, customer.getCity());
		stmt.setString(8, customer.getState());
		stmt.setString(9, customer.getPostalCode());
		stmt.setString(10, customer.getCountry());
		stmt.setInt(11, customer.getSalesRepEmployeeNumber());
		stmt.setDouble(12, customer.getCreditLimit());
		stmt.setString(13, customer.getCustomerName());
		stmt.setInt(14, customer.getCustomerNumber());
		int rs = stmt.executeUpdate();
		return rs;
	}

	/**
	 * This method logically deletes the data of a customer by setting its record
	 * status as 0
	 * 
	 * @param customer
	 * @param con
	 * @return rs
	 * @throws SQLException
	 */
	public int deleteCustomer(Customer customer, Connection con) throws SQLException {
		String query = "update customers set lastmodified_by= ?,lastmodified_at=NOW(),record_status=0 where customer_number= ? AND record_status>0";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, customer.getCustomerName());
		stmt.setInt(2, customer.getCustomerNumber());
		int rs = stmt.executeUpdate();
		return rs;

	}

}