package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.PersonBean;
import com.dao.PersonRegistrationDao;

public class PersonRegistorDeleteController extends Action 
{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		// TODO Auto-generated method stub
		PersonRegistrationDao dao=new PersonRegistrationDao();
		PersonBean bean=(PersonBean)form;
		boolean isDelete=dao.deletePerson(request.getParameter("pid"));
		if (isDelete) 
		{
			return mapping.findForward("selectedPersonDelete");
		}
		else
		{
			return mapping.findForward("selectedPersonDeleteFail");
		}
		
		//return super.execute(mapping, form, request, response);
	}
}
