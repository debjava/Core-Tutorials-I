/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : RegisterSubmitAction.java
 * Classes      : RegisterSubmitAction 
 */
package com.johntopley.webforum.controller.action;

import com.johntopley.webforum.controller.action.BaseAction;
import com.johntopley.webforum.controller.form.NewUserForm;
import com.johntopley.webforum.data.UsersDAO;
import com.johntopley.webforum.model.User;
import com.johntopley.webforum.model.UserCookie;
import com.johntopley.webforum.view.ErrorConstants;
import com.johntopley.webforum.view.ForwardConstants;
import com.johntopley.webforum.view.KeyConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RegisterSubmitAction extends BaseAction
{  
  public RegisterSubmitAction()
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
      User user = new User();
      BeanUtils.copyProperties(user, form);
      UsersDAO usersDAO = new UsersDAO();
      
      // Check if a user with this user name already exists. If so, raise an
      // ActionError and return to the registration form.
      if (usersDAO.isExistingUser(user.getUsername()))
      {
        ActionErrors errors = new ActionErrors();
        errors.add(ErrorConstants.USERNAME_EXISTS_ERROR_KEY,
          new ActionError("error.username.exists", user.getUsername()));

        saveErrors(request, errors);
      
        return mapping.getInputForward();  
      }

      // The user name doesn't exist, so create a record for the user and store
      // the User object in the HTTP session.
      else
      {
        NewUserForm newUserForm = (NewUserForm) form;
        String password = newUserForm.getPassword();
        Long userID = usersDAO.addUser(user, password);

        // Update the User object with the ID from the inserted record.
        user.setUserID(userID.toString());        
        
        HttpSession session = request.getSession();
        session.setAttribute(KeyConstants.USER_KEY, user);

        // If the user checked the auto-login checkbox, then store a cookie
        // containing the user ID.
        if (newUserForm.getAutoLogin())
        {
          UserCookie userCookie = new UserCookie(request);
          userCookie.setUserID(user.getUserID());
          userCookie.save(response);
        }
      }
    }
    
    return mapping.findForward(ForwardConstants.VIEW_TOPICS);
  } 
}