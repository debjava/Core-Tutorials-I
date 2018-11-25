package com.dds.test;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * @author PIKU
 *
 */
public class PropReader 
{
	private transient Properties properties = null;
	private transient FileInputStream fin = null;
	
	public HashMap readProperties(final String filePath)
	{
		HashMap<Object,Object> hashMap = new HashMap<Object,Object>();
		try
		{
			fin = new FileInputStream(filePath);
			properties = new Properties();
			properties.load(fin);
			final Set set = properties.keySet();
			final Iterator itr = set.iterator();
			while(itr.hasNext())
			{
				final String propKey = (String)itr.next();
				final String propValue = properties.getProperty(propKey);
				hashMap.put(propKey,propValue);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hashMap;
	}
}
