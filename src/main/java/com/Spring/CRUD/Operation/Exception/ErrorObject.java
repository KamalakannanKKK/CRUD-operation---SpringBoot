package com.Spring.CRUD.Operation.Exception;

public class ErrorObject {

	private int Statuscode;
	private String message;
	private long timestamp;
	public int getStatuscode() {
		return Statuscode;
	}
	public void setStatuscode(int statuscode) {
		Statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public ErrorObject(int statuscode, String message, long timestamp) {
		super();
		Statuscode = statuscode;
		this.message = message;
		this.timestamp = timestamp;
	}
	public ErrorObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
