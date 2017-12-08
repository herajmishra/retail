package com.splus.learn.rest.beans;

/**
 * This class is for Product bean. 
 * @author Nazish.Khatoon
 *
 */
public class Product {
	private String productCode;
	private String productName;
	private String productLine;
	private String productScale;
	private String productVendor;
	private String productDescription;
	private int quantityInStock;
	private double buyPrice;
	private double msrp;
/**
 * This method is for getting Product Code.
 * @return
 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * This method is for setting Product Code.
	 * @return
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * This method is for getting Product Name.
	 * @return
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * This method is for setting Product Name.
	 * @return
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * This method is for getting Product Line.
	 * @return
	 */
	public String getProductLine() {
		return productLine;
	}
	/**
	 * This method is for setting Product Name.
	 * @return
	 */
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	/**
	 * This method is for getting Product Scale.
	 * @return
	 */
	public String getProductScale() {
		return productScale;
	}
	/**
	 * This method is for setting Product Name.
	 * @return
	 */
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}
	/**
	 * This method is for getting Product Vendor.
	 * @return
	 */
	public String getProductVendor() {
		return productVendor;
	}
	/**
	 * This method is for setting Product Name.
	 * @return
	 */
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}
	/**
	 * This method is for getting Product Description.
	 * @return
	 */
	public String getProductDescription() {
		return productDescription;
	}
	/**
	 * This method is for setting Product Description.
	 * @return
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	/**
	 * This method is for getting Product Quantity in Stock
	 * @return
	 */
	public int getQuantityInStock() {
		return quantityInStock;
	}
	/**
	 * This method is for setting Product Quantity in Stock
	 * @return
	 */
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	/**
	 * This method is for getting Product Buy Price
	 * @return
	 */
	public double getBuyPrice() {
		return buyPrice;
	}
	/**
	 * This method is for setting Product Buy Price
	 * @return
	 */
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	/**
	 * This method is for getting Product msrp
	 * @return
	 */
	public double getMsrp() {
		return msrp;
	}
	/**
	 * This method is for setting Product msrp
	 * @return
	 */
	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}
}
