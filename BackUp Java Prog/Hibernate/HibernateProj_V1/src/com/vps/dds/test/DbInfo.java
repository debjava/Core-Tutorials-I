/*
 * Created on Feb 26, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.vps.dds.test;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DbInfo 
{
	String driverName;
	String dbURL;
	String dbUserName;
	String dbPassword;
	

	/**
	 * @return Returns the dbPassword.
	 */
	public String getDbPassword() 
	{
		return dbPassword;
	}
	/**
	 * @param dbPassword The dbPassword to set.
	 */
	public void setDbPassword(String dbPassword) 
	{
		this.dbPassword = dbPassword;
	}
	/**
	 * @return Returns the dbUser.
	 */
	public String getDbUser() 
	{
		return dbURL;
	}
	
	/**
	 * @param dbUserName The dbUserName to set.
	 */
	public void setDbUserName(String dbUserName) 
	{
		this.dbUserName = dbUserName;
	}
	/**
	 * @return Returns the driverName.
	 */
	public String getDriverName() 
	{
		return driverName;
	}
	/**
	 * @param driverName The driverName to set.
	 */
	public void setDriverName(String driverName) 
	{
		this.driverName = driverName;
	}
	/**
	 * @return Returns the dbURL.
	 */
	public String getDbURL() {
		return dbURL;
	}
	/**
	 * @param dbURL The dbURL to set.
	 */
	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}
	/**
	 * @return Returns the dbUserName.
	 */
	public String getDbUserName() {
		return dbUserName;
	}
}
