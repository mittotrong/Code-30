package com.bean;

import org.apache.struts.action.ActionForm;

public class LoginBean extends ActionForm 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8770192001847916010L;
	String userName;
	String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
