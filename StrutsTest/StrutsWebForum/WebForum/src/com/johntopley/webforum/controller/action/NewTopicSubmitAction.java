/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : NewTopicSubmitAction.java
 * Classes      : NewTopicSubmitAction 
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

public class NewTopicSubmitAction extends BaseAction
{
  public NewTopicSubmitAction()
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
      User user = (User) session.getAttribute(KeyConstants.USER_KEY);
      Post topic = new Post();
      BeanUtils.copyProperties(topic, form);
      PostsDAO postsDAO = new PostsDAO();
      postsDAO.addTopic(topic, new Long(user.getUserID()));
    }    
    
    return mapping.findForward(ForwardConstants.VIEW_TOPICS);
  } 
}