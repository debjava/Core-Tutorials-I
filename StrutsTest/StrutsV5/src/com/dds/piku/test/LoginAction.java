package com.dds.piku.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action 
{
	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		LoginForm loginForm = (LoginForm)form;
		String userName = loginForm.getUsername();
		String password = loginForm.getPassword();
		if(password.equals("pikupiku"))
		{
			return mapping.findForward("success");
		}
		else
		{
			return mapping.findForward("failure");
		}
		
		
	}

}
