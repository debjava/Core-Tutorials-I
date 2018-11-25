package com.dds.test;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropeties 
{
	private FileInputStream fin;
	private Properties properties;
	
	public ReadPropeties(String fileName)
	{
		try
		{
			fin = new FileInputStream(fileName);
			properties = new Properties();
			properties.loadFromXML(fin);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void readNShow()
	{
		int size = properties.size();
		System.out.println(" properties size ::: "+size);
	}

	public static void main(String[] args) 
	{
		new ReadPropeties("D:/JavaTempTest/TestProperties/testharness.properties").readNShow();
	}

}
