package com.splus.learn.rest.beans;

/**
 * This class is for Payment bean.
 * 
 * @author Nazish.Khatoon
 *
 */
public class Payment {
	private int paymentId;
	private String paymentRefNo;
	private String bank;
	private String ifscCode;
	private int customerNumber;
	private String checkNumber;
	private int paymentDate;
	private double amount;

	/**
	 * This method is for getting payment id
	 * 
	 * @return paymentId
	 */
	public int getPaymentId() {
		return paymentId;
	}

	/**
	 * This method is for setting payment id
	 * 
	 * @param paymentId
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * This method is for getting payment reference number
	 * 
	 * @return paymentRefNo
	 */
	public String getPaymentRefNo() {
		return paymentRefNo;
	}

	/**
	 * This method is for setting payment reference number
	 * 
	 * @param paymentRefNo
	 */
	public void setPaymentRefNo(String paymentRefNo) {
		this.paymentRefNo = paymentRefNo;
	}

	/**
	 * This method is for getting payment bank
	 * 
	 * @return bank
	 */
	public String getBank() {
		return bank;
	}

	/**
	 * This method is for setting payment bank
	 * 
	 * @param bank
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}

	/**
	 * This method is for getting ifsc code
	 * 
	 * @return ifscCode
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * This method is for setting ifsc code
	 * 
	 * @return ifscCode
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * This method is for getting customer number
	 * 
	 * @return customerNumber
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * This method is for setting customer number
	 * 
	 * @return customerNumber
	 */
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * This method is for getting check number
	 * 
	 * @return checkNumber
	 */
	public String getCheckNumber() {
		return checkNumber;
	}

	/**
	 * This method is for setting check number
	 * 
	 * @return checkNumber
	 */
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	/**
	 * This method is for getting payment date
	 * 
	 * @return paymentDate
	 */
	public int getPaymentDate() {
		return paymentDate;
	}

	/**
	 * This method is for setting payment date
	 * 
	 * @return paymentDate
	 */
	public void setPaymentDate(int paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * This method is for getting amount
	 * 
	 * @return amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * This method is for setting amount
	 * 
	 * @return amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
