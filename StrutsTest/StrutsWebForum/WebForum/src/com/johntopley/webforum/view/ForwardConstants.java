/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : ForwardConstants.java
 * Classes      : ForwardConstants 
 */
package com.johntopley.webforum.view;

/**
 * The class <code>ForwardConstants</code> defines constants for Struts
 * <code>ActionForward</code>s used by the <code>Action</code> classes.
 *
 * @author John Topley
 * @version 1.0
 */
public class ForwardConstants 
{
  /**
   * Struts local ActionForward for the Topic page.
   */
  public static final String TOPIC_PAGE = "Topic";

  /**
   * Struts local ActionForward for the Topics page.
   */
  public static final String TOPICS_PAGE = "Topics";

  /**
   * Struts global ActionForward for View Topic.
   */
  public static final String VIEW_TOPIC = "ViewTopic";

  /**
   * Struts global ActionForward for View Topics.
   */
  public static final String VIEW_TOPICS = "ViewTopics";

  /**
   * Private constructor to ensure that this class is never instantiated.   
   */
  private ForwardConstants()
  {

    // Empty private constructor.
  }
}