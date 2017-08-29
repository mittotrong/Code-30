package com.controller;

import java.util.ArrayList;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.dao.HigestQulifictionDao;

public class ApplicationResource implements PlugIn {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(ActionServlet actionServlet, ModuleConfig moduleConfig)
			throws ServletException 
	{
		// TODO Auto-generated method stub
		
		ArrayList qulificationList=new ArrayList();
		HigestQulifictionDao dao=new HigestQulifictionDao();
		qulificationList.addAll(dao.getHigetstQulification());
		actionServlet.getServletContext().setAttribute("listOfQulification", qulificationList);
	}

}
