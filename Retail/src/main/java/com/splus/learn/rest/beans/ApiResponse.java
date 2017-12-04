package com.splus.learn.rest.beans;

/**
 * This beans is used for sending response to client. 
 * @author Heraj.Mishra
 *
 */
public class ApiResponse {

	private int code;
	private Object result;
	private String message;

	/**
	 * This methods is for getting code. 
	 * @return
	 */
	public int getCode() {
		return code;
	}

	/**
	 * This method is for setting code. 
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * This method is for getting result.
	 * @return
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * This method is for setting result. 
	 * @param code
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * This method is for getting message.
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * This method is for setting message. 
	 * @param code
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
