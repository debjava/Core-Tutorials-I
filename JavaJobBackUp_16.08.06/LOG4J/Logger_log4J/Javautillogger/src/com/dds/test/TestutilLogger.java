package com.dds.test;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TestutilLogger 
{
	public static void main(String[] args) 
	{
		Logger logger = Logger.getLogger("TestutilLogger.class");
		Handler handler = null;
		try
		{
			handler = new FileHandler("F:/JavaJOB/Javautillogger/log/appln.log",true);
		}
		catch(Exception e)
		{
			System.out.println("Exception thrown here...........");
			handler = new ConsoleHandler();
		}
		logger.addHandler(handler);
		handler.setFormatter(new SimpleFormatter());
		
		logger.info("First line written.......");
		logger.severe("It is severe ***********");
		
	}

}
