package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				+ "from offices where office_code= '" + officeCode + "'AND record_status>0";
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
		String query = "select office_code,city,phone,address_line1,address_line2,state,country,postal_code,territory from offices where record_status>0";
		List<Office> offices = new ArrayList<Office>();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Office office = new Office();
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

	/**
	 * This method inserts the data of office into database
	 * 
	 * @param office
	 * @param con
	 * @return rs
	 * @throws SQLException
	 */
	public int saveOffice(Office office, Connection con) throws SQLException {
		String query = "insert into offices(office_code,city,phone,address_line1,address_line2,state,country,postal_code,territory,created_by,created_at,record_status) "
				+ "values(?,?,?,?,?,?,?,?,?,?,NOW(),1)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, office.getOfficeCode());
		ps.setString(2, office.getCity());
		ps.setString(3, office.getPhone());
		ps.setString(4, office.getAddressLine1());
		ps.setString(5, office.getAddressLine2());
		ps.setString(6, office.getState());
		ps.setString(7, office.getCountry());
		ps.setString(8, office.getPostalCode());
		ps.setString(9, office.getTerritory());
		ps.setString(10, office.getOfficeCode());
		int rs = ps.executeUpdate();
		return rs;

	}

	/**
	 * This method updates the data in the database for office
	 * 
	 * @param office
	 * @param con
	 * @return rs
	 * @throws SQLException
	 */
	public int updateOffice(Office office, Connection con) throws SQLException {
		String query = "update offices set city=?,phone=?,address_line1=?,address_line2=?,state=?,country=?,postal_code=?,territory=?,lastmodified_by=?,lastmodified_at=NOW() where office_code=? AND record_status>0";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, office.getCity());
		ps.setString(2, office.getPhone());
		ps.setString(3, office.getAddressLine1());
		ps.setString(4, office.getAddressLine2());
		ps.setString(5, office.getState());
		ps.setString(6, office.getCountry());
		ps.setString(7, office.getPostalCode());
		ps.setString(8, office.getTerritory());
		ps.setString(9, office.getOfficeCode());
		ps.setString(10, office.getOfficeCode());
		int rs = ps.executeUpdate();
		return rs;
	}

	/**
	 * This method logically deletes the data of a office by setting its record
	 * status as 0
	 * 
	 * @param office
	 * @param con
	 * @return rs
	 * @throws SQLException
	 */
	public int deleteOffice(Office office, Connection con) throws SQLException {
		String query = "update offices set lastmodified_by= ?,lastmodified_at=NOW(),record_status=0 where office_code= ? AND record_status>0";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, office.getOfficeCode());
		ps.setString(2, office.getOfficeCode());
		int rs = ps.executeUpdate();
		return rs;
	}
}
