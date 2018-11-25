/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : User.java
 * Classes      : User 
 */
package com.johntopley.webforum.model;

/**
 * Class representing an individual user.
 * 
 * @author John Topley
 * @version 1.0
 */
public class User 
{
  /**
   * The user's forenames.
   */
  private String forenames;

  /**
   * The number of posts the user has made.
   */
  private String postCount;

  /**
   * The user's surname.
   */
  private String surname;

  /**
   * The unique ID of the user.
   */
  private String userID;

  /**
   * The user name the user uses to log in with.
   */
  private String username;
  
  /**
   * No argument constructor for creating a new <code>User</code>.
   */
  public User()
  {
    super();
  }

  /**
   * Overloaded constructor for creating a new <code>User</code> object from the
   * passed arguments.
   * 
   * @param userID The unique ID of the user.
   * @param username The user name the user uses to log in with.
   * @param forenames The user's forenames.
   * @param surname The user's surname.
   * @param postCount The number of posts the user has made.
   */
  public User(String userID,
              String username,
              String forenames,
              String surname,
              String postCount)
  {
    this();
    setUserID(userID);
    setUsername(username);
    setForenames(forenames);
    setSurname(surname);
    setPostCount(postCount);
  }

  /**
   * Returns a formatted version of the user's full name. The returned name is
   * of the format <code>Forenames Surname</code>, unless
   * <code>Surname</code> is <code>null</code>, in which case
   * <code>Forenames</code> is returned.
   * 
   * @return The full name of the user.
   */
  public String getDisplayName()
  {
    return (getSurname() == null) ? getForenames() :
                                    getForenames() + " " + getSurname();
  }

  /**
   * Returns the user's forenames.
   * 
   * @return the user's forenames.
   */
  public String getForenames()
  {
    return this.forenames;
  }

  /**
   * Sets the user's forenames.
   * 
   * @param forenames The user's forenames.
   */
  public void setForenames(String forenames)
  {
    this.forenames = forenames;
  }

  /**
   * Returns the number of posts the user has made.
   * 
   * @return the number of posts the user has made.
   */
  public String getPostCount()
  {
    return this.postCount;
  }

  /**
   * Sets the number of posts the user has made.
   * 
   * @param postCount The number of posts the user has made.
   */
  public void setPostCount(String postCount)
  {
    this.postCount = postCount;
  }

  /**
   * Returns the user's surname.
   * 
   * @return the user's surname.
   */
  public String getSurname()
  {
    return this.surname;
  }

  /**
   * Sets the user's surname.
   * 
   * @param surname The user's surname.
   */
  public void setSurname(String surname)
  {
    this.surname = surname;
  }

  /**
   * Returns the unique ID of the user.
   * 
   * @return the ID of the user.
   */
  public String getUserID()
  {
    return this.userID;
  }

  /**
   * Sets the unique ID of the user.
   * 
   * @param userID The ID of the user.
   */
  public void setUserID(String userID)
  {
    this.userID = userID;
  }

  /**
   * Returns the user name the user uses to log in with.
   * 
   * @return the user's forenames.
   */
  public String getUsername()
  {
    return this.username;
  }

  /**
   * Sets the user name the user uses to log in with.
   * 
   * @param username The user name the user uses to log in with.
   */
  public void setUsername(String username)
  {
    this.username = username;
  }
}
