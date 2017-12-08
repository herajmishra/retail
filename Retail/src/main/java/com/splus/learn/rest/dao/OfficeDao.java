package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.splus.learn.rest.beans.Office;
/**
 * This is the class for Office Dao
 * @author Nazish.Khatoon
 *
 */
public class OfficeDao extends AbstractDao {
	/**
	 *  This method is for selecting all the details from the database where passed officeCode matches with the office_code in the table
	 * @param office
	 * @param con
	 * @return office
	 * @throws SQLException
	 */
	
	public Office officeByCode(Office office,Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		String officeCode = office.getOfficeCode();
		String query = "select office_code,city,phone,address_line1,address_line2,state,country,postal_code,territory "
				+ "from offices where office_code= '" + officeCode + "'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			office.setOfficeCode(rs.getString("office_code"));
			office.setCity(rs.getString("city"));
			office.setPhone(rs.getString("phone"));
			office.setAddressLine1(rs.getString("address_line1"));
			office.setAddressLine2(rs.getString("address_line2"));
			office.setState(rs.getString("state"));
			office.setCountry(rs.getString("country"));
			office.setPostalCode(rs.getString("postal_code"));
			office.setTerritory(rs.getString("territory"));
		}
		
		return office;
	}
/**
 * This method shows all the fields for the Offices from the database
 * @param office1
 * @param con
 * @return List<Office>
 * @throws SQLException
 */
	public List<Office> officeShow(Office office1,Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		String query = "select office_code,city,phone,address_line1,address_line2,state,country,postal_code,territory from offices";
		List<Office> offices=new ArrayList<Office>();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Office office=new Office();
			office.setOfficeCode(rs.getString("office_code"));
			office.setCity(rs.getString("city"));
			office.setPhone(rs.getString("phone"));
			office.setAddressLine1(rs.getString("address_line1"));
			office.setAddressLine2(rs.getString("address_line2"));
			office.setState(rs.getString("state"));
			office.setCountry(rs.getString("country"));
			office.setPostalCode(rs.getString("postal_code"));
			office.setTerritory(rs.getString("territory"));
			offices.add(office);
		}
		
		return offices;
	}
}
