package com.splus.learn.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.splus.learn.rest.beans.Employee;

/**
 * This is Dao class for Employee
 * 
 * @author Rishabh Goel
 *
 */
public class EmployeeDao extends AbstractDao {
	/**
	 * This method is for selecting all the details from the database where passed
	 * employeeNumber matches with the employee_number in the table
	 * 
	 * @param employee
	 * @param con
	 * @return Employee
	 * @throws SQLException
	 */
	public Employee employeeById(Employee employee, Connection con) throws SQLException {

		Statement stmt = con.createStatement();
		int employeeNumber = employee.getEmployeeNumber();
		String query = "select employee_number,last_name,first_name,extension,email,office_code,reports_to,job_title "
				+ "from employees where employee_number= '" + employeeNumber + "'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			employee.setEmployeeNumber(rs.getInt("employee_number"));
			employee.setLastName(rs.getString("last_name"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setExtension(rs.getString("extension"));
			employee.setEmail(rs.getString("email"));
			employee.setOfficeCode(rs.getString("office_code"));
			employee.setReportsTo(rs.getInt("reports_to"));
			employee.setJobTitle(rs.getString("job_title"));
		}

		return employee;

	}

	/**
	 * This method selects all the data in the table employees
	 * 
	 * @param employee1
	 * @param con
	 * @return List<Employee>
	 * @throws SQLException
	 */
	public List<Employee> employeeShow(Employee employee1, Connection con) throws SQLException {

		Statement stmt = con.createStatement();
		String query = "select employee_number,last_name,first_name,extension,email,office_code,reports_to,job_title from employees";
		ResultSet rs = stmt.executeQuery(query);
		List<Employee> employees = new ArrayList<Employee>();
		while (rs.next()) {
			Employee employee = new Employee();
			employee.setEmployeeNumber(rs.getInt("employee_number"));
			employee.setLastName(rs.getString("last_name"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setExtension(rs.getString("extension"));
			employee.setEmail(rs.getString("email"));
			employee.setOfficeCode(rs.getString("office_code"));
			employee.setReportsTo(rs.getInt("reports_to"));
			employee.setJobTitle(rs.getString("job_title"));
			employees.add(employee);
		}

		return employees;

	}

	/**
	 * This method inserts the data of employee into database
	 * 
	 * @param employee
	 * @param con
	 * @return rs
	 * @throws SQLException
	 */
	public int saveEmployee(Employee employee, Connection con) throws SQLException {
		String query = "insert into employees(employee_number, last_name, first_name, extension, email, office_code, reports_to, job_title, created_by, created_at,record_status) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(),1)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, employee.getEmployeeNumber());
		ps.setString(2, employee.getLastName());
		ps.setString(3, employee.getFirstName());
		ps.setString(4, employee.getExtension());
		ps.setString(5, employee.getEmail());
		ps.setString(6, employee.getOfficeCode());
		ps.setInt(7, employee.getReportsTo());
		ps.setString(8, employee.getJobTitle());
		ps.setString(9, employee.getFirstName());
		int rs = ps.executeUpdate();

		return rs;
	}

	/**
	 * This method updates the data in the database for employee
	 * 
	 * @param employee
	 * @param con
	 * @return rs
	 * @throws SQLException
	 */
	public int updateEmployee(Employee employee, Connection con) throws SQLException {
		String query = "update employees set last_name= ?, first_name=?, extension=?, email=?, office_code=?, reports_to=?, job_title=?, lastmodified_by=?, lastmodified_at=NOW() where employee_number= ? AND record_status>0";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, employee.getLastName());
		ps.setString(2, employee.getFirstName());
		ps.setString(3, employee.getExtension());
		ps.setString(4, employee.getEmail());
		ps.setString(5, employee.getOfficeCode());
		ps.setInt(6, employee.getReportsTo());
		ps.setString(7, employee.getJobTitle());
		ps.setString(8, employee.getFirstName());
		ps.setInt(9, employee.getEmployeeNumber());
		int rs = ps.executeUpdate();
		return rs;
	}

	/**
	 * This method logically deletes the data of a employee by setting its record
	 * status as 0
	 * 
	 * @param employee
	 * @param con
	 * @return rs
	 * @throws SQLException
	 */
	public int deleteEmployee(Employee employee, Connection con) throws SQLException {
		String query = "update employees set lastmodified_by= ?,lastmodified_at=NOW(),record_status=0 where employee_number= ? AND record_status>0";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, employee.getFirstName());
		ps.setInt(2, employee.getEmployeeNumber());
		int rs = ps.executeUpdate();
		return rs;
	}
}
