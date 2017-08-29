package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.PersonBean;
import com.dao.PersonRegistrationDao;

public class PersonRegistorUpdateController extends Action 
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,HttpServletResponse  response) throws Exception {
		// TODO Auto-generated method stub

		boolean isError=false;
		PersonBean bean=(PersonBean)form;
		bean.setDateOfBirth(request.getParameter("dob"));
		PersonRegistrationDao dao=new PersonRegistrationDao();
		
		if(bean.getFirstName()==null||bean.getFirstName().trim().length()==0)
		{
			isError=true;
			request.setAttribute("firstName","<font color=\"red\">Name Requirement..</font>");
		}
		if(bean.getLastName()==null||bean.getLastName().trim().length()==0)
		{
			isError=true;
			request.setAttribute("lastName","<font color=\"red\">Surname Requirement..</font>");
		}
		if(bean.getGender()==null||bean.getGender().trim().length()==0)
		{
			isError=true;
			request.setAttribute("gender","<font color=\"red\">Select Gender..</font>");
		}
		if(bean.getDateOfBirth()==null||bean.getDateOfBirth().trim().length()==0)
		{
			isError=true;
			request.setAttribute("dob","<font color=\"red\">Select Date Of Birth..</font>");
		}
		if(bean.getAddress()==null||bean.getAddress().trim().length()==0)
		{
			isError=true;
			request.setAttribute("address","<font color=\"red\">Address Required..</font>");
		}
		if(bean.getMobileNo()==null||bean.getMobileNo().trim().length()==0)
		{
			isError=true;
			request.setAttribute("mobileNo","<font color=\"red\">Mobile No Required..</font>");
		}
		
		if(bean.getHigestQulification().equals("--Select--"))
		{
			isError=true;
			request.setAttribute("hq","<font color=\"red\">Select Higest Qulification..</font>");
		}
		
		
		
		if (isError)
		{
			request.setAttribute("bean",bean);
			return  mapping.findForward("failSelectedPersonUpdate");
		}
		else 
		{
			boolean isUpdate=dao.updatePerson(bean);
			if (isUpdate) 
			{
				return  mapping.findForward("selectedPersonUpdate");
			}
			
			else 
			{
				request.setAttribute("bean",bean);
				return  mapping.findForward("failSelectedPersonUpdate");
			}
			
		}
	}
}
