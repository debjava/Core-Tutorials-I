package com.dds.util;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger 
{
	private transient String filePath = null;
	private transient String className = null;
	private transient Logger logger = null;
	private transient Handler handler = null;
	
	public MyLogger(final String className , final String filePath)
	{
		this.className = className;
		this.filePath = filePath;
		logger = getLogger();
	}
	
	private Logger getLogger()
	{
		Logger logger1 = Logger.getLogger(className);
		try
		{
			handler = new FileHandler(filePath,true);
		}
		catch(Exception e)
		{
			handler = new ConsoleHandler();
		}
		logger1.addHandler(handler);
		handler.setFormatter(new SimpleFormatter());
		
		return logger1;
	}
	
	public void printInfo(Object message)
	{
		logger.info((String)message);
	}
	
	public void printException(Throwable t)
	{
		logger.log(Level.SEVERE,"",t);
	}

}
