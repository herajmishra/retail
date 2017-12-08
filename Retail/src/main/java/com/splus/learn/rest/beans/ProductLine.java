package com.splus.learn.rest.beans;
/**
 * This class is for Product Line bean. 
 * @author Nazish.Khatoon
 *
 */

public class ProductLine {
	private String productLine;
	private String textDescription;
	private String htmlDescription;
	private byte[] image;
	/**
	 * This method is for getting Product Line.
	 * @return
	 */
	public String getProductLine() {
		return productLine;
	}
	/**
	 * This method is for setting Product Line.
	 * @return
	 */
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	/**
	 * This method is for getting Text Description
	 * @return
	 */
	public String getTextDescription() {
		return textDescription;
	}
	/**
	 * This method is for setting Text Description.
	 * @return
	 */
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}
	/**
	 * This method is for getting HTML Description.
	 * @return
	 */
	public String getHtmlDescription() {
		return htmlDescription;
	}
	/**
	 * This method is for setting HTML Description.
	 * @return
	 */
	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}
	/**
	 * This method is for getting image.
	 * @return
	 */
	public byte[] getImage() {
		return image;
	}
	/**
	 * This method is for setting image.
	 * @return
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

}
