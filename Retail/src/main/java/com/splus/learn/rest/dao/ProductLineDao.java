package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.splus.learn.rest.beans.ProductLine;

public class ProductLineDao extends AbstractDao {

	public ProductLine productLineById(ProductLine productLine,Connection con) throws SQLException {
		
		Statement stmt = con.createStatement();
		String productlineid = productLine.getProductLine();
		String query = "select product_line,text_description,html_description,image from productlines  where product_line= '"
				+ productlineid + "'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			productLine.setProductLine(rs.getString("product_line"));
			productLine.setTextDescription(rs.getString("text_description"));
			productLine.setHtmlDescription(rs.getString("html_description"));
			productLine.setImage(rs.getBytes("image"));
		}
		
		return productLine;

	}

	public ProductLine productLineShow(ProductLine productLine) throws SQLException {
		Connection con = connect();
		Statement stmt = con.createStatement();
		String query = "select product_line,text_description,html_description,image from productlines";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			productLine.setProductLine(rs.getString("product_line"));
			productLine.setTextDescription(rs.getString("text_description"));
			productLine.setHtmlDescription(rs.getString("html_description"));
			productLine.setImage(rs.getBytes("image"));
		}
		
		return productLine;

	}
}
