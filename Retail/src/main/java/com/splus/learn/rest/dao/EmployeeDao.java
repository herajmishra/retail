package com.splus.learn.rest.dao;

import java.sql.Connection;
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
}
