package com.dds.test.prop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Properties;

/**
 * This class is used to read 
 * an existing property file
 * and to show the data to the
 * user.It is used to be generic
 * type.
 * @author PIKU
 *
 */
public class ProptiesReader 
{
	private transient String propertiesPath = null;
	private transient FileInputStream fin = null;
	private transient Properties properties = null;
	private transient HashMap propertiesValue = new HashMap();
	
	public ProptiesReader(final String propertiesPath)
	{
		try
		{
			this.propertiesPath = propertiesPath;
			fin = new FileInputStream(propertiesPath);
			properties = new Properties();
			properties.load(fin);
		}
		catch(FileNotFoundException fnfe)
		{
			fnfe.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public ProptiesReader()
	{
		
	}
	
	public void readProperties(final String filePath)
	{
		try
		{
			fin = new FileInputStream(propertiesPath);
			properties = new Pr