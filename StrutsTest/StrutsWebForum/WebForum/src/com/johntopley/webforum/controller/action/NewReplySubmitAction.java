/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : NewReplySubmitAction.java
 * Classes      : NewReplySubmitAction 
 */
package com.johntopley.webforum.controller.action;

import com.johntopley.webforum.controller.action.BaseAction;
import com.johntopley.webforum.data.PostsDAO;
import com.johntopley.webforum.model.Post;
import com.johntopley.webforum.model.User;
import com.johntopley.webforum.view.ForwardConstants;
import com.johntopley.webforum.view.KeyConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class NewReplySubmitAction extends BaseAction
{
  public NewReplySubmitAction()
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
      HttpSession session = request.getSession();
      Long topicID
        = (Long) session.getAttribute(KeyConstants.POST_ID_KEY);
        
      User user = (User) session.getAttribute(KeyConstants.USER_KEY);
      Post reply = new Post();
      BeanUtils.copyProperties(reply, form);
      PostsDAO postsDAO = new PostsDAO();
      postsDAO.addReply(topicID, reply, new Long(user.getUserID()));
    }    
    
    return mapping.findForward(ForwardConstants.VIEW_TOPIC);
  } 
}