/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : DatabaseUtil.java                                 	 	 	 *
 * Author                      : Debadatta Mishra                                            *
 * Creation Date               : Nov 25, 2007                                                *
 * Modification History        :                											 *
 *																						     *
 *     Version No.               Date               Brief description of change              *
 *  ---------------------------------------------------------------------------------------  *
 *                       |      			|				 								 *
 *                       |                  |											 	 *
 *  ---------------------------------------------------------------------------------------  *
 *********************************************************************************************/
package com.iit.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.PooledConnection;

import oracle.jdbc.OracleDriver;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;

/**
 * Utility class used for database related operations. Contains method for
 * obtaining and closing connection/statement etc objects from the database
 * 
 * @author Debadatta Mishra
 */
public class DatabaseUtil {

	/**
	 * Obtain a pooled DB Connection for the specified database
	 * 
	 * @param userName
	 *            User name of the database
	 * @param password
	 *            Password of the database
	 * @param dbURL
	 *            DB URL of the database which contains SID
	 * @return Connection object of the database
	 * @throws Exception
	 */
	public static Connection getPooledDbConnection(String userName,
			String password, String dbURL) throws Exception {
		OracleConnectionPoolDataSource ocpds = new OracleConnectionPoolDataSource();
		// Set connection parameters
		ocpds.setURL(dbURL);
		ocpds.setUser(userName);
		ocpds.setPassword(password);
		// Create a pooled connection
		PooledConnection pc = ocpds.getPooledConnection();
		// Get a Logical connection
		Connection conn = pc.getConnection();
		return conn;
	}

	/**
	 * Obtain DB connection(without pooling)
	 * 
	 * @param userName
	 *            User name of the database
	 * @param password
	 *            Password of the DB
	 * @param dbURL
	 *            DB URL which also contains SID
	 * @return Connection object
	 */
	public static Connection getDbConnection(String userName, String password,
			String dbURL) {
		Connection connection = null;
		// Obtain a connection using Driver Manager
		try {
			DriverManager.registerDriver(new OracleDriver());
			connection = DriverManager.getConnection(dbURL, userName, password);
		} catch (SQLException se) {
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			se.printStackTrace();
		}
		return connection;
	}

	/**
	 * Function to close result set
	 * 
	 * @param resultSet
	 *            Result set object to be closed
	 * @return boolean indicating the success/failure of the operation
	 */
	public static boolean closeResultSet(ResultSet resultSet) {
		boolean checkFlag = false;
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkFlag;
	}

	/**
	 * Function to close statement
	 * 
	 * @param stmt
	 *            Statement object to be closed
	 * @return boolean indicating the success/failure of the operation
	 */
	public static boolean closeStatement(Statement stmt) {
		boolean checkFlag = false;
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkFlag;
	}

	/**
	 * Function to close prepared statement
	 * 
	 * @param pstmt
	 *            Prepared statement to be closed
	 * @return boolean indicating the success/failure of the operation
	 */
	public static boolean closePreparedStatement(PreparedStatement pstmt) {
		boolean checkFlag = false;
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkFlag;
	}

	/**
	 * Function to close connection
	 * 
	 * @param connection
	 *            Connection to be closed
	 * @return boolean indicating the success/failure of the operation
	 */
	public static boolean closeConnection(Connection connection) {
		boolean checkFlag = false;
		return checkFlag;
	}
}
