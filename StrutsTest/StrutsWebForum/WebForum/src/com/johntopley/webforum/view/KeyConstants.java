/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : KeyConstants.java
 * Classes      : KeyConstants 
 */
package com.johntopley.webforum.view;

/**
 * The class <code>KeyConstants</code> defines keys used to store objects in the
 * HTTP session and request.
 *
 * @author John Topley
 * @version 1.0
 */
public class KeyConstants 
{
  /**
   * Key used to store the post ID in the HTTP session.
   */
  public static final String POST_ID_KEY = "com.johntopley.webforum.postid";

  /**
   * Key used to store the list of posts in the HTTP request.
   */
  public static final String POST_LIST_KEY = "com.johntopley.webforum.postlist";

  /**
   * Key used to store the post subject in the HTTP request.
   */
  public static final String POST_SUBJECT_KEY
    = "com.johntopley.webforum.postsubject";

  /**
   * Key used to store the <code>User</code> object in the HTTP session.
   */
  public static final String USER_KEY = "com.johntopley.webforum.user";

  /**
   * Private constructor to ensure that this class is never instantiated.   
   */
  private KeyConstants()
  {

    // Empty private constructor.
  }
}