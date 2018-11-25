/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : LoginForm.java
 * Classes      : LoginForm 
 */
package com.johntopley.webforum.controller.form;

import com.johntopley.webforum.view.ErrorConstants;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Struts <code>ActionForm</code> corresponding to the login screen.
 * 
 * @author John Topley
 * @version 1.0 
 */
public class LoginForm extends ActionForm 
{
  /**
   * Auto-login option.
   */
  private boolean autoLogin;

  /**
   * The user's password.
   */
  private String password;

  /**
   * The user name the user uses to log in with.
   */
  private String username;  

  /**
   * No argument constructor for constructing a new <code>LoginForm</code>.
   * Calls the superclass constructor.
   */
  public LoginForm()
  {
    super();
  }

  public boolean getAutoLogin()
  {
    return this.autoLogin;
  }

  public void setAutoLogin(boolean autoLogin)
  {
    this.autoLogin = autoLogin;
  }  

  public String getPassword()
  {
    return this.password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getUsername()
  {
    return this.username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }
  
  /**
   * Resets all properties to their default values.
   * 
   * @param mapping The <code>ActionMapping</code> used to select this instance.
   * @param request The HTTP request being processed.
   */
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
    setPassword(null);
    setUsername(null);    
  }

  /**
   * Performs simple form data validation. The user name and password
   * fields are checked to ensure that they contain data.
   * 
   * @param mapping The <code>ActionMapping</code> used to select this instance.
   * @param request The HTTP request being processed.
   * @return an <code>ActionErrors</code> object containing all validation
   * errors found.
   */
  public ActionErrors validate(ActionMapping mapping,
                               HttpServletRequest request)
  {
    ActionErrors errors = new ActionErrors();

    if (getUsername() == null || getUsername().length() == 0)
    {
      errors.add(ErrorConstants.USERNAME_ERROR_KEY,
        new ActionError("error.required"));
    }

    if (getPassword() == null || getPassword().length() == 0)
    {
      errors.add(ErrorConstants.PASSWORD_ERROR_KEY,
        new ActionError("error.required"));    
    }    

    return errors;
  }
}