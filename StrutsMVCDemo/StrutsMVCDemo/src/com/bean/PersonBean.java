package com.bean;
import org.apache.struts.action.ActionForm;

public class PersonBean extends ActionForm 
{
	private static final long serialVersionUID = -1609458719375442750L;
	String pid;
	String firstName;
	String lastName;
	String gender;
	String dateOfBirth;
	String address;
	String mobileNo;
	String higestQulification;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getHigestQulification() {
		return higestQulification;
	}
	public void setHigestQulification(String higestQulification) {
		this.higestQulification = higestQulification;
	}
}
