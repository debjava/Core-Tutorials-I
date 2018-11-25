package com.dds.util;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class Logutil 
{
	private transient Logger logger = null;
	private transient FileAppender fileAppender = null;
	private transient String className = null;
	private transient String filePath = null;
	
	public Logutil(final String className , final String filePath)
	{
		this.className = className;
		this.filePath = filePath;
		logger = getLogger();
	}
	
	private Logger getLogger()
	{
		Logger logger1 = Logger.getLogger(className);
		SimpleLayout simpleLayout = new SimpleLayout();
		try 
		{
			fileAppender = new FileAppender(simpleLayout, filePath, true);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		logger1.addAppender(fileAppender);
		logger1.setLevel((Level) Level.DEBUG);
		
		return logger1;
	}
	
	public void printInfo(final String message)
	{
		logger.info(message);
	}
	
	public void printInfo(final Object message)
	{
		logger.info(message);
	}
	
	public void printError(final Exception e)
	{
		logger.error("",e);
	}

}
