package com.dds.test;

import com.dds.util.MyLogger;

public class Test 
{
	private transient String logFile = "F:/JavaJOB/Javautillogger/log/appln1.log";
	private MyLogger myLogger = new MyLogger("Test.class",logFile);
	
	public void show(final String str)
	{
		try 
		{
			final String msg = str.substring(str.indexOf("as"));
			myLogger.printInfo("Now String ::: "+msg);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			myLogger.printException(e);
		}
	}
	
	public static void main(String[] args) 
	{
		String xx = "hatiasdfgh";
		xx = null;
		new Test().show(xx);
		
	}

}
