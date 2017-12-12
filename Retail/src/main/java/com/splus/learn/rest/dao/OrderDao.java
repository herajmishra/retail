package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.splus.learn.rest.beans.Order;
import com.splus.learn.rest.beans.OrderDetails;

/**
 * This is Dao class for Order
 * 
 * @author Rishabh.Goel
 *
 */
public class OrderDao extends AbstractDao {
	/**
	 * This method selects all the data in the table order
	 * 
	 * @param order1
	 * @param con
	 * @return List<Order>
	 * @throws SQLException
	 */
	public List<Order> orderShow(Order order1, Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		String query = "select orders.order_number,orders.order_date,orders.required_date,orders.shipped_date,orders.order_status,orders.comments,orders.customer_number"
				+ ",orderdetails.order_number,orderdetails.product_code,orderdetails.quantity_ordered,orderdetails.price_each,orderdetails.order_linenumber "
				+ "from orders inner join orderdetails on orders.order_number=orderdetails.order_number AND orders.record_status>0 AND orderdetails.record_status>0";
		List<Order> orders = new ArrayList<Order>();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Order order = new Order();
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setOrderNumber(rs.getInt("order_number"));
			orderDetails.setProductCode(rs.getString("product_code"));
			orderDetails.setQuantityOrdered(rs.getInt("quantity_ordered"));
			orderDetails.setPriceEach(rs.getDouble("price_each"));
			orderDetails.setOrderLineNumber(rs.getInt("order_linenumber"));
			order.setOrderDetails(orderDetails);
			order.setOrderNumber(rs.getInt("order_number"));
			order.setOrderDate(rs.getString("order_date"));
			order.setRequiredDate(rs.getString("required_date"));
			order.setShippedDate(rs.getString("shipped_date"));
			order.setOrderStatus(rs.getString("order_status"));
			order.setComments(rs.getString("comments"));
			order.setCustomerNumber(rs.getInt("customer_number"));
			orders.add(order);
		}
		return orders;
	}

	/**
	 * This method is for selecting all the details from the database where passed
	 * orderNumber matches with the order_number in the table
	 * 
	 * @param order
	 * @param con
	 * @return Order
	 * @throws SQLException
	 */
	public Order orderById(Order order, Connection con) throws SQLException {
		int orderNumber = order.getOrderNumber();
		String query = "select orders.order_number,orders.order_date,orders.required_date,orders.shipped_date,orders.order_status,orders.comments,orders.customer_number"
				+ ",orderdetails.order_number,orderdetails.product_code,orderdetails.quantity_ordered,orderdetails.price_each,orderdetails.order_linenumber "
				+ "from orders orders,orderdetails where orders.order_number=orderdetails.order_number AND orders.order_number='"
				+ orderNumber + "'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setOrderNumber(rs.getInt("order_number"));
			orderDetails.setProductCode(rs.getString("product_code"));
			orderDetails.setQuantityOrdered(rs.getInt("quantity_ordered"));
			orderDetails.setPriceEach(rs.getDouble("price_each"));
			orderDetails.setOrderLineNumber(rs.getInt("order_linenumber"));
			order.setOrderDetails(orderDetails);
			order.setOrderNumber(rs.getInt("order_number"));
			order.setOrderDate(rs.getString("order_date"));
			order.setRequiredDate(rs.getString("required_date"));
			order.setShippedDate(rs.getString("shipped_date"));
			order.setOrderStatus(rs.getString("order_status"));
			order.setComments(rs.getString("comments"));
			order.setCustomerNumber(rs.getInt("customer_number"));
		}
		return order;
	}

	/**
	 * This method inserts the data of order into database
	 * 
	 * @param order
	 * @param con
	 * @return rs
	 * @throws SQLException
	 */
	public int saveOrder(Order order, Connection con) throws SQLException {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails = order.getOrderDetails();
		String query1 = "insert into orders(order_number,order_date,required_date,shipped_date,order_status,comments,customer_number,created_by,created_at,record_status) "
				+ "values(?,?,?,?,?,?,?,?,NOW(),1)";
		PreparedStatement ps1 = con.prepareStatement(query1);
		ps1.setInt(1, order.getOrderNumber());
		ps1.setString(2, order.getOrderDate());
		ps1.setString(3, order.getRequiredDate());
		ps1.setString(4, order.getShippedDate());
		ps1.setString(5, order.getOrderStatus());
		ps1.setString(6, order.getComments());
		ps1.setInt(7, order.getCustomerNumber());
		ps1.setInt(8, order.getOrderNumber());
		int rs = ps1.executeUpdate();
		String query = "insert into orderdetails(order_number,product_code,quantity_ordered,price_each,order_linenumber,created_by,created_at,record_status) "
				+ "values(?,?,?,?,?,?,NOW(),1)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, orderDetails.getOrderNumber());
		ps.setString(2, orderDetails.getProductCode());
		ps.setInt(3, orderDetails.getQuantityOrdered());
		ps.setDouble(4, orderDetails.getPriceEach());
		ps.setInt(5, orderDetails.getOrderLineNumber());
		ps.setInt(6, orderDetails.getOrderNumber());
		ps.executeUpdate();
		return rs;
	}

	/**
	 * This method updates the data in the database for order
	 * 
	 * @param order
	 * @param con
	 * @return rs
	 * @throws SQLException
	 */
	public int updateOrder(Order order, Connection con) throws SQLException {
		String query = "update orders set order_date=?,required_date=?,shipped_date=?,order_status=?,comments=?,lastmodified_by=?,lastmodified_at=NOW() where order_number=? AND record_status>0";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, order.getOrderDate());
		ps.setString(2, order.getRequiredDate());
		ps.setString(3, order.getShippedDate());
		ps.setString(4, order.getOrderStatus());
		ps.setString(5, order.getComments());
		ps.setInt(6, order.getCustomerNumber());
		ps.setInt(7, order.getOrderNumber());
		ps.executeUpdate();
		OrderDetails orderDetails = order.getOrderDetails();
		String query1 = "update orderdetails set quantity_ordered=?,price_each=?,order_linenumber=?,lastmodified_by=?,lastmodified_at=NOW() where order_number=? AND record_status>0";
		PreparedStatement ps1 = con.prepareStatement(query1);
		ps1.setInt(1, orderDetails.getQuantityOrdered());
		ps1.setDouble(2, orderDetails.getPriceEach());
		ps1.setInt(3, orderDetails.getOrderLineNumber());
		ps1.setInt(4, orderDetails.getOrderNumber());
		ps1.setInt(5, orderDetails.getOrderNumber());
		int rs = ps1.executeUpdate();
		return rs;
	}

	/**
	 * This method logically deletes the data of a order by setting its record
	 * status as 0
	 * 
	 * @param order
	 * @param con
	 * @return rs
	 * @throws SQLException
	 */
	public int deleteOrder(Order order, Connection con) throws SQLException {
		String query = "update orders set lastmodified_by=?,lastmodified_at=NOW(),record_status=0 where order_number=? AND record_status>0";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, order.getCustomerNumber());
		ps.setInt(2, order.getOrderNumber());
		ps.executeUpdate();
		OrderDetails orderDetails = order.getOrderDetails();
		String query1 = "update orderdetails set lastmodified_by=?,lastmodified_at=NOW(),record_status=0 where order_number=? AND record_status>0";
		PreparedStatement ps1 = con.prepareStatement(query1);
		ps1.setInt(1, orderDetails.getOrderNumber());
		ps1.setInt(2, orderDetails.getOrderNumber());
		int rs = ps1.executeUpdate();
		return rs;
	}

}
