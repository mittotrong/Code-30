package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.LoginBean;
import com.dao.LoginDao;

public class LoginAuthController extends Action 
{
	LoginDao dao=new LoginDao();
	@Override
		public ActionForward execute(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			boolean isError=false;
			
			LoginBean bean=(LoginBean)form;
			
			if (bean.getUserName()==null||bean.getUserName().trim().length()==0)
			{
				request.setAttribute("uName","<font color=\"red\">User Name Required... </font> ");
				isError=true;
			}
			else 
			{
				if (bean.getPassword()==null||bean.getPassword().trim().length()==0)
				{
					request.setAttribute("passwd","<font color=\"red\">Password Required... </font> ");
					isError=true;
				}
			}
			
			if (isError) {
				bean.setPassword("");
				return mapping.findForward("fail");
			} 
			else 
			{
				boolean isLogin=dao.loginAuth(bean);
				if (isLogin) 
				{
					
					return mapping.findForward("success");
				}
				else {
					bean.setPassword("");
					request.setAttribute("invaidPasswd","<font color=\"red\">Invalid User Name Or Password... </font> ");
					return mapping.findForward("fail");
				}

			}
		}
}
