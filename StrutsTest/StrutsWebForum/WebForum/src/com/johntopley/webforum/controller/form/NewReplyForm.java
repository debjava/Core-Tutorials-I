/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : NewReplyForm.java
 * Classes      : NewReplyForm 
 */
package com.johntopley.webforum.controller.form;

import com.johntopley.webforum.view.ErrorConstants;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Struts <code>ActionForm</code> corresponding to the new reply screen.
 * 
 * @author John Topley
 * @version 1.0 
 */
public class NewReplyForm extends ActionForm 
{
  private String message;

  public NewReplyForm()
  {
    super();
  }

  public String getMessage()
  {
    return this.message;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }
  
  /**
   * Reset all properties to their default values.
   * 
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   */
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
    setMessage(null);
  }

  /**
   * Validate all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   * @return <code>ActionErrors</code> A list of all errors found.
   */
  public ActionErrors validate(ActionMapping mapping,
                               HttpServletRequest request)
  {
    ActionErrors errors = new ActionErrors();   

    if (getMessage() == null || getMessage().length() == 0)
    {
      errors.add(ErrorConstants.MESSAGE_ERROR_KEY,
        new ActionError("error.required"));    
    }    

    return errors;
  }
}