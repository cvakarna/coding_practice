package com.models;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties
public class User {

	private String registerID;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String uniqueId;
	private String panNumber;
	private String gender;
	private String maritalStatus;
	private String communicationAddress;
	private String permanentAddress;
/*	private String course;
	private String college;
	private String yearOfSucess;
	private double percentage;*/
	
	//private User user[];
	private List<EducationDetail> educationDetails;
	
public List<EducationDetail> getEducationDetails() {
		return educationDetails;
	}
	public void setEducationDetails(List<EducationDetail> educationDetails) {
		this.educationDetails = educationDetails;
	}
/*	public User[] getUser() {
		return user;
	}
	public void setUser(User[] user) {
		this.user = user;
	}
*/	public String getRegisterID() {
		return registerID;
	}
	public void setRegisterID(String registerID) {
		this.registerID = registerID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getuniqueId() {
		return uniqueId;
	}
	public void setuniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getCommunicationAddress() {
		return communicationAddress;
	}
	public void setCommunicationAddress(String communicationAddress) {
		this.communicationAddress = communicationAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	/*public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getYearOfSucess() {
		return yearOfSucess;
	}
	public void setYearOfSucess(String yearOfSucess) {
		this.yearOfSucess = yearOfSucess;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
*/	
	
	
}
