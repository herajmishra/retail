package com.splus.learn.rest.dao;

import java.sql.Connection;
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
				+ "from products where product_code='" + productCode + "'";

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
				+ "from products";
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
}
