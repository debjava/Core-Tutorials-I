/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : ViewTopicsAction.java
 * Classes      : ViewTopicsAction 
 */
package com.johntopley.webforum.controller.action;

import com.johntopley.webforum.controller.action.BaseAction;
import com.johntopley.webforum.data.PostsDAO;
import com.johntopley.webforum.data.UsersDAO;
import com.johntopley.webforum.model.User;
import com.johntopley.webforum.model.UserCookie;
import com.johntopley.webforum.view.ForwardConstants;
import com.johntopley.webforum.view.KeyConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Struts <code>Action</code> class that displays the list of topics.
 * 
 * @author John Topley
 * @version 1.0
 */
public class ViewTopicsAction extends BaseAction
{
  /**
   * No argument constructor for creating a new <code>ViewTopicsAction</code>.
   * Calls the superclass constructor.
   */
  public ViewTopicsAction()
  {
    super();   
  }

  /**
   * Stores the list of topics in the HTTP request under the key
   * <code>KeyConstants.POST_LIST_KEY</code>.
   *
   * @param mapping The <code>ActionMapping</code> used to select this instance.
   * @param form The optional <code>ActionForm</code> bean for this request.
   * @param request The HTTP request being processed.
   * @param response The HTTP response being processed.
   * @return an <code>ActionForward</code> for the Topics page.
   * @exception Exception if an error occurred.
   * 
   * @see com.johntopley.webforum.view.KeyConstants#POST_LIST_KEY
   */
  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) throws Exception
  {
    HttpSession session = request.getSession();
    session.removeAttribute(KeyConstants.POST_ID_KEY);
    session.removeAttribute(KeyConstants.POST_SUBJECT_KEY);

    // Try to get the User object from the HTTP session. If it doesn't exist
    // then create a new User object using the user ID stored in the cookie
    // created if the user elected to automatically log in, and store that User
    // object in the HTTP session.
    if (session.getAttribute(KeyConstants.USER_KEY) == null)
    {
      UserCookie userCookie = new UserCookie(request);
      String userID = userCookie.getUserID();

      if (userID != null)
      {
        UsersDAO usersDAO = new UsersDAO();
        User user = usersDAO.getUser(new Long(userID));      
        session.setAttribute(KeyConstants.USER_KEY, user);
      }
    }
    
    request.setAttribute(KeyConstants.POST_LIST_KEY,
      new PostsDAO().getTopics());
    
    return mapping.findForward(ForwardConstants.TOPICS_PAGE);
  }
}