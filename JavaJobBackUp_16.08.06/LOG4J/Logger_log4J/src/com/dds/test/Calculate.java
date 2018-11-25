package com.dds.test;

import com.dds.common.Common;
import com.dds.util.Logutil;

public class Calculate 
{
	private transient String loggerFileName = "F:/JavaJOB/Logger_log4J/log"+Common.backslash+Common.logFileName;
	Logutil log = new Logutil("MyTest.class" , loggerFileName);
	
	public int multiplicate(final int a , final int b)
	{
		log.printInfo("************* Multiplication Begins Here *******************");
		log.printInfo("Values ::: "+(a*b));
		return (a*b);
	}
	
	public static void main(String[] args) 
	{
		new Calculate().multiplicate(10,23);
		
	}

}
