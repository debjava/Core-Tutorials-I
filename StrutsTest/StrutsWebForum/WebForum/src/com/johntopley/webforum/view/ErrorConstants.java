/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : ErrorConstants.java
 * Classes      : ErrorConstants 
 */
package com.johntopley.webforum.view;

/**
 * The class <code>ErrorConstants</code> defines Struts error constants used
 * by the user interface.
 *
 * @author John Topley
 * @version 1.0
 */
public class ErrorConstants 
{
  /**
   * Key used to store the forenames error message in the HTTP request.
   */
  public static final String FORENAMES_ERROR_KEY
    = "com.johntopley.webforum.forenameserror";
    
  /**
   * Key used to store the login failure error message in the HTTP request.
   */
  public static final String LOGIN_ERROR_KEY
    = "com.johntopley.webforum.loginerror";
    
  /**
   * Key used to store the message error message in the HTTP request.
   */
  public static final String MESSAGE_ERROR_KEY
    = "com.johntopley.webforum.messageerror";

  /**
   * Key used to store the re-typed password error message in the HTTP request.
   */
  public static final String PASSWORD2_ERROR_KEY
    = "com.johntopley.webforum.password2error";

  /**
   * Key used to store the password error message in the HTTP request.
   */
  public static final String PASSWORD_ERROR_KEY
    = "com.johntopley.webforum.passworderror";  

  /**
   * Key used to store the password mismatch error message in the HTTP request.
   */
  public static final String PASSWORD_MATCH_ERROR_KEY
    = "com.johntopley.webforum.passwordmatcherror";

  /**
   * Key used to store the subject error message in the HTTP request.
   */
  public static final String SUBJECT_ERROR_KEY
    = "com.johntopley.webforum.subjecterror";

  /**
   * Key used to store the user name error message in the HTTP request.
   */
  public static final String USERNAME_ERROR_KEY
    = "com.johntopley.webforum.usernameerror";

  /**
   * Key used to store the existing user name error message in the HTTP request.
   */
  public static final String USERNAME_EXISTS_ERROR_KEY
    = "com.johntopley.webforum.usernameexistserror";

  /**
   * Private constructor to ensure that this class is never instantiated.   
   */
  private ErrorConstants()
  {

    // Empty private constructor.
  }
}