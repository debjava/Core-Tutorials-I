/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : DatabaseConfigBean.java                                 	 *
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
package com.iit.core.bean;

import java.util.Properties;

/**
 * @author Debadatta Mishra
 *
 */
public class DatabaseConfigBean {
	private String dbUserName = null;
	private String dbPassword = null;
	private String dbURL = null;
	private String dbServerPort = null;
	private String dbServerIP = null;
	private String dbSID = null;
	private String dbName = null;
	private String encryptedPWD = null;

	public String getEncryptedPWD() {
		return encryptedPWD;
	}

	public void setEncryptedPWD(String encryptedPWD) {
		this.encryptedPWD = encryptedPWD;
	}

	public DatabaseConfigBean() {
		super();
	}

	public DatabaseConfigBean(Properties prop) {
		super();
		dbName = prop.getProperty("DATABASENAME");
		dbServerIP = prop.getProperty("DATABASE_SERVER_IP");
		dbServerPort = prop.getProperty("DATABASE_SERVER_PORT");
		dbSID = prop.getProperty("DATABASE_SID");
		dbUserName = prop.getProperty("USERNAME");

		//		String tempDbPWD = prop.getProperty("PASSWORD");
		//		dbPassword = Security.getDecryptedString(tempDbPWD);//prop.getProperty("PASSWORD");
		dbPassword = prop.getProperty("PASSWORD");

		dbURL = new StringBuffer("jdbc:oracle:thin:@").append(dbServerIP)
				.append(":").append(dbServerPort).append(":").append(dbSID)
				.toString();
		//jdbc:oracle:thin:@idealdb01:1521:ideal
	}

	public String getDbUserName() {
		return dbUserName;
	}

	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	public String getDbPassword() {
		//		return Security.getDecryptedString( dbPassword );
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		//		String tempEncryptPWD = Security.getEncryptedString( dbPassword );
		//		this.encryptedPWD = tempEncryptPWD ;
		//		this.dbPassword = tempEncryptPWD ;

		this.encryptedPWD = dbPassword;
		this.dbPassword = dbPassword;
	}

	public String getDbURL() {
		return dbURL;
	}

	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}

	public String getDbServerPort() {
		return dbServerPort;
	}

	public void setDbServerPort(String dbServerPort) {
		this.dbServerPort = dbServerPort;
	}

	public String getDbServerIP() {
		return dbServerIP;
	}

	public void setDbServerIP(String dbServerIP) {
		this.dbServerIP = dbServerIP;
	}

	public String getDbSID() {
		return dbSID;
	}

	public void setDbSID(String dbSID) {
		this.dbSID = dbSID;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
}
