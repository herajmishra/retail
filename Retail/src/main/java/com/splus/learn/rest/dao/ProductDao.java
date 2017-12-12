package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.splus.learn.rest.beans.Product;

/**
 * This class is for Product Dao
 * 
 * @author Nazish.Khatoon
 *
 */

public class ProductDao extends AbstractDao {
	/**
	 * This method is for selecting all the details from the database where passed
	 * productCode matches with the product_code in the table
	 * 
	 * @param product
	 * @param con
	 * @return product
	 * @throws SQLException
	 */

	public Product productByCode(Product product, Connection con) throws SQLException {

		Statement stmt = con.createStatement();
		String productCode = product.getProductCode();
		String query = "select product_code,product_name,product_line,product_scale,product_vendor,product_description,quantity_instock,buy_price,msrp "
				+ "from products where product_code='" + productCode + "'AND record_status>0";

		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			product.setProductCode(rs.getString("product_code"));
			product.setProductName(rs.getString("product_name"));
			product.setProductLine(rs.getString("product_line"));
			product.setProductScale(rs.getString("product_scale"));
			product.setProductVendor(rs.getString("product_vendor"));
			product.setProductDescription(rs.getString("product_description"));
			product.setQuantityInStock(rs.getInt("quantity_instock"));
			product.setBuyPrice(rs.getDouble("buy_price"));
			product.setMsrp(rs.getDouble("msrp"));
		}

		return product;
	}

	/**
	 * This method shows all the fields for the Products from the database
	 * 
	 * @param product1
	 * @param con
	 * @return List<Product>
	 * @throws SQLException
	 */
	public List<Product> productShow(Product product1, Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		String query = "select product_code,product_name,product_line,product_scale,product_vendor,product_description,quantity_instock,buy_price,msrp "
				+ "from products where record_status>0";
		List<Product> products = new ArrayList<Product>();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			Product product = new Product();
			product.setProductCode(rs.getString("product_code"));
			product.setProductName(rs.getString("product_name"));
			product.setProductLine(rs.getString("product_line"));
			product.setProductScale(rs.getString("product_scale"));
			product.setProductVendor(rs.getString("product_vendor"));
			product.setProductDescription(rs.getString("product_description"));
			product.setQuantityInStock(rs.getInt("quantity_instock"));
			product.setBuyPrice(rs.getDouble("buy_price"));
			product.setMsrp(rs.getDouble("msrp"));
			products.add(product);
		}

		return products;
	}

	/**
	 * This method is for inserting a new record in the database
	 * 
	 * @param product
	 * @param con
	 * @return rs
	 * @throws SQLException
	 */
	public int save(Product product, Connection con) throws SQLException {

		PreparedStatement ps = con.prepareStatement(
				"insert into products(product_code,product_name,product_line,product_scale,product_vendor,product_description,quantity_instock,buy_price,msrp,created_by,created_at,record_status) values (?,?,?,?,?,?,?,?,?,?,NOW(),1)");

		ps.setString(1, product.getProductCode());
		ps.setString(2, product.getProductName());
		ps.setString(3, product.getProductLine());
		ps.setString(4, product.getProductScale());
		ps.setString(5, product.getProductVendor());
		ps.setString(6, product.getProductDescription());
		ps.setInt(7, product.getQuantityInStock());
		ps.setDouble(8, product.getBuyPrice());
		ps.setDouble(9, product.getMsrp());
		ps.setString(10, product.getProductCode());
		int rs = ps.executeUpdate();
		return rs;
	}

	/**
	 * This method is for updating the record_status value in the database where
	 * passed productCode matches with the product_code and record_status is greater
	 * than 0.
	 * 
	 * @param product
	 * @param con
	 * @return rs
	 * @throws SQLException
	 */
	public int delete(Product product, Connection con) throws SQLException {

		PreparedStatement ps = con.prepareStatement(
				"update products set lastmodified_by = ?,lastmodified_at=NOW(),record_status=0 where product_code = ? AND record_status>0");
		ps.setString(1, product.getProductName());
		ps.setString(2, product.getProductCode());
		int rs = ps.executeUpdate();
		return rs;
	}

	/**
	 * This method updates the record where passed productCode matches with the
	 * product_code in the table and record_status is greater than 0.
	 * 
	 * @param product
	 * @param con
	 * @return rs
	 * @throws SQLException
	 */
	public int update(Product product, Connection con) throws SQLException {

		PreparedStatement ps = con.prepareStatement(
				"update products set product_name = ?,product_line = ?,product_scale = ?,product_vendor = ?,product_description = ?,quantity_instock = ?,buy_price = ?,msrp = ?,lastmodified_by=?,lastmodified_at=NOW() where product_code=? AND record_status>0");

		ps.setString(1, product.getProductName());
		ps.setString(2, product.getProductLine());
		ps.setString(3, product.getProductScale());
		ps.setString(4, product.getProductVendor());
		ps.setString(5, product.getProductDescription());
		ps.setInt(6, product.getQuantityInStock());
		ps.setDouble(7, product.getBuyPrice());
		ps.setDouble(8, product.getMsrp());
		ps.setString(9, product.getProductCode());
		ps.setString(10, product.getProductCode());
		int rs = ps.executeUpdate();

		return rs;

	}

	/**
	 * This method adds the content from the arraylist to the product database
	 * 
	 * @param products
	 * @param con
	 * @return int
	 * @throws SQLException
	 */
	public int load(List<Product> products, Connection con) throws SQLException {
		String sql = "insert into products(product_code,product_name,product_line,product_scale,product_vendor,product_description,quantity_instock,buy_price,msrp,created_by,created_at,record_status) "
				+ "values (?,?,?,?,?,?,?,?,?,?,NOW(),1)";
		PreparedStatement ps = con.prepareStatement(sql);
		int count = 0, n = 0;
		for (Product product : products) {
			ps.setString(1, product.getProductCode());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductLine());
			ps.setString(4, product.getProductScale());
			ps.setString(5, product.getProductVendor());
			ps.setString(6, product.getProductDescription());
			ps.setInt(7, product.getQuantityInStock());
			ps.setDouble(8, product.getBuyPrice());
			ps.setDouble(9, product.getMsrp());
			ps.setString(10, product.getProductCode());
			ps.addBatch();
			++count;
		}

		int[] rs = ps.executeBatch();
		for (int i = 0; i < rs.length; i++) {
			n = n + rs[i];
		}
		if (count == n)
			return n;
		else
			return 0;
	}

}
