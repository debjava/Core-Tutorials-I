/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : LogoutAction.java
 * Classes      : LogoutAction 
 */
package com.johntopley.webforum.controller.action;

import com.johntopley.webforum.controller.action.BaseAction;
import com.johntopley.webforum.model.UserCookie;
import com.johntopley.webforum.view.ForwardConstants;
import com.johntopley.webforum.view.KeyConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LogoutAction extends BaseAction
{
  public LogoutAction()
  {
    super();   
  }

  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) throws Exception
  {
    HttpSession session = request.getSession();

    // Clean up the HTTP session and expire the cookie containing the user ID.
    // *** MOVE THESE COMMENTS INTO JAVADOC. ***
    session.removeAttribute(KeyConstants.USER_KEY);
    session.invalidate();
    
    UserCookie userCookie = new UserCookie(request);
    userCookie.expire(response);
        
    return mapping.findForward(ForwardConstants.VIEW_TOPICS);
  } 
}