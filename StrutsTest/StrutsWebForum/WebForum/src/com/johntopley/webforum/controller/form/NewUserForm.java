/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : NewUserForm.java
 * Classes      : NewUserForm 
 */
package com.johntopley.webforum.controller.form;

import com.johntopley.webforum.view.ErrorConstants;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Struts <code>ActionForm</code> corresponding to the registration screen.
 * 
 * @author John Topley
 * @version 1.0 
 */
public class NewUserForm extends ActionForm 
{
  /**
   * Auto-login option.
   */
  private boolean autoLogin;

  /**
   * The user's forenames.
   */
  private String forenames;

  /**
   * The user's password.
   */
  private String password;

  /**
   * Confirmation of the user's password.
   */
  private String password2;

  /**
   * The user's surname.
   */
  private String surname;

  /**
   * The user name the user uses to log in with.
   */
  private String username;

  /**
   * No argument constructor for constructing a new <code>NewUserForm</code>.
   * Calls the superclass constructor.
   */
  public NewUserForm()
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

  public String getForenames()
  {
    return this.forenames;
  }

  public void setForenames(String forenames)
  {
    this.forenames = forenames;
  }

  public String getPassword()
  {
    return this.password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getPassword2()
  {
    return this.password2;
  }

  public void setPassword2(String password2)
  {
    this.password2 = password2;
  }

  public String getSurname()
  {
    return this.surname;
  }

  public void setSurname(String surname)
  {
    this.surname = surname;
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
    setAutoLogin(false);
    setForenames(null);
    setPassword(null);
    setPassword2(null);
    setUsername(null);
  }

  /**
   * Performs simple form data validation. The forenames, user name and password
   * fields are checked to ensure that they contain data, and the password and
   * confirmation password are checked to ensure that they match.
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

    if (getForenames() == null || getForenames().length() == 0)
    {
      errors.add(ErrorConstants.FORENAMES_ERROR_KEY,
        new ActionError("error.required"));
    }

    if (getPassword() == null || getPassword().length() == 0)
    {
      errors.add(ErrorConstants.PASSWORD_ERROR_KEY,
        new ActionError("error.required"));
    }

    if (getPassword2() == null || getPassword2().length() == 0)
    {
      errors.add(ErrorConstants.PASSWORD2_ERROR_KEY,
        new ActionError("error.required"));
    }

    if (getPassword2().length() > 0 && !getPassword().equals(getPassword2()))
    {
      errors.add(ErrorConstants.PASSWORD_MATCH_ERROR_KEY,
        new ActionError("error.password.mismatch"));

      setPassword(null);
      setPassword2(null);
    }

    if (getUsername() == null || getUsername().length() == 0)
    {
      errors.add(ErrorConstants.USERNAME_ERROR_KEY,
        new ActionError("error.required"));
    }

    return errors;
  }
}