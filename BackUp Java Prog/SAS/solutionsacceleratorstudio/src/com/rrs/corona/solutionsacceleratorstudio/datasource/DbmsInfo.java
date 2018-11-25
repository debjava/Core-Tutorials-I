

package com.rrs.corona.solutionsacceleratorstudio.datasource;
/**
 * 
 * @author Debadatta Mishra
 *
 */

public class DbmsInfo 
{
	String dbUrl;
	String dbUser;
	String dbPassword;
	String dataSourceName;
	
	/**
	 * @return Returns the password.
	 */
	public String getDbPassword() 
	{
		return dbPassword;
	}
	/**
	 * @param pwd The password to set.
	 */
	public void setDbPassword(String pwd) 
	{
		this.dbPassword = pwd;
	}
	/**
	 * @return Returns the url.
	 */
	public String getDbUrl() 
	{
		return dbUrl;
	}
	/**
	 * @param url The url to set.
	 */
	public void setDbUrl(String url) 
	{
		this.dbUrl = url;
	}
	/**
	 * @return Returns the user.
	 */
	public String getDbUser() 
	{
		return dbUser;
	}
	/**
	 * @param user The user to set.
	 */
	public void setDbUser(String user) 
	{
		this.dbUser = user;
	}
	/**
	 * @return Returns the dataSourceName.
	 */
	public String getDataSourceName() 
	{
		return dataSourceName;
	}
	/**
	 * @param dataSourceName The dataSourceName to set.
	 */
	public void setDataSourceName(String dataSourceName) 
	{
		this.dataSourceName = dataSourceName;
	}
	
	
}
