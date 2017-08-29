package com.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dao.PersonRegistrationDao;

public class PersonRegisterListController extends Action 
{
	PersonRegistrationDao dao=new PersonRegistrationDao();
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		// TODO Auto-generated method stub
		ArrayList list=dao.allPerson();
		if(list!=null||list.size()>0)
		{
			request.setAttribute("personDetail",list);
			return  mapping.findForward("listOfPerson");
		}
		else 
		{
			return  mapping.findForward("failRegister");
		}
		//return super.execute(mapping, form, request, response);
	}
}
