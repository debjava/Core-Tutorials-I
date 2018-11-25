/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : ViewTopicAction.java
 * Classes      : ViewTopicAction 
 */
package com.johntopley.webforum.controller.action;

import com.johntopley.webforum.controller.action.BaseAction;
import com.johntopley.webforum.data.PostsDAO;
import com.johntopley.webforum.view.ForwardConstants;
import com.johntopley.webforum.view.KeyConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ViewTopicAction extends BaseAction
{
  public ViewTopicAction()
  {
    super();   
  }

  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) throws Exception
  {
    HttpSession session = request.getSession();
    String postID = request.getParameter("pid");

    // Coming here from NewReplySubmitAction, so the topic ID is in the HTTP
    // session and not a URL parameter.
    if (postID == null)
    {
      postID = session.getAttribute(KeyConstants.POST_ID_KEY).toString();
    }
    
    if (postID != null)
    {
      Long topicID = new Long(postID);
      PostsDAO postsDAO = new PostsDAO();
      
      session.setAttribute(KeyConstants.POST_ID_KEY, topicID);
      session.setAttribute(KeyConstants.POST_SUBJECT_KEY,
        postsDAO.getSubject(topicID));        
      session.setAttribute(KeyConstants.POST_LIST_KEY,
        postsDAO.getReplies(topicID));
    }    
    
    return mapping.findForward(ForwardConstants.TOPIC_PAGE);
  } 
}