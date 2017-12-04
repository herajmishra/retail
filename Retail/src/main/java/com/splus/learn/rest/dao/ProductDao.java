package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.splus.learn.rest.beans.Product;

public class ProductDao extends AbstractDao {

	public Product productByCode(Product product,Connection con) throws SQLException {
		
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

	public Product productShow(Product product) throws SQLException {
		Connection con = connect();
		Statement stmt = con.createStatement();
		String query = "select product_code,product_name,product_line,product_scale,product_vendor,product_description,quantity_instock,buy_price,msrp "
				+ "from products";
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
}
