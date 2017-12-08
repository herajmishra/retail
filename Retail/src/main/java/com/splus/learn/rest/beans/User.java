package com.splus.learn.rest.beans;

import java.io.Serializable;
/**
 * This class is for User bean. 
 * @author Nazish.Khatoon
 *
 */
public class User implements Serializable {
	private int id;
	private String fName;
	private String lName;
	private String userName;
	private String password;
	private String token;
	/**
	 * This method is for getting Token
	 * @return
	 */
	public String getToken() {
		return token;
	}
	/**
	 * This method is for setting Token.
	 * @return
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * This method is for getting Id
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * This method is for setting Id
	 * @return
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * This method is for getting Id
	 * @return
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * This method is for setting First Name
	 * @return
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * This method is for getting First Name
	 * @return
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * This method is for setting Last Name
	 * @return
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	/**
	 * This method is for getting User Name
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * This method is for setting User Name
	 * @return
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * This method is for getting Password
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * This method is for setting Password
	 * @return
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
