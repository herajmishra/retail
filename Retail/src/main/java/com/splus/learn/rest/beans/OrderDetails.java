package com.splus.learn.rest.beans;

/**
 * This class is for OrderDetails bean.
 * 
 * @author Rishabh.Goel
 *
 */
public class OrderDetails {
	private int orderNumber;
	private String productCode;
	private int quantityOrdered;
	private double priceEach;
	private int orderLineNumber;

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
	 * This method is for getting productCode.
	 * 
	 * @return productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * This method is for setting productCode
	 * 
	 * @param productCode
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * This method is for getting quantityOrdered.
	 * 
	 * @return quantityOrdered
	 */
	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	/**
	 * This method is for setting quantityOrdered
	 * 
	 * @param quantityOrdered
	 */
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	/**
	 * This method is for getting priceEach.
	 * 
	 * @return priceEach
	 */
	public double getPriceEach() {
		return priceEach;
	}

	/**
	 * This method is for setting priceEach
	 * 
	 * @param priceEach
	 */
	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	/**
	 * This method is for getting orderLineNumber.
	 * 
	 * @return orderLineNumber
	 */
	public int getOrderLineNumber() {
		return orderLineNumber;
	}

	/**
	 * This method is for setting orderLineNumber
	 * 
	 * @param orderLineNumber
	 */
	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

}
