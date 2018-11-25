/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : BaseAction.java
 * Classes      : BaseAction 
 */
package com.johntopley.webforum.controller.action;

import org.apache.struts.action.Action;

/**
 * Abstract superclass for Struts <code>Action</code> classes.
 * 
 * @author John Topley
 * @version 1.0
 * 
 */
public abstract class BaseAction extends Action
{
  /**
   * No argument constructor for creating a new <code>BaseAction</code>. Calls
   * the superclass constructor.
   */
  public BaseAction()
  {
    super();   
  }  
}