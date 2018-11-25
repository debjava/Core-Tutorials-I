/*
 * Created on Feb 19, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.rrs.vps.dds.testlog4j;

import org.apache.log4j.Logger;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Test 
{
	static Logger logger = new Log4Utility().getLog4logger("Test.class","E:/Shiba.log");

	public static void main(String[] args) 
	{
		logger.info(" HEllo Shiba");
	}
}
