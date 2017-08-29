package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.PersonBean;
import com.dao.PersonRegistrationDao;

public class PersonRegistorSelectController extends Action 
{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		PersonRegistrationDao dao = new PersonRegistrationDao();
		System.out.println("Start ...."+request.getParameter("pid"));
		PersonBean selectPersonBean = dao.selectPerson(request.getParameter("pid"));

		PersonBean bean = (PersonBean)form;

		bean.setPid(selectPersonBean.getPid());
		bean.setFirstName(selectPersonBean.getFirstName());
		bean.setLastName(selectPersonBean.getLastName());
		bean.setGender(selectPersonBean.getGender());
		bean.setDateOfBirth(selectPersonBean.getDateOfBirth());
		bean.setAddress(selectPersonBean.getAddress());
		bean.setMobileNo(selectPersonBean.getMobileNo());
		bean.setHigestQulification(selectPersonBean.getHigestQulification());
		System.out.println("edit ....");
		
		request.setAttribute("bean",bean);
		
		return mapping.findForward("selectedPerson");
		//return super.execute(mapping, form, request, response);
	}
}
