package com.dds.test;

import com.dds.common.Common;
import com.dds.util.Logutil;

public class MyTest 
{
	private transient String loggerFileName = "F:/JavaJOB/Logger_log4J/log"+Common.backslash+Common.logFileName;
	Logutil log = new Logutil("MyTest.class" , loggerFileName);
	
	public void show(final String stringVal)
	{
		try {
			log.printInfo("I am in MyTest class");
			log.printInfo(stringVal.indexOf("a"));
			log.printInfo("\n");
			log.printInfo("I am in class MyTest");
			
		}
		catch (Exception e) 
		{
			log.printError(e);
		}
	}
		
	public static void main(String[] args) 
	{
		new MyTest().show("HatiGhodaBagha");
		int res = 5 - (2+3);
		String res1 = null;
		new MyTest().show(res1);
		
	}

}
