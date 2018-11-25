package com.dds.test;
 
/**
 * @author PIKU
 *
 */
public class TranObj 
{
	/**
	 * use of transient variable
	 */
	transient String stringName ;

	/**
	 * @return Returns the stringName.
	 */
	public String getStringName() {
		return stringName;
	}

	/**
	 * @param stringName The stringName to set.
	 */
	public void setStringName(String stringName) {
		this.stringName = stringName;
	}
	
}
