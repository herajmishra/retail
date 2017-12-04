package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.splus.learn.rest.beans.ProductLine;

public class ProductLineDao extends AbstractDao {

	public ProductLine productLineById(ProductLine productLine, Connection con) throws SQLException {

		Statement stmt = con.createStatement();
		String productlineid = productLine.getProductLine();
		String query = "select product_line,text_description,html_description,image from productlines where product_line= '"
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

	public List<ProductLine> productLineShow(ProductLine productLine1, Connection con) throws SQLException {

		Statement stmt = con.createStatement();
		String query = "select product_line,text_description,html_description,image from productlines";
		List<ProductLine> productLines = new ArrayList<ProductLine>();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			ProductLine productLine = new ProductLine();
			productLine.setProductLine(rs.getString("product_line"));
			productLine.setTextDescription(rs.getString("text_description"));
			productLine.setHtmlDescription(rs.getString("html_description"));
			productLine.setImage(rs.getBytes("image"));
			productLines.add(productLine);
		}

		return productLines;

	}
}
