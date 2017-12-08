package com.splus.learn.rest.beans;

/**
 * This class is for Order bean.
 * 
 * @author Rishabh.Goel
 *
 */
public class Order {
	private int orderNumber;
	private String orderDate;
	private String requiredDate;
	private String shippedDate;
	private String orderStatus;
	private String comments;
	private OrderDetails orderDetails;
	private int customerNumber;

	/**
	 * This method is for getting orderNumber.
	 * 
	 * @return orderNumber
	 */
	public int getOrderNumber() {
		return orderNumber;
	}

	/**
	 * This method is for setting orderNumber
	 * 
	 * @param orderNumber
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * This method is for getting orderDate.
	 * 
	 * @return orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * This method is for setting orderDate
	 * 
	 * @param orderDate
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * This method is for getting requiredDate.
	 * 
	 * @return requiredDate
	 */
	public String getRequiredDate() {
		return requiredDate;
	}

	/**
	 * This method is for setting requiredDate
	 * 
	 * @param requiredDate
	 */
	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}

	/**
	 * This method is for getting shippedDate.
	 * 
	 * @return shippedDate
	 */
	public String getShippedDate() {
		return shippedDate;
	}

	/**
	 * This method is for setting orderStatus
	 * 
	 * @param orderStatus
	 */
	public void setShippedDate(String shippedDate) {
		this.shippedDate = shippedDate;
	}

	/**
	 * This method is for getting orderStatus.
	 * 
	 * @return orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * This method is for setting orderStatus
	 * 
	 * @param orderStatus
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * This method is for getting comments.
	 * 
	 * @return comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * This method is for setting comments
	 * 
	 * @param comments
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * This method is for getting orderDetails.
	 * 
	 * @return orderDetails
	 */
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	/**
	 * This method is for setting orderDetails
	 * 
	 * @param orderDetails
	 */
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	/**
	 * This method is for getting customerNumber.
	 * 
	 * @return customerNumber
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * This method is for setting customerNumber
	 * 
	 * @param customerNumber
	 */
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

}