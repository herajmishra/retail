package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.splus.learn.rest.beans.Office;

public class OfficeDao extends AbstractDao {
	
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
