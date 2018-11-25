package com.dds.db.beans;

public class DbConBeans 
{
	private transient String databseURL;
	private transient String databaseUSER;
	private transient String databasePWD;
	/**
	 * @return Returns the databasePWD.
	 */
	public String getDatabasePWD() {
		return databasePWD;
	}
	/**
	 * @param databasePWD The databasePWD to set.
	 */
	public void setDatabasePWD(String databasePWD) {
		this.databasePWD = databasePWD;
	}
	/**
	 * @return Returns the databaseUSER.
	 */
	public String getDatabaseUSER() {
		return databaseUSER;
	}
	/**
	 * @param databaseUSER The databaseUSER to set.
	 */
	public void setDatabaseUSER(String databaseUSER) {
		this.databaseUSER = databaseUSER;
	}
	/**
	 * @return Returns the databseURL.
	 */
	public String getDatabseURL() {
		return databseURL;
	}
	/**
	 * @param databseURL The databseURL to set.
	 */
	public void setDatabseURL(String databseURL) {
		this.databseURL = databseURL;
	}

}
