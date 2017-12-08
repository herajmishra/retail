package com.splus.learn.rest.enums;

import java.io.Serializable;

/**
 * This is enumeration for Status
 * 
 * @author Rishabh Goel
 *
 */
public enum Status implements Serializable {
	FAILED(0, "FAILED"), SUCCESS(1, "SUCCESS");
	private final int status;
	private final String description;

	/**
	 * This is a constructor for the enum
	 * 
	 * @param aStatus
	 * @param desc
	 */
	Status(int aStatus, String desc) {
		this.status = aStatus;
		this.description = desc;
	}

	/**
	 * This method returns status
	 * 
	 * @return status
	 */
	public int status() {
		return this.status;
	}

	/**
	 * This method returns description
	 * 
	 * @return description
	 */
	public String description() {
		return this.description;
	}
}
