/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : LoginSubmitAction.java
 * Classes      : LoginSubmitAction 
 */
package com.johntopley.webforum.controller.action;

import com.johntopley.webforum.controller.action.BaseAction;
import com.johntopley.webforum.controller.form.LoginForm;
import com.johntopley.webforum.data.UsersDAO;
import com.johntopley.webforum.model.User;
import com.johntopley.webforum.model.UserCookie;
import com.johntopley.webforum.view.ErrorConstants;
import com.johntopley.webforum.view.ForwardConstants;
import com.johntopley.webforum.view.KeyConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginSubmitAction extends BaseAction
{
  public LoginSubmitAction()
  {
    super();   
  }

  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) throws Exception
  {
    if (!isCancelled(request))
    {
      LoginForm loginForm = (LoginForm) form;
      UsersDAO usersDAO = new UsersDAO();
      User user = usersDAO.checkUserCredentials(loginForm.getUsername(),
                                                loginForm.getPassword());

      // The user credentials check returned a populated User object, so store
      // it in the HTTP session.
      if (user != null)
      {
        HttpSession session = request.getSession();
        session.setAttribute(KeyConstants.USER_KEY, user);

        // If the user checked the auto-login checkbox, then store a cookie
        // containing the user ID.
        if (loginForm.getAutoLogin())
        {
          UserCookie userCookie = new UserCookie(request);
          userCookie.setUserID(user.getUserID());
          userCookie.save(response);
        }
      }

      // The user credentials check failed. Reset the password field, raise an
      // ActionError and return to the login form.
      else
      {
        loginForm.setPassword(null);        
        ActionErrors errors = new ActionErrors();
        errors.add(ErrorConstants.LOGIN_ERROR_KEY,
          new ActionError("error.login.failed"));

        saveErrors(request, errors);
      
        return mapping.getInputForward();
      }    
    }   
    
    return mapping.findForward(ForwardConstants.VIEW_TOPICS);
  } 
}