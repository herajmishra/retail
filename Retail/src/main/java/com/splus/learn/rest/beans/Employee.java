package com.splus.learn.rest.beans;

/**
 * This class is for Employee bean.
 * 
 * @author Heraj.Mishra
 *
 */
public class Employee {
	private int employeeNumber;
	private String lastName;
	private String firstName;
	private String extension;
	private String email;
	private String phone;
	private String officeCode;
	private int reportsTo;
	private String jobTitle;

	/**
	 * This method is for getting employeeNumber
	 * 
	 * @return employeeNumber
	 */
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * This method is for setting employeeNumber
	 * 
	 * @param employeeNumber
	 */
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	/**
	 * This method is for getting lastName
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This method is for setting lastName
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * This method is for getting firstName
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * This method is for setting firstName
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * This method is for getting extension
	 * 
	 * @return extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * This method is for setting extension
	 * 
	 * @param extension
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * This method is for getting email
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method is for setting email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method is for getting officeCode
	 * 
	 * @return officeCode
	 */
	public String getOfficeCode() {
		return officeCode;
	}

	/**
	 * This method is for setting officeCode
	 * 
	 * @param officeCode
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	/**
	 * This method is for getting reportsTo
	 * 
	 * @return reportsTo
	 */
	public int getReportsTo() {
		return reportsTo;
	}

	/**
	 * This method is for setting reportsTo
	 * 
	 * @param reportsTo
	 */
	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	/**
	 * This method is for getting jobTitle
	 * 
	 * @return jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * This method is for setting jobTitle
	 * 
	 * @param jobTitle
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}
