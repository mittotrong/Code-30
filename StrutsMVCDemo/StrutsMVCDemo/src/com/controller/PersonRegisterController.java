package com.controller;

import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.PersonBean;
import com.dao.PersonRegistrationDao;

public class PersonRegisterController extends Action 
{
	PersonRegistrationDao dao=new PersonRegistrationDao();
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
		{
		
		boolean isError=false;
		PersonBean bean=(PersonBean)form;
		bean.setDateOfBirth(request.getParameter("dob"));
		
		/*System.out.println("First Name :-"+bean.getFirstName());
		System.out.println("Last Name :-"+bean.getLastName());
		System.out.println("Gender :-"+bean.getGender());
		System.out.println("Date Of Birth :-"+bean.getDateOfBirth());
		System.out.println("Address :-"+bean.getAddress());
		System.out.println("Mobile No :-"+bean.getMobileNo());
		System.out.println("Higest Qulification :-"+bean.getHigestQulification());*/
		
		/*if (bean.getFirstName()==null||bean.getFirstName().trim().length()==0) {
			return  mapping.findForward("failRegister");
		} else 
		{
			boolean isRegister=dao.registerPerson(bean);
			if (isRegister) 
			{
				return  mapping.findForward("register");
			}
			else 
			{
				return  mapping.findForward("failRegister");
			}
			
		}*/
		
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
			return  mapping.findForward("failRegister");
		}
		else 
		{
			boolean isRegister=dao.registerPerson(bean);
			if (isRegister) 
			{
				return  mapping.findForward("register");
			}
			else 
			{
				request.setAttribute("bean",bean);
				return  mapping.findForward("failRegister");
			}
		}
		
	}
}
