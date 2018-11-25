/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : UserCookie.java
 * Classes      : UserCookie 
 */
package com.johntopley.webforum.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A representation of the browser cookie containing the user ID of the
 * currently logged in user.
 *
 * @author John Topley
 * @version 1.0
 */
public class UserCookie 
{
  /**
   * The maximum age of the cookie (thirty days).
   */
  private static final int COOKIE_MAX_AGE = 60 * 60 * 24 * 30;

  /**
   * The name of the cookie.
   */
  private static final String COOKIE_NAME = "com.johntopley.webforum.userid";
  
  /**
   * The user ID.
   */
  private String userID;
  
  /**
   * Constructor for constructing a new <code>UserCookie</code>. The
   * <code>userID</code> instance variable is initialised to the value stored in
   * the cookie, if it exists.
   * 
   * @param request The HTTP request being processed.
   */
  public UserCookie(HttpServletRequest request)
  {
    super();

    // Initialise the user ID to the value stored in the cookie, if it exists.
    Cookie[] cookies = request.getCookies();      

    if (cookies != null)
    {
      for (int i = 0; i < cookies.length; i++) 
      {
        if (cookies[i].getName().equals(COOKIE_NAME))
        {
          setUserID(cookies[i].getValue());
        }
      }
    }
  }

  /**
   * Sets the cookie to expire immediately.
   * 
   * @param response The HTTP response being processed.
   */
  public void expire(HttpServletResponse response)
  {
    Cookie forumCookie = new Cookie(COOKIE_NAME, null);

    // Setting max age to zero expires the cookie.
    forumCookie.setMaxAge(0);
    response.addCookie(forumCookie);
  }

  /**
   * Returns the user ID.
   * 
   * @return the user ID.
   */
  public String getUserID()
  {
    return this.userID;
  }

  /**
   * Sets the user ID.
   * 
   * @param userID The user ID.
   */
  public void setUserID(String userID)
  {
    this.userID = userID;
  }

  /**
   * Saves the cookie in the HTTP response.
   * 
   * @param response The HTTP response being processed.
   */
  public void save(HttpServletResponse response)
  {
    Cookie forumCookie = new Cookie(COOKIE_NAME, getUserID());            
    forumCookie.setMaxAge(COOKIE_MAX_AGE);
    response.addCookie(forumCookie);
  }
}