package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.splus.learn.rest.beans.ProductLine;

/**
 * This class is for ProductLine Dao
 * 
 * @author Nazish.Khatoon
 *
 */

public class ProductLineDao extends AbstractDao {
	/**
	 * This method is for selecting all the details from the database where passed
	 * productLine matches with the product_line in the table.
	 * 
	 * @param productLine
	 * @param con
	 * @return productLine
	 * @throws SQLException
	 */

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

	/**
	 * This method shows all the fields for the ProductLine from the database.
	 * 
	 * @param productLine1
	 * @param con
	 * @return List<ProductLine>
	 * @throws SQLException
	 */

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

	/**
	 * This method is for inserting a new record in the database
	 * 
	 * @param productLine
	 * @param con
	 * @return productLine
	 * @throws SQLException
	 */
	public ProductLine productLineInsert(ProductLine productLine, Connection con) throws SQLException {

		PreparedStatement ps = con.prepareStatement(
				"insert into productlines(product_line,text_description,html_description,image,record_status) values (?,?,?,?,1)");

		ps.setString(1, productLine.getProductLine());
		ps.setString(2, productLine.getTextDescription());
		ps.setString(3, productLine.getHtmlDescription());
		ps.setBytes(4, productLine.getImage());

		ps.executeUpdate();

		return productLine;
	}

	/**
	 * This method is for updating the record_status value in the database where
	 * passed productLine matches with the product_line and record_status is greater
	 * than 0.
	 * 
	 * @param productLine
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public int delete(ProductLine productLine, Connection con) throws SQLException {

		PreparedStatement ps = con.prepareStatement(
				"update productlines set lastmodified_by = ?,lastmodified_at=NOW(),record_status=0 where product_line = ? AND record_status>0");

		ps.setString(1, productLine.getProductLine());
		ps.setString(2, productLine.getProductLine());
		int rs = ps.executeUpdate();
		return rs;
	}

	/**
	 * This method updates the record where passed productLine matches with the
	 * product_line in the table and record_status is greater than 0.
	 * 
	 * @param productLine
	 * @param con
	 * @return
	 * @throws SQLException
	 */

	public int update(ProductLine productLine, Connection con) throws SQLException {

		PreparedStatement ps = con.prepareStatement(
				"update productlines set text_description = ?,html_description = ?,image = ?,lastmodified_by=?,lastmodified_at=NOW() where product_line=? AND record_status>0 ");

		ps.setString(1, productLine.getTextDescription());
		ps.setString(2, productLine.getHtmlDescription());
		ps.setBytes(3, productLine.getImage());
		ps.setString(4, productLine.getProductLine());
		ps.setString(5, productLine.getProductLine());
		int rs = ps.executeUpdate();

		return rs;
	}
}