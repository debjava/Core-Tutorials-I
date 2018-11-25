/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : Users.java
 * Classes      : Users 
 */
package com.johntopley.webforum.model;

import com.johntopley.webforum.model.User;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A custom collection of <code>User</code> objects.
 *
 * @author John Topley
 * @version 1.0
 */
public class Users 
{
  /**
   * The collection of <code>User</code> objects.
   */
  private Collection users;
  
  /**
   * No argument constructor for constructing a new <code>Users</code>
   * collection.
   *
   */
  public Users()
  {
    super();
    users = new ArrayList();
  }

  /**
   * Adds a <code>User</code> object to the collection of <code>User</code>
   * objects.
   *
   * @param user The <code>User</code> object to be added to the collection.
   */
  public void addUser(User user)
  {
    this.users.add(user);
  }

  /**
   * Returns the collection of <code>User</code> objects.
   *
   * @return the collection of <code>User</code> objects.
   */
  public Collection getUsers()
  {
    return this.users;
  }
}
