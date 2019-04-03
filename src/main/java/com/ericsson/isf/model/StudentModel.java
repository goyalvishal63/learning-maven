package com.ericsson.isf.model;

public class StudentModel {
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	private long rollNumber;
	private String name;
	private String email;
	private String stream;
	
	public StudentModel() {}
	public StudentModel(long rollNumber,String name,String email,String stream) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.email = email;
		this.stream = stream;
	}
	
	public String toString() {
		return "Roll Number : "+rollNumber+"\nName : "+name+"\nE-Mail : "+email;
	}
	public long getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(long rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
