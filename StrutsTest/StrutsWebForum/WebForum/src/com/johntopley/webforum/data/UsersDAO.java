/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : UsersDAO.java
 * Classes      : UsersDAO 
 */
package com.johntopley.webforum.data;

import com.johntopley.webforum.data.BaseDAO;
import com.johntopley.webforum.model.User;
import com.johntopley.webforum.model.Users;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

/**
 * Data Access Object for <code>User</code> and <code>Users</code> objects.
 * 
 * @author John Topley
 * @version 1.0
 * 
 * @see com.johntopley.webforum.model.User
 * @see com.johntopley.webforum.model.Users
 */
public class UsersDAO extends BaseDAO
{
  /**
   * No argument constructor for creating a new <code>UsersDAO</code>. Calls the
   * superclass constructor.
   * 
   * @throws NamingException if thrown by the superclass.
   * 
   * @see com.johntopley.webforum.data.BaseDAO#BaseDAO()
   */
  public UsersDAO() throws NamingException
  {
    super();
  }

  /**
   * Adds a new user account using the specified password.
   * 
   * @param user The <code>User</code> object representing the user to be added.
   * @param password The user's password.
   * @return a <code>Long</code> containing the unique ID of the newly created
   * user account.
   * @throws SQLException if the user could not be added.
   */
  public Long addUser(User user, String password) throws SQLException
  {
    if (user == null)
    {
      throw new IllegalArgumentException("user cannot be null.");
    }

    if (password == null || password.length() == 0)
    {
      throw new IllegalArgumentException(
        "password cannot be null or zero length.");
    }

    Long userID = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;

    StringBuffer sql = new StringBuffer();
    sql.append("INSERT INTO users(")
       .append("            Username ")
       .append("          , Password ")
       .append("          , Forenames ")
       .append("          , Surname ")
       .append("          , CreationDate) ")
       .append("VALUES      (?, ?, ?, ?, ?)");

    try
    {
      conn = super.getConnection();        
      pstmt = conn.prepareStatement(sql.toString());
      pstmt.setString(1, user.getUsername().toLowerCase());
      pstmt.setString(2, password);
      pstmt.setString(3, user.getForenames());
      pstmt.setString(4, user.getSurname());
      pstmt.setDate(5, new Date(System.currentTimeMillis()));
      pstmt.execute();

      sql = new StringBuffer();
      sql.append("SELECT   u.UserID ")
         .append("FROM     Users u ")
         .append("WHERE    u.Username = ?");

      pstmt = conn.prepareStatement(sql.toString());
      pstmt.setString(1, user.getUsername());
      rset = pstmt.executeQuery();

      while (rset.next())
      {
        userID = new Long(rset.getLong("u.UserID"));
      }
    }    
    finally
    {
      super.closeResources(rset, pstmt, conn);
    }

    return userID;
  }

  /**
   * Checks that the specified password matches the specified user account. The 
   * specified password is checked against the plaintext password stored for the
   * specified user in the database. A production system would put the password
   * through a one-way hash function and then compare the result of the function
   * against the password hash stored in the database.
   * 
   * @param username The user name to check the password against.
   * @param password The password to check against the user name.
   * @return a <code>User</code> object if the user's credentials are valid,
   * else <code>null</code>.
   * @throws SQLException if the check could not be performed.
   */
  public User checkUserCredentials(String username, String password)
    throws SQLException
  {
    if (username == null || username.length() == 0)
    {
      throw new IllegalArgumentException(
        "username cannot be null or zero length.");
    }

    if (password == null || password.length() == 0)
    {
      throw new IllegalArgumentException(
        "password cannot be null or zero length.");
    }

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    User user = null;

    StringBuffer sql = new StringBuffer();
    sql.append("SELECT  u.UserID ")
       .append("      , u.Password ")
       .append("FROM    Users u ")
       .append("WHERE   u.Username = ?");

    try
    {
      conn = super.getConnection();
      pstmt = conn.prepareStatement(sql.toString());
      pstmt.setString(1, username);
      rset = pstmt.executeQuery();

      while (rset.next())
      {
        String storedPassword = rset.getString("u.Password");        

        // We should really put the password through a one-way hash function
        // here and compare it against the hash stored in the database.
        if (password.equals(storedPassword))
        {
          Long userID = new Long(rset.getLong("u.UserID"));
          user = this.getUser(userID);
        }        
      }     
    }
    finally
    {
      super.closeResources(rset, pstmt, conn);  
    }

    return user;
  }

  /**
   * Gets the number of posts made by the specified user.
   * 
   * @param userID The unique ID of the user to get the count of posts for.
   * @return a <code>Long</code> containing the number of posts made by the
   * specified user.
   * @throws SQLException if the post count could not be retrieved.
   */
  public Long getPostCount(Long userID) throws SQLException
  {
    if (userID == null || userID.longValue() == 0)
    {
      throw new IllegalArgumentException("userID cannot be null or 0.");
    }

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    Long postCount = new Long(0);

    StringBuffer sql = new StringBuffer();
    sql.append("SELECT  COUNT(p.PostID) AS PostCount ")
       .append("FROM    Posts p ")
       .append("WHERE   p.UserID = ?");
    
    try
    {
      conn = super.getConnection();
      pstmt = conn.prepareStatement(sql.toString());
      pstmt.setLong(1, userID.longValue());
      rset = pstmt.executeQuery();

      while (rset.next())
      {
        postCount = new Long(rset.getInt("PostCount"));
      }      
    }    
    finally
    {
      super.closeResources(rset, pstmt, conn);
    }

    return postCount;
  }

  /**
   * Gets a <code>User</code> object for the specified user ID.
   * 
   * @param userID The unique ID of the user.
   * @return a <code>User</code> object representing the user with the specified
   * ID.
   * @throws SQLException if the user's details could not be retrieved.
   */
  public User getUser(Long userID) throws SQLException
  {
    if (userID == null || userID.longValue() == 0)
    {
      throw new IllegalArgumentException("userID cannot be null or 0.");
    }

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    User user = null;

    StringBuffer sql = new StringBuffer();
    sql.append("SELECT   u.Username ")
       .append("       , u.Forenames ")
       .append("       , u.Surname ")
       .append("FROM     Users u ")
       .append("WHERE    u.UserID = ?");       
    
    try
    {
      conn = super.getConnection();
      pstmt = conn.prepareStatement(sql.toString());
      pstmt.setLong(1, userID.longValue());
      rset = pstmt.executeQuery();

      while (rset.next())
      {
        String username = rset.getString("u.Username");
        String forenames = rset.getString("u.Forenames");
        String surname = rset.getString("u.Surname");
        Long postCount = this.getPostCount(userID);

        user = new User(userID.toString(),
                        username,
                        forenames,
                        surname,
                        postCount.toString());        
      }
    }    
    finally
    {
      super.closeResources(rset, pstmt, conn);
    }

    return user;
  }

  /**
   * Gets the collection of users.
   * 
   * @return a <code>Users</code> object containing the users.
   * @throws SQLException if the users could not be retrieved.
   * 
   * @deprecated
   */
  public Users getUsers() throws SQLException
  {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;
    Users users = new Users();

    StringBuffer sql = new StringBuffer();
    sql.append("SELECT   u.UserID ")
       .append("       , u.Username ")
       .append("       , u.Forenames ")
       .append("       , u.Surname ")
       .append("FROM     Users u");
    
    try
    {
      conn = super.getConnection();
      stmt = conn.createStatement();
      rset = stmt.executeQuery(sql.toString());

      while (rset.next())
      {
        Long userID = new Long(rset.getLong("u.UserID"));
        String username = rset.getString("u.Username");
        String forenames = rset.getString("u.Forenames");
        String surname = rset.getString("u.Surname");
        Long postCount = this.getPostCount(userID);

        User user = new User(userID.toString(),
                             username,
                             forenames,
                             surname,
                             postCount.toString());
                            
        users.addUser(user);
      }      
    }    
    finally
    {
      super.closeResources(rset, stmt, conn);
    }

    return users;
  }

  /**
   * Returns whether there is already a user account for the specified user
   * name.
   * 
   * @param username The user name of the user to check.
   * @return <code>true</code> if the user name is in use, else
   * <code>false</code>.
   * @throws SQLException if the check could not be performed.
   */
  public boolean isExistingUser(String username) throws SQLException
  {
    if (username == null)
    {
      throw new IllegalArgumentException("username cannot be null.");
    }    

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;

    StringBuffer sql = new StringBuffer();
    sql.append("SELECT  COUNT(u.UserID) AS UserCount ")
       .append("FROM    Users u ")
       .append("WHERE   u.Username = ?");

    try
    {
      conn = super.getConnection();
      pstmt = conn.prepareStatement(sql.toString());
      pstmt.setString(1, username);
      rset = pstmt.executeQuery();

      while (rset.next())
      {
        if (rset.getInt("UserCount") > 0)
        {
          return true;           
        }          
      }     
    }    
    finally
    {
      super.closeResources(rset, pstmt, conn);
    }
    
    return false;
  }
}