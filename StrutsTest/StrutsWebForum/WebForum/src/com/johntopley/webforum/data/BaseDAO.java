/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : BaseDAO.java
 * Classes      : BaseDAO 
 */
package com.johntopley.webforum.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

/**
 * Abstract superclass for Data Access Objects. Contains code to create a JDBC
 * <code>Connection</code> object from a JNDI data source and resource clean-up
 * code.
 * 
 * @author John Topley
 * @version 1.0
 */
public abstract class BaseDAO 
{
  /**
   * The name of the JNDI data source.
   */
  private static final String JNDI_DATASOURCE = "java:comp/env/jdbc/WebForumDS";

  /**
   * The JNDI data source.
   */
  private DataSource dataSource;
  
  /**
   * No argument constructor for creating a new <code>BaseDAO</code>. Looks up
   * the data source from JNDI.
   * 
   * @throws NamingException if the JNDI lookup of the data source failed.
   */
  public BaseDAO() throws NamingException
  {
    super();
    Context ctx = new InitialContext();
    this.dataSource = (DataSource) ctx.lookup(BaseDAO.JNDI_DATASOURCE);
  }

  /**
   * Utility method for closing JDBC resources.
   * 
   * @param rset A JDBC <code>ResultSet</code> object to close.
   * @param stmt A JDBC <code>Statement</code> object to close.
   * @param conn A JDBC <code>Connection</code> object to close. 
   * @throws SQLException if a resource could not be closed.
   */
  public void closeResources(ResultSet rset, Statement stmt, Connection conn)
    throws SQLException
  {
    if (rset != null)
    {
      rset.close();
    }

    if (stmt != null)
    {
      stmt.close();
    }

    if (conn != null)
    {
      conn.close();
    }  
  }

  /**
   * Returns a JDBC <code>Connection</code> object created from the data source.
   * 
   * @return a JDBC <code>Connection</code>.
   * @throws SQLException if the <code>Connection</code> could not be obtained
   * from the data source.
   */
  public Connection getConnection() throws SQLException
  {
    return this.dataSource.getConnection();
  }  
}